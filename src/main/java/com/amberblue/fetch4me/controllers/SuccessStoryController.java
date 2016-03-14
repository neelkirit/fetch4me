package com.amberblue.fetch4me.controllers;

import com.amberblue.fetch4me.entities.Shipper;
import com.amberblue.fetch4me.entities.SuccessStory;
import com.amberblue.fetch4me.services.SuccessStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Sagar Jain on 21-02-2016.
 */
@RestController
@RequestMapping(value = "/successStory")
public class SuccessStoryController {
    @Autowired
    SuccessStoryService successStoryService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    private void save(@RequestBody SuccessStory successStory){
        successStoryService.save(successStory);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    private List<SuccessStory> findAll(){
       return successStoryService.findAll();
    }


}
