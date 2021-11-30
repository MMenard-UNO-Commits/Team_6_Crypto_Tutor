package com.crypto_tutor.services;

import java.util.List;

import com.crypto_tutor.models.User;
public interface UserService {
    public User saveUser(User user);
    public List<User> getAllStudents();
}
