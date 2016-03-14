package com.amberblue.fetch4me.controllers;

import com.amberblue.fetch4me.entities.Address;
import com.amberblue.fetch4me.entities.Guest;
import com.amberblue.fetch4me.services.AddressService;
import com.amberblue.fetch4me.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@RestController
@RequestMapping(value = "/guest")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    private void save(@RequestBody Guest guest){
        guestService.save(guest);
    }

}
