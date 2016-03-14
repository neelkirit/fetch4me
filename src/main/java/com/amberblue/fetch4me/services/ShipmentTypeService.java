package com.amberblue.fetch4me.services;

import com.amberblue.fetch4me.entities.ShipmentType;
import com.amberblue.fetch4me.repositories.ShipmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@Service
public class ShipmentTypeService {

    @Autowired
    private ShipmentTypeRepository shipmentTypeRepository;

    public void save(ShipmentType shipmentType){
        shipmentTypeRepository.save(shipmentType);
    }

    public List<ShipmentType> fetchAll(){
        return (List<ShipmentType>) shipmentTypeRepository.findAll();
    }

    public ShipmentType findByType(int type){
        return shipmentTypeRepository.findByType(type);
    }
}
