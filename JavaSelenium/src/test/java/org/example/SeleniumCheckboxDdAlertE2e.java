package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SeleniumCheckboxDdAlertE2e {
    static WebDriver driver;

    public static void main(String args[]) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String value;
        String msg;
        List<WebElement> cBox = driver.findElements(By.xpath("//label/input[@type='checkbox']/.."));
        for(WebElement cBoxOption: cBox){
            cBoxOption.click();
            value =cBoxOption.getText();
           cBoxOption.click();
           Select dD = new Select(driver.findElement(By.id("dropdown-class-example")));
           dD.selectByVisibleText(value);
           driver.findElement(By.id("name")).sendKeys(value);
           driver.findElement(By.id("alertbtn")).click();
           msg=driver.switchTo().alert().getText().split("Hello")[1].trim().split(",")[0];
           driver.switchTo().alert().accept();
           driver.switchTo().defaultContent();
           Assert.assertEquals(msg,value);
        }
        driver.close();
        driver.quit();
    }
}
