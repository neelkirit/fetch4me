package com.amberblue.fetch4me.services;

import com.amberblue.fetch4me.entities.Address;
import com.amberblue.fetch4me.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void save(Address address){
        addressRepository.save(address);
    }
}
