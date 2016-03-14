package com.amberblue.fetch4me.controllers;

import com.amberblue.fetch4me.entities.ShipmentStatus;
import com.amberblue.fetch4me.services.ShipmentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@RestController
@RequestMapping(value = "/shipmentStatus")
public class ShipmentStatusController {

    @Autowired
    private ShipmentStatusService shipmentStatusService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    private void save(@RequestBody ShipmentStatus shipmentStatus){
        shipmentStatusService.save(shipmentStatus);
    }

}
