package com.crypto_tutor.controllers;

import com.crypto_tutor.services.AnswerService;
import com.crypto_tutor.models.Answer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * this is the controller for the answer repository so we can store and get answers from our database
 * @author Tommy Nelson
 */
@CrossOrigin
@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    /**
     * sets the mapping for the url so it would be url/answer/add, this will add the answer to the database
     * @param answer the answer we are adding to the database
     * @return a string confirming we added the answer
     */
    @PostMapping("/add")
    public String add(@RequestBody Answer answer)
    {
        answerService.saveAnswer(answer);
        return "answer has been saved to database";
    }

    /**
     * this gets all the answers in the table, good for quick testing
     * @return all the answers as a list
     */
    @GetMapping("/getAll")
    public List<Answer> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    
}
