package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class SeleniumScroll {

    static WebDriver driver;

    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        int sum = 0;
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");
        Thread.sleep(1000);
        js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
        List<WebElement> numbers = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        for (WebElement n : numbers) {
            sum = sum + Integer.parseInt(n.getText());

        }
        String text = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
        int actualSum = Integer.parseInt(text.split(":")[1].trim());
        Assert.assertEquals(sum,actualSum);
        driver.close();
        driver.quit();
    }
}
