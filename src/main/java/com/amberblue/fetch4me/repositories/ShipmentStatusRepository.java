package com.amberblue.fetch4me.repositories;

import com.amberblue.fetch4me.entities.ShipmentStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by akash.mercer on 20-02-2016.
 */
public interface ShipmentStatusRepository extends CrudRepository<ShipmentStatus, String> {

    @Transactional
    public ShipmentStatus findByType(@Param("type") int type);
}
