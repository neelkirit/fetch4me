package com.amberblue.fetch4me.services;

import com.amberblue.fetch4me.entities.Guest;
import com.amberblue.fetch4me.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public void save(Guest guest){
        guestRepository.save(guest);
    }
}
