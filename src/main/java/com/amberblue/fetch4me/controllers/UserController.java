package com.amberblue.fetch4me.controllers;

import com.amberblue.fetch4me.beans.Rating;
import com.amberblue.fetch4me.entities.User;
import com.amberblue.fetch4me.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    private void save(@RequestBody User user){
        userService.save(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    private @ResponseBody Map<String, Object> login(@RequestBody User user){
        return userService.login(user);
    }

    @RequestMapping(value = "/rateUser", method = RequestMethod.POST, consumes = "application/json")
    private void rateUser(@RequestBody Rating rating){
        userService.rateUser(rating);
    }
}
