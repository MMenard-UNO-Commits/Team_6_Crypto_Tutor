package com.crypto_tutor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.crypto_tutor.models.Question;
import com.crypto_tutor.repositories.QuestionRepository;
/**
 * this is the class that implements the question services
 * @author Tommy Nelson
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    /**
     * this will save the question to the repository
     * @param question is the quesiton we want to save
     * @return is also the question
     */
    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    /**
     * this gets all qustions in database
     * @return the list of questions
     */
    @Override
    public List<Question> getAllQuestions() {

        return questionRepository.findAll();
    }
    
}
