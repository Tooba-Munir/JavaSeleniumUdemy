package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTable {
    static WebDriver driver;

    public static void main(String args[]) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        int row;
        int col;
        String data;
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");
        row=driver.findElements(By.cssSelector("#product tbody tr")).size();
        System.out.println(row);
        col = driver.findElements(By.cssSelector("#product tbody tr th")).size();
        System.out.println(col);
        data=driver.findElement(By.cssSelector("#product:nth-child(2) tbody tr:nth-child(3)")).getText();
        System.out.println(data);
        driver.close();
        driver.quit();
    }
}
