package com.crypto_tutor.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crypto_tutor.models.Question;

import org.junit.jupiter.api.Test;

/**
 * this is the testing class for Question at the moment might make other for the other models to make it no clustered, or might add them here
 * @author Tommy Nelson
 */
public class UnitTestQuestion {

    /**
     * tests the getter and setter of the question field for Question
     */
    @Test
    void testSetQuestion()
    {
        String text;
        Question question = new Question();
        question.setQuestion("What is wrong with this?");
        text = question.getQuestion();
        
        assertEquals("What is wrong with this?", text);
    }

    /**
     * tests the getter for question field in question when it is empty
     */
    @Test
    void testSetQuestionEmpty()
    {
        String text;
        Question question = new Question();
        text = question.getQuestion();
        assertEquals(null, text);
    }

    /**
     * tests the getter and setter of the code Fragment field on Question model
     */
    @Test
    void testSetCodeFrag()
    {
        String text;
        Question question = new Question();
        question.setCodeFragment("System.out.println(\"test\")");
        text = question.getCodeFragment();
        assertEquals("System.out.println(\"test\")", text);
    }

    /**
     * tests the getter when there is nothing in the code fragment field for question
     */
    @Test
    void testGetCodeFragEmpty()
    {
        String text;
        Question question = new Question();
        text = question.getCodeFragment();
        assertEquals(null, text);
    }

    /**
     * tests the setter and getter for student id in Question
     */
    @Test
    void testGetStudentId()
    {
        int num;
        Question question = new Question();
        question.setStudentId(12345678);
        num = question.getStudentId();
        assertEquals(12345678, num);
    }

    /**
     * tests the getter when student id is null in Question
     */
    @Test
    void testGetStudentIdNull()
    {
        int num;
        Question question = new Question();
        num = question.getStudentId();
        assertEquals(0, num);
    }

    /**
     * tests the getter and setter for username in the Question model
     */
    @Test
    void testSetUsername()
    {
        String text;
        Question question = new Question();
        question.setUsername("tdnelson");
        text = question.getUsername();
        assertEquals("tdnelson", text);
    }
    
    /**
     * tests the getter when username is null
     */
    @Test
    void testGetUsernameNull()
    {
        String text;
        Question question = new Question();
        text = question.getUsername();
        assertEquals(null, text);





       

        
    }
}
