package com.crypto_tutor.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * this is the user model, this is the object we use to store all data about a user
 */
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private int schoolID;

    //value from 0 - 2: 0 is student, 1 is instructor, 2 is admin
    private int userType;

    /**
     * empty contructor
     */
    public User() {
    }
    
    /**
     * gets the username from object
     * @return the username as a string
     */
    public String getUsername() {
        return username;
    }

    /**
     * gets the user type of the user
     * @return the type of user as an int
     */
    public int getUserType() {
        return userType;
    }

    /**
     * sets the user type of an user
     * @param userType number 0-2 based on what type of user this will be
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }

    /**
     * gets the school id of the user
     * @return the school id as an integer
     */
    public int getSchoolID() {
        return schoolID;
    }
    /**
     * sets the school id of a user
     * @param schoolID the school id we want to use for the current user.
     */
    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    /**
     * gets the password of the user
     * @return the password of the user as a string
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * sets the password of the user
     * @param password the password we want to let the user have as a string
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * sets the username of the user
     * @param username the username we want to set as a string
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
