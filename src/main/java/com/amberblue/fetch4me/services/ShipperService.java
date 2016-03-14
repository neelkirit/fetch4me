package com.amberblue.fetch4me.services;

import com.amberblue.fetch4me.beans.Rating;
import com.amberblue.fetch4me.entities.Shipment;
import com.amberblue.fetch4me.entities.Shipper;
import com.amberblue.fetch4me.repositories.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@Service
public class ShipperService {

    @Autowired
    private ShipperRepository shipperRepository;

    @Autowired
    private PoolService poolService;

    @Autowired
    private ShipmentService shipmentService;

    @Autowired
    private EntityManager entityManager;

    public void save(Shipper shipper){
        shipperRepository.save(shipper);
    }

    public Shipper findById(String id){
        return shipperRepository.findById(id);
    }

    @Transactional
    public void goOnline(Shipper shipper){
        Shipper retrievedShipper = shipperRepository.findById(shipper.getId());
        retrievedShipper.setOnline(true);
        entityManager.merge(retrievedShipper);
        poolService.addToShipperPool(retrievedShipper);
    }

    @Transactional
    public void goOffline(Shipper shipper){
        Shipper retrievedShipper = shipperRepository.findById(shipper.getId());
        retrievedShipper.setOnline(false);
        entityManager.merge(retrievedShipper);
        poolService.removeFromShipperPool(retrievedShipper);
    }

    @Transactional
    public Shipment update(Shipper shipper){
        Shipper retrievedShipper = shipperRepository.findById(shipper.getId());
        retrievedShipper.getLocation().setAddress(shipper.getLocation().getAddress());
        entityManager.merge(retrievedShipper);
        if(poolService.getShipmentPool().size() > 0){
            Shipment shipment = poolService.getShipmentPool().get(0);
//            double distance = shipmentService.calculateDistance(shipment.getPickupLocation().getAddress(), shipper.getLocation().getAddress());
//            if(distance < 1.5){
                return poolService.getShipmentPool().get(0);
//            } else {
//                return null;
//            }
        } else {
            return null;
        }
    }

    public List<Shipper> findOnlineShippers(){
        return shipperRepository.findOnlineShippers();
    }

    @Transactional
    public Map<String, Object> login(Shipper shipper){
        String email = shipper.getEmail();
        Map<String, Object> map = new HashMap<>();
        Shipper oldShipper;
        int status = 0;
        // status = 1 social sign up completed
        // status = 0 request failed
        oldShipper = shipperRepository.findByEmail(email);
        if(oldShipper == null) {
            oldShipper = shipperRepository.save(shipper);
            status = 1;
        } else {
            status = 1;
        }
        map.put("shipper", oldShipper);
        map.put("status", status);
        return map;
    }

    public void rateShipper(Rating rating){
        Shipper retrievedShipper = shipperRepository.findById(rating.getId());
        double newRating = (retrievedShipper.getRating()*retrievedShipper.getRatingCount() + rating.getRating())/(retrievedShipper.getRatingCount() + 1);
        retrievedShipper.setRating(newRating);
        retrievedShipper.setRatingCount(retrievedShipper.getRatingCount() + 1);
        entityManager.merge(retrievedShipper);
    }
}
