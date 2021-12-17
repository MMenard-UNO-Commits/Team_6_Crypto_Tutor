package com.crypto_tutor.util;

//comment to get this stuff bac
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

import com.crypto_tutor.models.Question;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

/**
 * This call handles saving question fragments as java files
 * It also runs nicad and sends the formated data to front end
 */
public class QuestionHelper {

    public static final String DIR_LOC = "comparisonFiles_functions-blind-clones/comparisonFiles_functions-blind-clones-0.30-classes-withsource.html";

    /**
     * this will save the question's code fragment as a file
     * 
     * @param Question the question for the code fragment needed to be saved
     * @param String   the base address of where the file will be saved
     * @return the file name of the newly created file
     */
    public static String saveToFile(Question question, String fileName, String properPath)
            throws IOException, ServletException {
        File fileSaveDir = new File(properPath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        String newFileName = fileName;
        FileWriter codeFile = new FileWriter(properPath + File.separator + newFileName);
        codeFile.write(question.getCodeFragment());
        codeFile.close();
        return "comparisonFiles" + File.separator + newFileName;
    }

    /**
     * this will run NiCad to create comparison results
     * 
     * @return any errors that may be produced by NiCad
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
     * this will parse the NiCad html file and return a formatted string
     * 
     * @param String the fileName to be looked for in the HTML
     * @return the file name of the newly created file
     */
    public static String parseHTML(String fileName, HttpServletRequest request) {
        String result = "";
        String context = request.getServletContext().getRealPath("");

        try {
            File htmlFile = new File(context + File.separator + DIR_LOC);
            Document doc = Jsoup.parse(htmlFile, "UTF-8");
            Elements inputClones = doc.select("a:contains(" + fileName + ")");
            int len = inputClones.size();
            String tempStr;
            for (int i = 0; i < len; i++) {
                {
                    tempStr = inputClones.get(i)
                            // Below are 8 levels of the parent() method. Any more and it will retrive the
                            // whole file.
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

            // adds checkboxes onto the end of divs containing the code fragments
            Document editedDoc = Jsoup.parse(result);
            Elements midDivs = editedDoc.select("a");
            len = midDivs.size();
            Element tempElem;
            String tempCodeFrag;
            for (int i = 0; i < len; i++) {
                tempElem = midDivs.get(i);
                tempCodeFrag = tempElem.html();
                // unused code for checkbox implementation
                // has conflicts with Jsoup or React resulting in an edited string that is
                // incorrect
                // tempStr = "<Checkbox value=\"" + tempCodeFrag + "\" onChange={handleChange}
                // inputProps={{ \"aria-label\": \"controlled\"}} />";
                // tempStr = "<input value=\"" + tempCodeFrag + "\" onChange={handleChange}
                // type=\"checkbox\"/>";

                if (i != 0 && i % 2 == 0) {
                    tempStr = "<br>";
                    tempElem.before(tempStr);
                }
                tempStr = "Code Fragment #" + (i + 1) + ": ";
                tempElem.before(tempStr);
            }
            result = editedDoc.toString();
            // For testing purposes, implement cleaner way
            // result = result.replaceAll("onchange=\"{handleChange}\"",
            // "onChange={handleChange}");

            Process p = Runtime.getRuntime().exec(new String[] { "./goodbye.sh" });
            BufferedReader stdout = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stderr = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String line;
            while ((line = stdout.readLine()) != null) {
                System.out.println(line);
            }
            while ((line = stderr.readLine()) != null) {

            }
            p.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * This function scrubs the Student_ID's from all of the questions in the input
     * list.
     * 
     * @param list: a list of questions to be scrubbed.
     * @return the inputted list of questions with all of their Student-ID's set to
     *         0.
     */

    public static List<Question> scrubStudentIDs(List<Question> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setStudentId(0);
        }
        return list;
    }
}