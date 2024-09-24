package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SeleniumAboveBelowLoc {
    static WebDriver driver;
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameBox = driver.findElement(By.name("name"));
        WebElement dobBox = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameBox)).getText());
        driver.findElement(with(By.tagName("input")).below(dobBox)).click();
        WebElement text = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        WebElement checkBox1 = driver.findElement(By.id("inlineRadio1"));
        driver.findElement(with(By.tagName("input")).toLeftOf(text)).click();
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(checkBox1)).getText());

        driver.close();
        driver.quit();
    }
}
