package com.amberblue.fetch4me.services;

import com.amberblue.fetch4me.entities.ShipmentStatus;
import com.amberblue.fetch4me.repositories.ShipmentStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@Service
public class ShipmentStatusService {

    @Autowired
    private ShipmentStatusRepository shipmentStatusRepository;

    public void save(ShipmentStatus shipmentStatus){
        shipmentStatusRepository.save(shipmentStatus);
    }

    public ShipmentStatus findByType(int type){
        return shipmentStatusRepository.findByType(type);
    }
}
