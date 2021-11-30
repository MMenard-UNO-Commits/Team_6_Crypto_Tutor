package com.crypto_tutor.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class for storing answers into database
 * @author Tommy Nelson
 */
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answerId;

    private int questionId;
    private String answer;
    private String username;
    private int studentId;

    /**
     * constructor for Answer class
     */
    public Answer()
    {

    }

    /**
     * gets answer
     * @return the answer as a string
     */
    public String getAnswer()
    {
        return answer;
    }

    /**
     * sets the answer
     * @param input the string we want to set answer to
     */
    public void setAnswer(String input)
    {
        answer = input;
    }

    /**
     * gets the username
     * @return the name of the user who answered a question
     */
    public String getUserName()
    {
        return username;
    }

    /**
     * this sets the name of the use who answered a question
     * if for some reason it does not want to input username when implementing this in front end, try sending it as userName ended up working for me
     * @param input the username that answered the question
     */
    public void setUserName(String input)
    {
        username = input;
    }

    /**
     * this gets the student id of the user who answered the quetsion
     * @return id of the student as an int
     */
    public int getSchoolId()
    {
        return studentId;
    }

    /**
     * this sets the id of the student who answered a question 
     * @param input the id of the student
     */
    public void setSchoolId(int input)
    {
        studentId = input;
    }

    /**
     * getting the answerId of the answer
     * @return id of the answer as an int
     */
    public int getAnswerId()
    {
        return answerId;
    }

    /**
     * gets the question id that this answer is related to should be a foreign key but that will be implemented later
     * @return id of the related question as an int
     */
    public int getQuestionId()
    {
        return questionId;
    }

    /**
     * sets the id of the related quetison that this answer answers
     * @param input id of the question as an int
     */
    public void setQuestionId(int input)
    {
        questionId = input;
    }

    
}
