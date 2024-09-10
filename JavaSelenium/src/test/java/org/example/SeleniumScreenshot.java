package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SeleniumScreenshot {
    static WebDriver driver;
    public static void main (String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        TakesScreenshot shot = (TakesScreenshot) driver;
        File source = shot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("C:\\Users\\osama\\IdeaProjects\\JavaSeleniumUdemy\\JavaSelenium\\screenshots\\sc.png"));
        driver.close();
        driver.quit();
    }
}
