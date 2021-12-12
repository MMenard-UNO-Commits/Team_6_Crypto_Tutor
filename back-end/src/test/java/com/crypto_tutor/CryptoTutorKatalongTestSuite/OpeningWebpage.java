package com.crypto_tutor.CryptoTutorKatalongTestSuite;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

/**
 * this is the test class for opeing the website and testing traversal around it.
 * @author Tommy Nelson
 */
public class OpeningWebpage {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.edge.driver", "C:\\chromedriver\\msedgedriver.exe");
    driver = new EdgeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  /**
   * test for opening to the dashboard and traversing around the website
   * @throws Exception
   */
  @Test
  public void testOpeningWebpage() throws Exception {
    driver.get("http://104.131.172.9:8080/web/");
    driver.findElement(By.linkText("🔍Search Questions")).click();
    driver.findElement(By.linkText("❓Ask Question")).click();
    driver.findElement(By.linkText("🔍Search Questions")).click();
  }

  /**
   * auto generated code from katalon
   * @throws Exception
   */
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  /**
   * auto generated code
   * @param by
   * @return
   */
  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  /**
   * auto generated code
   * @return
   */
  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  /**
   * auto generated code
   * @return
   */
  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
