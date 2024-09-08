package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumCalendar {

    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String year = "2025";
        int month = 6;
        String day = "20";
        String expectedDate =year+"-0"+month+"-"+day;
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.className("react-date-picker__inputGroup")).click();
        driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
        driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(month - 1).click();
        driver.findElement(By.xpath("//button/abbr[text()='"+day+"']")).click();
       String actualDate= driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']//input[@name='date']")).getAttribute("value");
        Assert.assertEquals(actualDate,expectedDate);


       driver.close();
       driver.quit();
    }
}
