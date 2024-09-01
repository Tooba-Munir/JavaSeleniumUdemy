package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SeleniumCarte2e {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String[] vegToAdd = new String[]{"Cauliflower", "Brocolli", "Cucumber", "Brinjal"};
        cartAdd(driver, vegToAdd);
        driver.findElement(By.className("cart-icon")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
        System.out.println(driver.findElement(By.className("promoInfo")).getText());
        driver.findElement(By.xpath("//div//button[text()='Place Order']")).click();
        Thread.sleep(1000);
        driver.close();
        driver.quit();

    }

    public static void cartAdd(WebDriver driver, String[] vegToAdd) {
        int valueChecked = 0;
        List<WebElement> vegList = driver.findElements(By.xpath("//h4[@class='product-name']"));
        for (int i = 0; i < vegList.size(); i++) {
            String[] name = (vegList.get(i).getText().split("-"));
            String formattedName = name[0].trim();
            List<String> checkVeg = Arrays.asList(vegToAdd);
            if (checkVeg.contains(formattedName)) {
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                valueChecked++;
                if (valueChecked == vegToAdd.length) {
                    break;
                }

            }


        }
    }
}
