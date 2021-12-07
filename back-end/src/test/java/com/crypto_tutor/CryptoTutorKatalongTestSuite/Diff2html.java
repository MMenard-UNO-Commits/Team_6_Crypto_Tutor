package com.example.CryptoTutorKatalongTestSuite;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class Diff2html {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testDiff2html() throws Exception {
    driver.get("http://104.131.172.9:8080/web/");
    driver.findElement(By.linkText("❓Ask Question")).click();
    driver.findElement(By.id("ID")).click();
    driver.findElement(By.id("ID")).clear();
    driver.findElement(By.id("ID")).sendKeys("tnelson");
    driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[2]/input")).clear();
    driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[2]/input")).sendKeys("12345");
    driver.findElement(By.id("question")).click();
    driver.findElement(By.id("question")).clear();
    driver.findElement(By.id("question")).sendKeys("test diff2html");
    driver.findElement(By.id("codefragment")).click();
    driver.findElement(By.id("codefragment")).clear();
    driver.findElement(By.id("codefragment")).sendKeys("public void encrypt(Key key, int keysize, InputStream in, OutputStream out) throws EncryptorException {                CipherInputStream cis = null;                try {                        Cipher cipher = Cipher.getInstance(ALGORITHM);                        byte[] kb = key.getEncryptKey().length <= keysize / 7 ? key.getEncryptKey() : Arrays.copyOf(key.getEncryptKey(), keysize / 7);                        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kb, ALGORITHM), new IvParameterSpec(key.getIv()));                        cis = new CipherInputStream(in, cipher);                        IOToolkit.transmit(cis, out);                } catch (Exception e) {                        throw new EncryptorException(e);                } finally {                        IOToolkit.close(cis);                }        }");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(20000);
    driver.findElement(By.xpath("//input[@type='text']")).click();
    driver.findElement(By.xpath("//input[@type='text']")).clear();
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("1");
    driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[2]/input")).click();
    driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[2]/input")).clear();
    driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[2]/input")).sendKeys("3");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

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
