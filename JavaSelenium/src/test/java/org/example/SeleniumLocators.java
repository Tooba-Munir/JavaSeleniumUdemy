package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumLocators {
static WebDriver driver;

public static String extractPwd(String msg){
    String[] password = msg.split("'");
    String pwd = password[1].split("'")[0];
    return pwd;
}
public static void main (String[] args) throws InterruptedException {
    String invalidPassword = "ab";
    String validPassword;
    String validUsername = "abc";
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    driver.get("https://rahulshettyacademy.com/locatorspractice/");
//   System.out.println(driver.getTitle());
//   System.out.println(driver.getCurrentUrl());
    driver.findElement(By.id("inputUsername")).sendKeys(validUsername);
    driver.findElement(By.name("inputPassword")).sendKeys(invalidPassword);
    driver.findElement(By.className("signInBtn")).click();
   System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
   driver.findElement(By.linkText("Forgot your password?")).click();
   Thread.sleep(1000);
   driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("John");
   driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("john@g.com");
   driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("123");
   driver.findElement(By.className("reset-pwd-btn")).click();
   String passwordText = driver.findElement(By.cssSelector("form p.infoMsg")).getText();
   validPassword =extractPwd(passwordText);
   driver.findElement(By.cssSelector("button[class*='login']")).click();
   Thread.sleep(1000);
   driver.findElement(By.xpath("//input[contains(@placeholder,'name')]")).sendKeys(validUsername);
   driver.findElement(By.xpath("//form/input[@name='inputPassword']")).sendKeys(validPassword);
   driver.findElement(By.id("chkboxOne")).click();
    driver.findElement(By.className("signInBtn")).click();
    Thread.sleep(1000);
    String expected= driver.findElement(By.tagName("p")).getText();
    Assert.assertEquals(expected,"You are successfully logged in.");
    String expectedName = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
    Assert.assertEquals(expectedName,"Hello "+validUsername+",");
    driver.findElement(By.xpath("//button[text()='Log Out']")).click();
    System.out.println(driver.findElement(By.xpath("//div[@class='overlay']/div[2]/h1")).getText());
    System.out.println(driver.findElement(By.xpath("//div[@class='overlay']/div[2]/h1/following-sibling::p")).getText());
    driver.findElement(By.xpath("//div[@class='overlay']/div[2]/h1/following-sibling::p/parent::div/button")).click();




    Thread.sleep(2000);
   driver.close();
    driver.quit();

}
}
