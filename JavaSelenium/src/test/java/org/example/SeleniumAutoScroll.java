package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SeleniumAutoScroll {
    static WebDriver driver;
    public static void main (String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3000));
        String expectedText = "";
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("uni");
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-menu-item")));
        List<WebElement> countries = driver.findElements(By.cssSelector(".ui-menu-item"));
        for (WebElement country : countries) {
            if (country.getText().equalsIgnoreCase("United Arab Emirates")) {

                country.click();
                expectedText=country.getText();
                break;
            }

        }
        String actualText=driver.findElement(By.id("autocomplete")).getText();
        Assert.assertEquals(actualText,expectedText); 

        Thread.sleep(2000);

        driver.close();
        driver.quit();
    }
}
