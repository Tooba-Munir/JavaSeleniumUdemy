package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

public class SeleniumBrokenLinks {
    static WebDriver driver;
    public static void main (String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        int statusCode;
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        SoftAssert asser = new SoftAssert();
        WebElement footerHeader = driver.findElement(By.id("gf-BIG"));
        List<WebElement> links = footerHeader.findElements(By.xpath("//li[@class='gf-li']/a"));
        for(WebElement link: links){
          String URL=  link.getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(URL).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
           statusCode= connection.getResponseCode();
            asser.assertTrue(statusCode<400,"Failed, link is broken "+ URL+" "+ statusCode);
            connection.disconnect();

        }
        asser.assertAll();
        driver.close();
        driver.quit();
    }

}
