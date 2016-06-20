package com.udogan.baklavaborek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udogan.baklavaborek.entity.User;
import com.udogan.baklavaborek.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping(method=RequestMethod.GET)
    List<User> get() {
        return this.userRepository.findAll();
    }
    
    @RequestMapping(method=RequestMethod.POST)
    User setUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }
}
