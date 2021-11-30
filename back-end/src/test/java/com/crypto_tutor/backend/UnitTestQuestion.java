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

    /**
     * testting with 2 quetsions
     */
    @Test
    void test2setCodeFrag()
    {
        String text, text2;
        Question question = new Question();
        Question question2 = new Question();
        question.setCodeFragment("System.out.println(\"help me\");");
        question2.setCodeFragment("return;");
        text = question.getCodeFragment();
        text2 = question2.getCodeFragment();
        assertEquals("System.out.println(\"help me\");", text);
        assertEquals("return;", text2);
    }

    @Test
    void test2setUsername()
    {
        String text, text2;
        Question question = new Question();
        Question question2 = new Question();
        question.setUsername("tester");
        question2.setUsername("tester2;");
        text = question.getUsername();
        text2 = question2.getUsername();
        assertEquals("tester", text);
        assertEquals("tester2;", text2);
    }

    @Test
    void test2setStudentId()
    {
        int text, text2;
        Question question = new Question();
        Question question2 = new Question();
        question.setStudentId(12345678);
        question2.setStudentId(23456789);
        text = question.getStudentId();
        text2 = question2.getStudentId();
        assertEquals(12345678, text);
        assertEquals(23456789, text2);
    }

    @Test
    void test2setQuestion()
    {
        String text, text2;
        Question question = new Question();
        Question question2 = new Question();
        question.setQuestion("help me");
        question2.setQuestion("ayudame");
        text = question.getQuestion();
        text2 = question2.getQuestion();
        assertEquals("help me", text);
        assertEquals("ayudame", text2);
    }

    /**
     * now testing when setting something that is already set
     */
    @Test
    void settingCodeFragAgain()
    {
        String text, text2;
        Question question = new Question();
        Question question2 = new Question();
        question.setCodeFragment("System.out.println(\"help me\");");
        question2.setCodeFragment("return;");
        text = question.getCodeFragment();
        text2 = question2.getCodeFragment();
        assertEquals("System.out.println(\"help me\");", text);
        assertEquals("return;", text2);
        question.setCodeFragment("something else");
        question2.setCodeFragment("different again");
        text = question.getCodeFragment();
        text2 = question2.getCodeFragment();
        assertEquals("something else", text);
        assertEquals("different again", text2);
    }

    @Test
    void settingQuestionAgain()
    {
        String text, text2;
        Question question = new Question();
        Question question2 = new Question();
        question.setQuestion("i am ripping my hair out help me");
        question2.setQuestion("what is wrong with my code");
        text = question.getQuestion();
        text2 = question2.getQuestion();
        assertEquals("i am ripping my hair out help me", text);
        assertEquals("what is wrong with my code", text2);
        question.setQuestion("i would please like to know if anyone has any different ideas for what is wrong with my code");
        question2.setQuestion("i would like to know if there is a character limit to this system and if so what is it and will i break the system by typing something that is entire too long for the system to handle. Will i be albe to keep going forver and forever. please send help my way if you can read this message.");
        text = question.getQuestion();
        text2 = question2.getQuestion();
        assertEquals("i would please like to know if anyone has any different ideas for what is wrong with my code", text);
        assertEquals("i would like to know if there is a character limit to this system and if so what is it and will i break the system by typing something that is entire too long for the system to handle. Will i be albe to keep going forver and forever. please send help my way if you can read this message.", text2);
    }

    @Test
    void settingUsernameAgain()
    {
        String text, text2;
        Question question = new Question();
        Question question2 = new Question();
        question.setUsername("wsmith");
        question2.setUsername("ggadot");
        text = question.getUsername();
        text2 = question2.getUsername();
        assertEquals("wsmith", text);
        assertEquals("ggadot", text2);
        question.setUsername("wbuffet");
        question2.setUsername("ahamilton");
        text = question.getUsername();
        text2 = question2.getUsername();
        assertEquals("wbuffet", text);
        assertEquals("ahamilton", text2);
    }

    @Test
    void settingSchoolId()
    {
        int text, text2;
        Question question = new Question();
        Question question2 = new Question();
        question.setStudentId(86752431);
        question2.setStudentId(10101011);
        text = question.getStudentId();
        text2 = question2.getStudentId();
        assertEquals(86752431, text);
        assertEquals(10101011, text2);
        question.setStudentId(94326754);
        question2.setStudentId(10304050);
        text = question.getStudentId();
        text2 = question2.getStudentId();
        assertEquals(94326754, text);
        assertEquals(10304050, text2);
    }

    /**
     * test setter and getter for datetime
     */
    @Test
    void testSet()
    {
        String text;
        Question question = new Question();
        question.setDateTime("11-30-2021T13:37:30.1234");
        text = question.getDateTime();
        assertEquals("11-30-2021T13:37:30.1234", text);
    }

    /**
     * testing get null for datetime
     */
    @Test
    void testgetNullDatetime()
    {
        String text;
        Question question = new Question();
        text = question.getDateTime();
        assertEquals(null, text);
    }

    /**
     * testing setter and getter for filename
     */
    @Test
    void testSetFilename()
    {
        String text;
        Question question = new Question();
        question.setFileName("Tdnelson.txt");
        text = question.getFileName();
        assertEquals("Tdnelson.txt", text);
    }

    /**
     * testing get null for filename
     */
    @Test
    void testGetNullFilename()
    {
        String text;
        Question question = new Question();
        text = question.getDateTime();
        assertEquals(null, text);
    }

    /**
     * testing setter for datetime by using it twice
     */
    @Test
    void testSetterForDatetimeTwice()
    {
        String text;
        Question question = new Question();
        question.setDateTime("11-30-2021T13:37:30.1234");
        text = question.getDateTime();
        assertEquals("11-30-2021T13:37:30.1234", text);
        question.setDateTime("11-30-2021T15:37:30.1234");
        text = question.getDateTime();
        assertEquals("11-30-2021T15:37:30.1234", text);
    }

    /**
     * testing setter for filename by using it twice
     */
    @Test
    void testSetterForFilenameTwice()
    {
        String text;
        Question question = new Question();
        question.setFileName("hello.sh");
        text = question.getFileName();
        assertEquals("hello.sh", text);
        question.setFileName("tdnelson.txt");
        text = question.getFileName();
        assertEquals("tdnelson.txt", text);
    }
}
