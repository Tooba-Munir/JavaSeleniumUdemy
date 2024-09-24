package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class SeleniumNewTabs {

    static WebDriver driver;
    public static void main (String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://courses.rahulshettyacademy.com/courses/");
        String name=driver.findElements(By.cssSelector(".course-listing-title")).get(0).getText();
        Set<String> handles =driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        driver.switchTo().window(it.next());
       WebElement textField= driver.findElement(By.name("name"));
               textField.sendKeys(name);
        File file =textField.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("C:\\Users\\osama\\IdeaProjects\\JavaSeleniumUdemy\\JavaSelenium\\screenshots\\partialSc.png"));
        driver.close();
        driver.quit();
    }
}
