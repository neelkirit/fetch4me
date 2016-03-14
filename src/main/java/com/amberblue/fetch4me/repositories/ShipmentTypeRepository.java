package com.amberblue.fetch4me.repositories;

import com.amberblue.fetch4me.entities.ShipmentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by akash.mercer on 20-02-2016.
 */
public interface ShipmentTypeRepository extends CrudRepository<ShipmentType, String> {

    @Transactional
    public ShipmentType findByType(@Param("type") int type);
}
