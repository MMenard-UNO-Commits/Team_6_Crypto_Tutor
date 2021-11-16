package com.crypto_tutor.util;
import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;


public class testJsoup {
    public static String parseHTML(String fileName) {
        String result = "";

        try {
            File htmlFile = new File(fileName);
            //Scanner myReader = new Scanner(htmlFile);

            Document doc = Jsoup.parse(htmlFile, "UTF-8");

            Element inputClone = doc.select("a:contains(comparisonFiles/JHotDraw/standard/ChopBoxConnector.java: 56-69)").get(1);
            Element cloneClass = inputClone.parent();
            result = cloneClass.html();

            
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        

        return result;
    }
}