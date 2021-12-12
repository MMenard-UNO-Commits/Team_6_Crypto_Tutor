package com.crypto_tutor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.crypto_tutor.models.User;
import com.crypto_tutor.repositories.UserRepository;

/**
 * impolements the user service interface
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    /**
     * saves the user to the database
     */
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * gets all users from the database
     */
    @Override
    public List<User> getAllStudents() {
        return userRepository.findAll();
    }
}
