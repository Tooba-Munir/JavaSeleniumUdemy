package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumAction {
    static WebDriver driver;
    public static void main (String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.daraz.pk/#hp-just-for-you");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[text()='Help Center']"))).build().perform();
       System.out.println(driver.findElement(By.xpath("//a[text()='Help Center']")).getText());
        action.moveToElement(driver.findElement(By.id("q"))).click().keyDown(Keys.SHIFT).sendKeys("ball").doubleClick().build().perform();
        Thread.sleep(1000);
        driver.close();
        driver.quit();

    }
}
