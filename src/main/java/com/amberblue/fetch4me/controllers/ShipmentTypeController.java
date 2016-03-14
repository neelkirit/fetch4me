package com.amberblue.fetch4me.controllers;

import com.amberblue.fetch4me.entities.ShipmentType;
import com.amberblue.fetch4me.services.ShipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@RestController
@RequestMapping(value = "/shipmentType")
public class ShipmentTypeController {

    @Autowired
    private ShipmentTypeService shipmentTypeService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    private void save(@RequestBody ShipmentType shipmentType){
        shipmentTypeService.save(shipmentType);
    }

    @RequestMapping(value = "/fetchAll", method = RequestMethod.GET)
    private @ResponseBody List<ShipmentType> fetchAll(){
        return shipmentTypeService.fetchAll();
    }

}
