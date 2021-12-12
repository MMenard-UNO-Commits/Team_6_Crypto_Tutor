package com.crypto_tutor.services;

import java.util.List;

import com.crypto_tutor.models.User;

/**
 * interface for the user helps save data to database
 */
public interface UserService {
    public User saveUser(User user);
    public List<User> getAllStudents();
}
