package com.crypto_tutor.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crypto_tutor.models.Answer;

import org.junit.jupiter.api.Test;

public class UnitTestAnswer {
    
    /**
     * this tests the setter and getter for school id
     */
    @Test
    void testSetSchoolID()
    {
        Answer test = new Answer();
        test.setSchoolId(12345678);
        int output = test.getSchoolId();
        assertEquals(12345678, output);
    }

    /**
     * testing the getter when school id is not yet defined
     */
    @Test
    void testGetNullSchoolId()
    {
        Answer test = new Answer();
        int output = test.getSchoolId();
        assertEquals(0, output);
    }

    /**
     * testing the setter and getter for answer in answer
     */
    @Test
    void testSetAnswer()
    {
        Answer test = new Answer();
        test.setAnswer("this is a mock answer");
        String output = test.getAnswer();
        assertEquals("this is a mock answer", output);
    }
    
    /**
     * testing the getter with null answer
     */
    @Test
    void testGetNullAnswer()
    {
        Answer test = new Answer();
        String output = test.getAnswer();
        assertEquals(null, output);
    }

    /**
     * testing the setter and getter for username
     */
    @Test
    void setUsername()
    {
        Answer test = new Answer();
        test.setUserName("tdnelson");
        String output = test.getUserName();
        assertEquals("tdnelson", output);
    }
    
    /**
     * testing the gettter when username is null
     */
    @Test
    void getNullAnswer()
    {
        Answer test = new Answer();
        String output = test.getUserName();
        assertEquals(null, output);
    }

    /**
     * tersting setter and getter for question id
     */
    @Test
    void testSetQuestionId()
    {
        Answer test = new Answer();
        test.setQuestionId(1);
        int output = test.getQuestionId();
        assertEquals(1, output);
    }

    /**
     * testing getter when no question id is present
     */
    @Test
    void testGetNullQuestionId()
    {
        Answer test = new Answer();
        int output = test.getQuestionId();
        assertEquals(0, output);
    }
}
