package com.amberblue.fetch4me.controllers;

import com.amberblue.fetch4me.entities.Shipment;
import com.amberblue.fetch4me.entities.Shipper;
import com.amberblue.fetch4me.services.PoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@RestController
@RequestMapping(value = "/pool")
public class PoolController {

    @Autowired
    private PoolService poolService;

    @RequestMapping(value = "/populateShipperPool", method = RequestMethod.GET)
    private @ResponseBody List<Shipper> populateShipperPool(){
        return poolService.populateShipperPool();
    }

    @RequestMapping(value = "/getShipperPool", method = RequestMethod.GET)
    private @ResponseBody Shipper getShipperPool(){
        return poolService.getShipperPool().get(0);
    }

    @RequestMapping(value = "/populateShipmentPool", method = RequestMethod.GET)
    private @ResponseBody List<Shipment> populateShipmentPool(){
        return poolService.populateShipmentPool();
    }

    @RequestMapping(value = "/getShipmentPool", method = RequestMethod.GET)
    private @ResponseBody List<Shipment> getShipmentPool(){
        return poolService.getShipmentPool();
    }
}
