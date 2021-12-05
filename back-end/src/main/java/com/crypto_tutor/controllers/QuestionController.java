package com.crypto_tutor.controllers;
//commend to get this stuff back
import com.crypto_tutor.models.Question;
import com.crypto_tutor.services.QuestionService;
import com.crypto_tutor.util.QuestionHelper;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * This is the controller for the Question
 * 
 * @author Tommy Nelson
 */
@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionController {

    private static final String COMP_DIR = "comparisonFiles";

    @Autowired
    QuestionService questionService;

    /**
     * this will save the question and returns a string saying that it succeeded.
     * 
     * @param Question the question we want to save
     * @return string saying that we have succeeded
     */
    @PostMapping("/add")
    public String add(@RequestBody Question question, HttpServletRequest request) throws IOException, ServletException {
        String creationTime = LocalTime.now().toString();
        String newFileName = question.getUsername() + "-" + creationTime + ".java";
        question.setDateTime(creationTime);
        question.setFileName(newFileName);
        questionService.saveQuestion(question);
        String appPath = request.getServletContext().getRealPath("");
        String properPath = appPath + File.separator + COMP_DIR;

        String compareFileName = QuestionHelper.saveToFile(question, newFileName, properPath);
        QuestionHelper.doComparison();
        String htmlResult = QuestionHelper.parseHTML(compareFileName, request);
        System.out.println(htmlResult);
        return htmlResult;
    }

    /**
     * this returns all questions as a list for output on a url good for testing
     * @return the list of questions
     */
    @GetMapping("/getAll")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    /*@GetMapping("/compareAll")
    public static String doComparison() {
        String result = "";
        try {
            Process p = Runtime.getRuntime().exec(new String[] { "./hello.sh" });
            BufferedReader stdout = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stderr = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String line;
            while ((line = stdout.readLine()) != null) {
                System.out.println(line);
            }
            while ((line = stderr.readLine()) != null) {
                result += line + "\n";
            }
            p.waitFor();
            return result;
        } catch (Exception e) {
        }
        return result;
    }
    @GetMapping("/testJsoup")
    public static String doTestJsoup() {
        String htmlResult = QuestionHelper.parseHTML("/var/lib/tomcat9/webapps/back-end-0.0.1-SNAPSHOT/" 
                        + "comparisonFiles_functions-blind-clones/comparisonFiles_functions-blind-clones-0.30-classes-withsource.html");
        System.out.println(htmlResult);
        return htmlResult;
    }*/

    @PostMapping("/addquestion")
    public String test(@RequestBody Question question) {
        questionService.saveQuestion(question);
        return "questions added";
    }

}
