package com.amberblue.fetch4me.controllers;

import com.amberblue.fetch4me.beans.Order;
import com.amberblue.fetch4me.beans.ShipmentAccepted;
import com.amberblue.fetch4me.entities.Shipment;
import com.amberblue.fetch4me.services.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@RestController
@RequestMapping(value = "/shipment")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @RequestMapping(value = "/makeRequest", method = RequestMethod.POST, consumes = "application/json")
    private void makeRequest(@RequestBody Order order){
        shipmentService.makeRequest(order);
    }

    @RequestMapping(value = "/accept", method = RequestMethod.POST, consumes = "application/json")
    private Map<String, Integer> accept(@RequestBody ShipmentAccepted shipmentAccepted){
        return shipmentService.accept(shipmentAccepted);
    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST, consumes = "application/json")
    private void updateStatus(@RequestBody Shipment shipment){
        shipmentService.updateStatus(shipment);
    }


    @RequestMapping(value = "/updateStatus", method = RequestMethod.GET)
    private Map<String, Integer>findNumberOfPeopleHelped(){
       int number = shipmentService.findNumberOfPeopleHelped();
        Map<String,Integer> map = new HashMap<>();
        map.put("peopleHelped",number);
        return  map;

    }
}
