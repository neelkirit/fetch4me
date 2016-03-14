package com.amberblue.fetch4me.services;

import com.amberblue.fetch4me.entities.Location;
import com.amberblue.fetch4me.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public void save(Location location){
        locationRepository.save(location);
    }

}
