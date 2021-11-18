package com.crypto_tutor.backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crypto_tutor.models.User;

/**
 * this is the unit tests for the user class
 * @author Tommy Nelson
 */
public class UnitTestUser {

    /**
     * tests the settter and getter for username in user
     */
    @Test
    void testSetUsername()
    {
        User test = new User();
        test.setUsername("tdnelson");
        String output = test.getUsername();
        assertEquals(output, "tdnelson");
    }

    /**
     * getting username without setting it first
     */
    @Test
    void testGetNullUsername()
    {
        User test = new User();
        String output = test.getUsername();
        assertEquals(output, null);
    }

    /**
     * testing getter and settter for password in user
     */
    @Test
    void testSetPassword()
    {
        User test = new User();
        test.setPassword("abc123!@#");
        String output = test.getPassword();
        assertEquals(output, "abc123!@#");
    }

    /**
     * testing get password when there is one missing
     */
    @Test
    void testGetNullPassword()
    {
        User test = new User();
        String output = test.getPassword();
        assertEquals(output, null);
    }

    /**
     * testing set and get school id in user
     */
    @Test
    void testSetSchoolID()
    {
        User test = new User();
        test.setSchoolID(12345678);
        int output = test.getSchoolID();
        assertEquals(output, 12345678);
    }

    /**
     * testing get school id when id is null
     */
    @Test
    void getNullSchoolID()
    {
        User test = new User();
        int output = test.getSchoolID();
        assertEquals(output, 0);
    }

    /**
     * testing setter and getter for user type in user
     */
    @Test
    void setUserType()
    {
        User test = new User();
        test.setUserType(1);
        int output = test.getUserType();
        assertEquals(output, 1);
    }

    /**
     * testing getter for usertype when it is null
     */
    @Test
    void getNullUserType()
    {
        User test = new User();
        int output = test.getUserType();
        assertEquals(output, 0);
    }
    
}
