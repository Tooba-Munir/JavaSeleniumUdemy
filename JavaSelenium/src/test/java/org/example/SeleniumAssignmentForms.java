package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumAssignmentForms {
    static WebDriver driver;
    public static void main (String [] args){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.name("name")).sendKeys("Student");
        driver.findElement(By.name("email")).sendKeys("abc@gmai.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("1234");
        driver.findElement(By.id("exampleCheck1")).click();
        WebElement Dd = driver.findElement(By.id("exampleFormControlSelect1"));
        Select options = new Select(Dd);
        options.selectByVisibleText("Female");
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("22/02/1994");
        driver.findElement(By.cssSelector(".btn.btn-success")).click();
        String msg = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText();
        System.out.println(msg);
        driver.close();
        driver.quit();
    }
}
