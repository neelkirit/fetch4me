package com.amberblue.fetch4me.repositories;

import com.amberblue.fetch4me.entities.Shipper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by akash.mercer on 20-02-2016.
 */
public interface ShipperRepository extends CrudRepository<Shipper, String>{

    @Transactional
    public Shipper findById(@Param("id") String id);

    @Transactional
    @Query(value = "select s from Shipper s where s.isOnline = 1")
    public List<Shipper> findOnlineShippers();

    @Transactional
    public Shipper findByEmail(@Param("email") String email);

}
