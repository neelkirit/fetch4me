package com.amberblue.fetch4me.repositories;

import com.amberblue.fetch4me.entities.Shipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by akash.mercer on 20-02-2016.
 */
public interface ShipmentRepository extends CrudRepository<Shipment, String> {

    @Transactional
    public Shipment findById(@Param("id") String id);

    @Transactional
    @Query(value = "select s from Shipment s where s.isActive = 1 and s.processed = 1")
    public List<Shipment> findActiveShipments();

    @Transactional
    @Query(value = "select s from Shipment s where s.shipmentStatus ='4d8c5998-55c2-46e5-a399-bfa6b00b0a0f' ")
    public List<Shipment> findCompletedOrders();

}
