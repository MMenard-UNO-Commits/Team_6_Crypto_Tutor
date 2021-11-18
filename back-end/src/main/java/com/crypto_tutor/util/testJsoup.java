package com.crypto_tutor.util;

import java.io.File;
//import java.io.FileWriter;

//import javax.servlet.http.HttpServletRequest;

//import java.io.FileNotFoundException;
//import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class testJsoup {
    public static String parseHTML(String fileName) {
        String result = "";

        try {
            File htmlFile = new File(fileName);

            if (htmlFile == null) {
                return "error!";
            }

            Document doc = Jsoup.parse(htmlFile, "UTF-8");

            Elements inputClones = doc.select("a:contains(comparisonFiles/JHotDraw/standard/ChopBoxConnector.java)");

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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}