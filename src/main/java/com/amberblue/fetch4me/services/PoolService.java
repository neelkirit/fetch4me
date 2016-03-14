package com.amberblue.fetch4me.services;

import com.amberblue.fetch4me.entities.Shipment;
import com.amberblue.fetch4me.entities.Shipper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@Service
public class PoolService {

    @Autowired
    private ShipperService shipperService;

    @Autowired
    private ShipmentService shipmentService;

    private List<Shipper> shipperList = new ArrayList<>();

    private List<Shipment> shipmentList = new ArrayList<>();

    public List<Shipper> populateShipperPool(){
        shipperList = shipperService.findOnlineShippers();
        return shipperList;
    }

    public List<Shipment> populateShipmentPool(){
        shipmentList = shipmentService.findActiveShipments();
        return shipmentList;
    }

    public List<Shipper> getShipperPool(){
        return shipperList;
    }

    public void addToShipperPool(Shipper shipper){
        shipperList.add(shipper);
    }

    public void removeFromShipperPool(Shipper shipper){
        shipperList.remove(shipper);
    }

    public List<Shipment> getShipmentPool(){
        return shipmentList;
    }

    public void addToShipmentPool(Shipment Shipment){
        shipmentList.add(Shipment);
    }

    public void removeFromShipmentPool(Shipment Shipment){
        shipmentList.remove(Shipment);
    }
}
