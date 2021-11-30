package com.crypto_tutor.models;
//comment to get this stuff back
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Tommy Nelson
 */
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private int studentId;
    private String codeFragment;
    private String question;
    private String dateTime;
    private String fileName;
    /**
     * Construction for the Question class
     */
    public Question()
    {

    }

    /**
     * gets the username of teh account with the question
     * @return the username of the account that made the question as a string
     */
    public String getUsername() {
        return username;
    }

    /**
     * gets the student id of the account that made the question
     * @return id of the student as an int
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * sets the id of the student
     * @param studentId the id we set it to
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * gets the code fragment code we want to compare 
     * @return the code fragment as a string
     */
    public String getCodeFragment() {
        return codeFragment;
    }

    /**
     * sets the fragment of code that is input
     * @param codeFragment the fragment of code we want to compare as as string
     */
    public void setCodeFragment(String codeFragment) {
        this.codeFragment = codeFragment;
    }

    /**
     * gets the question 
     * @return the question as a string
     */
    public String getQuestion() {
        return question;
    }

    /**
     * sets the question to whatever is input
     * @param question the question we want to put in
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * sets the username for the quetsion
     * @param username the username associated with the question
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * gets the dateTime 
     * @return the dateTime as a string
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * sets the dateTime to whatever is input
     * @param dateTime the dateTime we want to put in
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * gets the fileName 
     * @return the fileName as a string
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * sets the fileName to whatever is input
     * @param fileName the fileName we want to put in
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", studentId='" + getStudentId() + "'" +
            ", codeFragment='" + getCodeFragment() + "'" +
            ", question='" + getQuestion() + "'" +
            ", dateTime='" + getDateTime() + "'" +
            ", fileName='" + getFileName() + "'" +
            "}";
    }

    

}
