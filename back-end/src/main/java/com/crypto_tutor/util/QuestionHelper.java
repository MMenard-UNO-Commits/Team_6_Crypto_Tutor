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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class QuestionHelper {

    public static final String DIR_LOC = "/var/lib/tomcat9/webapps/back-end-0.0.1-SNAPSHOT/" 
        + "comparisonFiles_functions-blind-clones/comparisonFiles_functions-blind-clones-0.30-classes-withsource.html";

    /**
     * this will save the question's code fragment as a file
     * 
     * @param Question the question for the code fragment needed to be saved
     * @param String the base address of where the file will be saved
     * @return the file name of the newly created file
     */
    public static String saveToFile(Question question, String properPath) throws IOException, ServletException {
        File fileSaveDir = new File(properPath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        LocalTime time = LocalTime.now();
        String newFileName = question.getUsername() + "-" + time.toString() + ".java";
        FileWriter codeFile = new FileWriter(properPath + File.separator + newFileName);
        codeFile.write(question.getCodeFragment());
        codeFile.close();
        return "comparisonFiles" + File.separator + newFileName;
    }

    /**
     * this will run NiCad to create comparison results
     * 
     * @return ant errors that may be produced by NiCad
     */
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

    /**
     * this will save the question's code fragment as a file
     * 
     * @param String the fileName to be looked for in the HTML
     * @return the file name of the newly created file
     */
    public static String parseHTML(String fileName) {
        String result = "";

        try {
            File htmlFile = new File(DIR_LOC);
            Document doc = Jsoup.parse(htmlFile, "UTF-8");
            Elements inputClones = doc.select("a:contains(" + fileName + ")");
            int len = inputClones.size();
            String tempStr;
            for (int i  = 0; i < len; i++) {
                {
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
            // TODO: append checkbox elements
            // with id="frag####"
            Document editedDoc = Jsoup.parse(result);
            Elements midDivs = editedDoc.select("div[class=\"mid\"]");
            len = midDivs.size();
            Element tempElem;
            String tempId;
            for (int i  = 0; i < len; i++) {
                tempElem = midDivs.get(i);
                tempId = tempElem.id();
                tempStr = "<Checkbox fragId=\"" + tempId + "\" onChange={handleChange} inputProps={{ \"aria-label\": \"controlled\"}} />";
                tempElem.after(tempStr);
            }
            //NEED TO GET STRING FROM NEW DOC


        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}