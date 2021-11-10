package com.crypto_tutor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.crypto_tutor.models.Answer;
import com.crypto_tutor.repositories.AnswerRepository;

/**
 * class that implements the interface for saving data to repository
 * @author Tommy Nelson
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    /**
     * saves the answer to the repository
     * @param is the answer we want to save
     * @return is the answer we saved
     */
    @Override
    public Answer saveAnswer(Answer answer)
    {
        return answerRepository.save(answer);
    }

    /**
     * this will help return all answers in the table
     * @return the answers as a list
     */
    @Override
    public List<Answer> getAllAnswers() {

        return answerRepository.findAll();
    }
    
}
