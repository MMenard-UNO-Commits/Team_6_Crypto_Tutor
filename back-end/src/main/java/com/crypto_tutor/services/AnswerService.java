package com.crypto_tutor.services;

import com.crypto_tutor.models.Answer;

import java.util.List;

/**
 * interface for answer Service
 */
public interface AnswerService {
    /**
     * makes sure we have method to save answers
     * @param answer is the answer we want to save to database
     * @return the answer we saved
     */
    public Answer saveAnswer(Answer answer);

    /**
     * this will help return all the answers in the table
     * @return the asnwers as a list
     */
    public List<Answer> getAllAnswers();
}
