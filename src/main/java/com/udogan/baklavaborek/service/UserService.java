package com.udogan.baklavaborek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.udogan.baklavaborek.entity.User;
import com.udogan.baklavaborek.exception.EmailAlreadyAddedException;
import com.udogan.baklavaborek.exception.UserNotFoundException;
import com.udogan.baklavaborek.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public boolean checkEmailAddedBefore(String email) {
        return checkEmailAddedBefore(email, null);
    }
    
    public boolean checkEmailAddedBefore(String email, Long id) {
        User user = this.userRepository.findByEmail(email);
        return user != null && user.getId() != null ? user.getId().equals(id) : true;
    }
    
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }
    
    public User getUser(Long id) throws UserNotFoundException {
        User user = this.userRepository.findOne(id);
        if (user != null) {
            return user;
        }
        throw new UserNotFoundException("User not found with id " + id);
    }
    
    public User createUser(User user) throws Exception {
        if (checkEmailAddedBefore(user.getEmail())) {
            return this.userRepository.saveAndFlush(user);
        }
        throw new EmailAlreadyAddedException("Email added before.");
    }
    
    public User updateUser(User user) throws Exception {
        Assert.notNull(user.getId(), "User id cannot be null");
        if (checkEmailAddedBefore(user.getEmail(), user.getId())) {
            return this.userRepository.saveAndFlush(user);    
        }
        throw new EmailAlreadyAddedException("Email added before.");
    }

    public boolean deleteUser(Long id) throws UserNotFoundException {
        User user = getUser(id);
        this.userRepository.delete(user);
        return true;
    }
}
