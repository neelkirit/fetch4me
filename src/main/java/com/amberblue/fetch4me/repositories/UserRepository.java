package com.amberblue.fetch4me.repositories;

import com.amberblue.fetch4me.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by akash.mercer on 20-02-2016.
 */
public interface UserRepository extends CrudRepository<User, String> {

    @Transactional
    public User findById(@Param("id") String id);

    @Transactional
    public User findByEmail(@Param("email") String email);

}
