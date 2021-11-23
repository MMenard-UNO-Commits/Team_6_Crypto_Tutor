package com.crypto_tutor.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import java.time.LocalTime;

import com.crypto_tutor.models.Question;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class QuestionHelper {

    public static final String DIR_LOC = "/var/lib/tomcat9/webapps/back-end-0.0.1-SNAPSHOT/" 
        + "comparisonFiles_functions-blind-clones/comparisonFiles_functions-blind-clones-0.30-classes-withsource.html";

    public static String saveToFile(Question question, String properPath) throws IOException, ServletException {
        File fileSaveDir = new File(properPath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        LocalTime time = LocalTime.now();
        String newFileName = properPath + File.separator + question.getUsername() + "-" + time.toString() + ".java";
        FileWriter codeFile = new FileWriter(newFileName);
        codeFile.write(question.getCodeFragment());
        codeFile.close();
        return newFileName;
    }

    public static String doComparison() {
        String result = "";
        try {
            Process p = Runtime.getRuntime().exec(new String[] { "./hello.sh" });
            System.out.println("doComparison method: Checkpoint #1");
            BufferedReader stdout = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stderr = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            System.out.println("doComparison method: Checkpoint #2");
            String line;
            while ((line = stdout.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("doComparison method: Checkpoint #3");
            while ((line = stderr.readLine()) != null) {
                result += line + "\n";
            }
            System.out.println("doComparison method: Checkpoint #4");
            p.waitFor();
            System.out.println("doComparison method: Checkpoint #5");
            return result;
        } catch (Exception e) {
        }
        return result;
    }

    public static String parseHTML(String fileName) {
        String result = "";

        try {
            File htmlFile = new File(DIR_LOC);
            System.out.println("parseHTML method: Checkpoint #1");
            Document doc = Jsoup.parse(htmlFile, "UTF-8");
            System.out.println("parseHTML method: Checkpoint #2");
            Elements inputClones = doc.select("a:contains(" + fileName + ")");
            System.out.println("parseHTML method: Checkpoint #3");
            int len = inputClones.size();
            String tempStr;
            for (int i  = 0; i < len; i++) {
                {
                    System.out.println("parseHTML method: Loop #" + i);
                    tempStr = inputClones.get(i)
                            // Below are 8 levels of the parent() method. Any more and it will retrive the whole file.
                            .parent().parent().parent().parent().parent().parent().parent().parent()
                            // retrieves the html as a string including the container element <table>
                            // using html() only returns children
                            // I can also encase the element in a <div> element in needed
                            .toString();
                }
                // Solves the issue where mutiple code frags from 
                // the same file are found in the same clone class
                if (!result.contains(tempStr)) {
                    result += tempStr;
                }
            }
            System.out.println("parseHTML method: Checkpoint #4");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}