package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class SeleniumHeightandWidthWebElement {
    static WebDriver driver;
    public static void main (String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement textField = driver.findElement(By.name("name"));
        int width=textField.getRect().getDimension().getWidth();
       int height= textField.getRect().getDimension().getHeight();
       System.out.println("Height and Width is: "+height+" "+width);
        Assert.assertEquals(height,38);
        Assert.assertEquals(width,1110);

        driver.close();
        driver.quit();

    }
}
