package com.udogan.baklavaborek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udogan.baklavaborek.entity.User;
import com.udogan.baklavaborek.exception.UserNotFoundException;
import com.udogan.baklavaborek.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(method=RequestMethod.GET)
    public List<User> getAllUsers() {
        return this.userService.getUsers();
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable("id") Long id) throws UserNotFoundException {
        return this.userService.getUser(id);
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public User addUser(@RequestBody User user) throws Exception {
        return this.userService.createUser(user);
    }
    
    @RequestMapping(method=RequestMethod.PUT)
    public User editUser(@RequestBody User user) throws Exception {
        return this.userService.updateUser(user);
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable("id") Long id) throws UserNotFoundException {
        return this.userService.deleteUser(id);
    }
}
