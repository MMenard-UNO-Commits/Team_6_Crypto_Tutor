package com.crypto_tutor.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.crypto_tutor.repositories.UserRepository;
import com.crypto_tutor.models.User;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
