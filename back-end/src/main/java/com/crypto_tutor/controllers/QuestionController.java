package com.crypto_tutor.controllers;

import com.crypto_tutor.models.Question;
import com.crypto_tutor.services.QuestionService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.time.LocalTime;
import java.lang.Runtime;

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
        questionService.saveQuestion(question);
        String appPath = request.getServletContext().getRealPath("");
        String properPath = appPath + File.separator + COMP_DIR;
        File fileSaveDir = new File(properPath);
        if (!fileSaveDir.exists()) {
            System.out.println("created!");
            fileSaveDir.mkdir();
        }
        LocalTime time = LocalTime.now();
        FileWriter codeFile = new FileWriter(
                properPath + File.separator + question.getUsername() + "-" + time.toString() + ".java");
        codeFile.write(question.getCodeFragment());
        codeFile.close();
        return "a new question has been added";
    }

    @GetMapping("/getAll")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    /*
     * @GetMapping("/compareAll") public String doComparison() throws IOException,
     * InterruptedException { Runtime console = Runtime.getRuntime(); Process p =
     * console.exec("./hello.sh"); BufferedReader stdout = new BufferedReader(new
     * InputStreamReader(p.getInputStream())); String line; String outLine =
     * "Error!"; while ((line = stdout.readLine()) != null) { outLine = line; }
     * p.waitFor(); // p = console.exec("pwd"); // stdout = new BufferedReader(new
     * InputStreamReader(p.getInputStream())); // line = ""; // outLine = "Error!";
     * // while ((line = stdout.readLine()) != null) { // outLine = line; // } //
     * p.waitFor(); return outLine; }
     */

    @GetMapping("/compareAll")
    public static String doComparison() {
        String result = "";
        try {
            Process p = Runtime.getRuntime().exec(new String[] { "./hello.sh > output.txt" });
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

    @PostMapping("/addquestion")
    public String test(@RequestBody Question question) {
        questionService.saveQuestion(question);
        return "questions added";
    }

}
