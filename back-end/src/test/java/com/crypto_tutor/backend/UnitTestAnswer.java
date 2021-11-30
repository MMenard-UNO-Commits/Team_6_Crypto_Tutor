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

    /**
     * testing the getAnswerid
     */
    @Test
    void getAnswerId()
    {
        Answer test = new Answer();
        int output = test.getAnswerId();
        assertEquals(0, output);
    }

    /**
     * testing getter and settter for multiple answers this one is getter for anwserid
     */
    @Test
    void testMultipleGetAnswerId()
    {
        Answer test = new Answer();
        Answer test2 = new Answer();
        int output = test.getAnswerId();
        int output2 = test2.getAnswerId();
        assertEquals(0, output);
        assertEquals(0, output2);
    }

    /**
     * this one is answer text
     */
    @Test
    void testMultipleSetAnswer()
    {
        Answer test = new Answer();
        Answer test2 = new Answer();
        test.setAnswer("test1");
        test2.setAnswer("test2");
        String output = test.getAnswer();
        String output2 = test2.getAnswer();
        assertEquals("test1", output);
        assertEquals("test2", output2);
    }

    /**
     * this one is school id
     */
    @Test
    void testMultipleSetSchoolId()
    {
        Answer test = new Answer();
        Answer test2 = new Answer();
        test.setSchoolId(12345678);
        test2.setSchoolId(87654321);
        int output = test.getSchoolId();
        int output2 = test2.getSchoolId();
        assertEquals(12345678, output);
        assertEquals(87654321, output2);
    }

    /**
     * this one is username
     */
    @Test
    void testMultipleSetUsername()
    {
        Answer test = new Answer();
        Answer test2 = new Answer();
        test.setUserName("tdnelson");
        test2.setUserName("test2");
        String output = test.getUserName();
        String output2 = test2.getUserName();
        assertEquals("tdnelson", output);
        assertEquals("test2", output2);
    }

    /**
     * this one is questionid
     */
    @Test
    void testMultipleSetQuestionId()
    {
        Answer test = new Answer();
        Answer test2 = new Answer();
        test.setQuestionId(1);
        test2.setQuestionId(1);
        int output = test.getQuestionId();
        int output2 = test2.getQuestionId();
        assertEquals(1, output);
        assertEquals(1, output2);
    }

    /**
     * testing setter for all fields
     */
    @Test
    void setNewField()
    {
        Answer test = new Answer();
        Answer test2 = new Answer();
        test.setQuestionId(1);
        test2.setQuestionId(1);
        int output = test.getQuestionId();
        int output2 = test2.getQuestionId();
        assertEquals(1, output);
        assertEquals(1, output2);
        test.setQuestionId(52);
        test2.setQuestionId(87);
        output = test.getQuestionId();
        output2 = test2.getQuestionId();
        assertEquals(52, output);
        assertEquals(87, output2);
    }

    @Test
    void setNewFieldSchoolId()
    {
        Answer test = new Answer();
        Answer test2 = new Answer();
        test.setSchoolId(12345678);
        test2.setSchoolId(87654321);
        int output = test.getSchoolId();
        int output2 = test2.getSchoolId();
        assertEquals(12345678, output);
        assertEquals(87654321, output2);
        test.setSchoolId(43218765);
        test2.setSchoolId(90875436);
        output = test.getSchoolId();
        output2 = test2.getSchoolId();
        assertEquals(43218765, output);
        assertEquals(90875436, output2);
    }

    @Test
    void setNewFieldAnswer()
    {
        Answer test = new Answer();
        Answer test2 = new Answer();
        test.setAnswer("   3 23");
        test2.setAnswer("0nvqkgb a   asdfzcvb.,?");
        String output = test.getAnswer();
        String output2 = test2.getAnswer();
        assertEquals("   3 23", output);
        assertEquals("0nvqkgb a   asdfzcvb.,?", output2);
        test.setAnswer("this is a test");
        test2.setAnswer("this is also a test");
        output = test.getAnswer();
        output2 = test2.getAnswer();
        assertEquals("this is a test", output);
        assertEquals("this is also a test", output2);
    }

    @Test
    void setNewFieldUsername()
    {
        Answer test = new Answer();
        Answer test2 = new Answer();
        test.setUserName("null");
        test2.setUserName("not null");
        String output = test.getUserName();
        String output2 = test2.getUserName();
        assertEquals("null", output);
        assertEquals("not null", output2);
        test.setUserName("testUser");
        test2.setUserName("testUser2");
        output = test.getUserName();
        output2 = test2.getUserName();
        assertEquals("testUser", output);
        assertEquals("testUser2", output2);
    }
}
