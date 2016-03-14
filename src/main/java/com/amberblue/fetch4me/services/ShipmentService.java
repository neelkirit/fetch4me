package com.amberblue.fetch4me.services;

import com.amberblue.fetch4me.beans.LatLong;
import com.amberblue.fetch4me.beans.Order;
import com.amberblue.fetch4me.beans.ShipmentAccepted;
import com.amberblue.fetch4me.entities.Location;
import com.amberblue.fetch4me.entities.Shipment;
import com.amberblue.fetch4me.repositories.ShipmentRepository;
import com.amberblue.fetch4me.utils.Constants;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@Service
public class ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ShipmentTypeService shipmentTypeService;

    @Autowired
    private ShipperService shipperService;

    @Autowired
    private ShipmentStatusService shipmentStatusService;

    @Autowired
    private PoolService poolService;

    @Autowired
    private EntityManager entityManager;

    private RestTemplate restTemplate = new RestTemplate();

    private List<HttpMessageConverter<?>> httpMessageConverterList = new ArrayList<>();

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM, yyyy h:mm a");

    private Date pickupTime;

    private Date deliveryTime;

    public void save(Shipment shipment){
        shipmentRepository.save(shipment);
    }

    public void makeRequest(Order order) {
        buildRestTemplate();

        Shipment shipment= new Shipment();
        shipment.setUser(userService.findById(order.getUserId()));
        try {
            shipment.setPickupTime(simpleDateFormat.parse(order.getPickupTime()));
            shipment.setDropTime(simpleDateFormat.parse(order.getDeliveryTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        shipment.setShipmentType(shipmentTypeService.findByType(order.getOrderType()));
        shipment.setItemPrice(order.getProductPrice());

        LatLong pickupLatLong = addressToLatLng(order.getPickupAddress());

        Location pickupLocation = new Location();
        pickupLocation.setAddress(order.getPickupAddress());
        pickupLocation.setLatitude(pickupLatLong.getLatitude());
        pickupLocation.setLongitude(pickupLatLong.getLongitude());
        shipment.setPickupLocation(pickupLocation);

        LatLong dropoffLatLong = addressToLatLng(order.getDropoffAddress());

        Location dropoffLocation = new Location();
        dropoffLocation.setAddress(order.getDropoffAddress());
        dropoffLocation.setLatitude(dropoffLatLong.getLatitude());
        dropoffLocation.setLongitude(dropoffLatLong.getLongitude());
        shipment.setDropoffLocation(dropoffLocation);

        shipment.setActive(true);
        shipment.setProcessed(true);
        shipment.setShipmentStatus(shipmentStatusService.findByType(1));
        Shipment retrievedShipment = shipmentRepository.save(shipment);

        poolService.addToShipmentPool(shipment);
//        expireShipment(retrievedShipment);
    }

    public void expireShipment(Shipment shipment){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(120000);
                    Shipment retrievedShipment = shipmentRepository.findById(shipment.getId());
                    shipment.setProcessed(false);
                    entityManager.merge(shipment);
                    poolService.removeFromShipmentPool(shipment );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.run();
    }

    public void buildRestTemplate(){
        httpMessageConverterList.add(new FormHttpMessageConverter());
        httpMessageConverterList.add(new StringHttpMessageConverter());
        httpMessageConverterList.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(httpMessageConverterList);
    }

    public LatLong addressToLatLng(String address){
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        address = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address.replace(" ", "+") + "&key=" + Constants.GOOGLE_API_KEY;

        ResponseEntity<String> response = restTemplate.getForEntity(address, String.class);
        if(response.getStatusCode() == HttpStatus.OK){
            JSONObject jsonObject = new JSONObject(response.getBody());
            JSONObject locationObject = jsonObject.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
            LatLong latLong = new LatLong();
            latLong.setLatitude(locationObject.getDouble("lat"));
            latLong.setLongitude(locationObject.getDouble("lng"));
            return latLong;
        } else {
            return null;
        }
    }

//    public Double calculateDistance(String userAddress, String shipperAddress){
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//
//        String address = "https://maps.googleapis.com/maps/api/distancematrix/json?" + "origins=" + userAddress.replace(" ", "+") + "&destinations=" + shipperAddress.replace(" ", "+");
//
//        System.out.println(address);
//
//        ResponseEntity<String> response = restTemplate.getForEntity(address, String.class);
//        if(response.getStatusCode() == HttpStatus.OK){
//            JSONObject jsonObject = new JSONObject(response.getBody());
//            JSONObject distanceObject = jsonObject.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("distance");
//            String distanceString = distanceObject.getString("text").split(" ")[0];
//            return Double.valueOf(distanceString);
//        } else {
//            return null;
//        }
//    }

    public List<Shipment> findActiveShipments(){
        return shipmentRepository.findActiveShipments();
    }

    public Map<String, Integer> accept(ShipmentAccepted shipmentAccepted){
        Map<String, Integer> map = new HashMap<>();
        Shipment retrievedShipment = shipmentRepository.findById(shipmentAccepted.getShipmentId());
        if(poolService.getShipmentPool().contains(retrievedShipment)){
            retrievedShipment.setShipper(shipperService.findById(shipmentAccepted.getShipperId()));
            retrievedShipment.setActive(false);
            retrievedShipment.setShipmentStatus(shipmentStatusService.findByType(2));
            entityManager.merge(retrievedShipment);
            poolService.removeFromShipmentPool(retrievedShipment);
            map.put("status", 1);
            return map;
        }
        map.put("status", 0);
        return map;
    }

    public void updateStatus(Shipment shipment){
        Shipment retrievedShipment = shipmentRepository.findById(shipment.getId());
        retrievedShipment.setShipmentStatus(shipmentStatusService.findByType(shipment.getTransientStatusType()));
        entityManager.merge(retrievedShipment);
    }

    public int findNumberOfPeopleHelped(){
        return shipmentRepository.findCompletedOrders().size();
    }
}
