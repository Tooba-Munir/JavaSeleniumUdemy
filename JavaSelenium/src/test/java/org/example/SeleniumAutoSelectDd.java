package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class SeleniumAutoSelectDd {
    static WebDriver driver;
    public static void main (String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(2000);
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
        for(WebElement option: options){
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                break;
            }
        }
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
        System.out.println(driver.findElements(By.xpath("//div[@id='discount-checkbox'] //input[@type='checkbox']")).size());
        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        Assert.assertTrue(driver.findElement(By.id("Div1")).getAttribute("style").contains("opacity: 1"));
        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }
}
