package com.amberblue.fetch4me.services;

import com.amberblue.fetch4me.beans.Rating;
import com.amberblue.fetch4me.entities.User;
import com.amberblue.fetch4me.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by akash.mercer on 20-02-2016.
 */

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    public void save(User user){
        userRepository.save(user);
    }

    public User findById(String id){
        return userRepository.findById(id);
    }

    @Transactional
    public Map<String, Object> login(User user){
        String email = user.getEmail();
        Map<String, Object> map = new HashMap<>();
        User oldUser;
        int status = 0;
        // status = 1 social sign up completed
        // status = 0 request failed
        oldUser = userRepository.findByEmail(email);
        if(oldUser == null) {
            oldUser = userRepository.save(user);
            status = 1;
        } else {
            status = 1;
        }
        map.put("user", oldUser);
        map.put("status", status);
        return map;
    }

    public void rateUser(Rating rating){
        User retrievedUser = userRepository.findById(rating.getId());
        double newRating = (retrievedUser.getRating()*retrievedUser.getRatingCount() + rating.getRating())/(retrievedUser.getRatingCount() + 1);
        retrievedUser.setRating(newRating);
        retrievedUser.setRatingCount(retrievedUser.getRatingCount() + 1);
        entityManager.merge(retrievedUser);
    }
}
