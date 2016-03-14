package com.amberblue.fetch4me.services;

import com.amberblue.fetch4me.entities.SuccessStory;
import com.amberblue.fetch4me.repositories.SuccessStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sagar Jain on 21-02-2016.
 */
@Service
public class SuccessStoryService {

    @Autowired
    SuccessStoryRepository successStoryRepository;

    public void save(SuccessStory successStory){
        successStoryRepository.save(successStory);
    }

    public List<SuccessStory> findAll(){
        return (List<SuccessStory>)successStoryRepository.findAll();
    }


}
