package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.example.SeleniumStaticDdWithClick.clickElement;

public class Seleniume2eFlight {
    static WebDriver driver;

    public static void main (String args []) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");
        driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
        driver.findElement(By.xpath("//div[text()='AGR']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='DHM']")).click();
        //driver.findElement(By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@data-testid='undefined-month-September-2024']/div/div/div[@data-testid='undefined-calendar-day-2']")).click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).getAttribute("style").contains("rgb(238, 238, 238)"));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText());
        clickElement(driver,4);
        driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText());
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Currency']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'css-76zvg2') and text()='AED']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Family & Friends']")).click();
        driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
        Thread.sleep(3000);
        String msg = driver.findElement(By.xpath("//div[text()='Family and Friends Discount Bookings']")).getText();
        Assert.assertEquals(msg,"Family and Friends Discount Bookings");

        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }
}
