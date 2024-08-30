package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumStaticDdWithClick {
    static WebDriver driver;

    public static void clickElement(WebDriver driver, int count){
        for(int i=1;i<count;i++) {
            driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
        }
    }
    public static void main (String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");
        driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText());
        clickElement(driver,4);
        driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText());
        driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
        driver.findElement(By.xpath("//div[text()='AGR']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='DHM']")).click();


        Thread.sleep(1000);
        driver.close();
        driver.quit();

    }
}
