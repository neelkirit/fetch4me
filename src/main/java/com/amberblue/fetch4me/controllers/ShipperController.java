package com.amberblue.fetch4me.controllers;

import com.amberblue.fetch4me.beans.Rating;
import com.amberblue.fetch4me.entities.Shipment;
import com.amberblue.fetch4me.entities.Shipper;
import com.amberblue.fetch4me.services.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by akash.mercer on 20-02-2016.
 */
@RestController
@RequestMapping(value = "/shipper")
public class ShipperController {

    @Autowired
    private ShipperService shipperService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    private @ResponseBody Map<String, Object> login(@RequestBody Shipper shipper){
        return shipperService.login(shipper);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    private Shipment update(@RequestBody Shipper shipper){
        return shipperService.update(shipper);
    }

    @RequestMapping(value = "/goOnline", method = RequestMethod.POST, consumes = "application/json")
    private void goOnline(@RequestBody Shipper shipper){
        shipperService.goOnline(shipper);
    }

    @RequestMapping(value = "/goOffline", method = RequestMethod.POST, consumes = "application/json")
    private void goOffline(@RequestBody Shipper shipper){
        shipperService.goOffline(shipper);
    }

    @RequestMapping(value = "/rateShipper", method = RequestMethod.POST, consumes = "application/json")
    private void rateUser(@RequestBody Rating rating){
        shipperService.rateShipper(rating);
    }
}
