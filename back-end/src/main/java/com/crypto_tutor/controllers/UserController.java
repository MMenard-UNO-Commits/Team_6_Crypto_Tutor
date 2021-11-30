package com.crypto_tutor.controllers;

import com.crypto_tutor.services.UserService;

import java.util.ArrayList;
import java.util.List;

import com.crypto_tutor.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {



    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String add(@RequestBody User user) {
        userService.saveUser(user);
        
        return "a new user has been added";
    }

    /**
     * Author: Michael Menard
     * 
     * A method that returns the names of all users that are tagged as being students. Primarily used to
     * facilitate the creation of the dashboard search query form.
     * @return a list of the user names of all users tagged as student users
     */
    @GetMapping("/getStudents")
    public List<String> pullStudentNames() {
        List<User> users = userService.getAllStudents();
        List<String> names = new ArrayList<>();
        for(int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUserType() == 0){
                names.add(users.get(i).getUsername());
            }
        }
        return names;

    }
}
