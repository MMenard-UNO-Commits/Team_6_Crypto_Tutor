package com.crypto_tutor.services;

import com.crypto_tutor.models.Question;

import java.util.List;

/**
 * this is the interface for the Question service which will save our questions to the database.
 * @author Tommy Nelson
 */
public interface QuestionService {

    /**
     * this will save the question to the database
     * @param Question thee question we want to save
     * @return also the question
     */
    public Question saveQuestion(Question Question);

    /**
     * this returns all questions in the database
     * @return the questions as a list
     */
    public List<Question> getAllQuestions();
}
