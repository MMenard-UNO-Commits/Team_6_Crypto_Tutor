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
    
}
