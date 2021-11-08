package com.crypto_tutor.controllers;

import com.crypto_tutor.models.Question;
import com.crypto_tutor.services.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * This is the controller for the Question
 * @author Tommy Nelson
 */
@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionController {
    
    @Autowired
    QuestionService questionService;

    /**
     * this will save the question and returns a string saying that it succeeded.
     * @param Question the question we want to save
     * @return string saying that we have succeeded
     */
    @PostMapping("/add")
    public String add(@RequestBody Question Question) {
        questionService.saveQuestion(Question);
        return "a new question has been added";
    }

    

}
