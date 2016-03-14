package com.amberblue.fetch4me.repositories;

import com.amberblue.fetch4me.entities.Address;
import com.amberblue.fetch4me.entities.SuccessStory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sagar Jain on 21-02-2016.
 */
public interface SuccessStoryRepository extends CrudRepository<SuccessStory, String> {
}
