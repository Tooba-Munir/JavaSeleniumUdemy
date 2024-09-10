package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SeleniumSortTable {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        List<WebElement> elements = driver.findElements(By.xpath("//tbody/tr/td[1]"));
        List<String> newList = elements.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
        driver.findElement(By.cssSelector(".sort-descending")).click();
        List<WebElement> elementsAfterSort = driver.findElements(By.xpath("//tbody/tr/td[1]"));
        List<String> listAfterSort = elementsAfterSort.stream().map(s->s.getText()).collect(Collectors.toList());
        Assert.assertTrue(newList.equals(listAfterSort));

        driver.close();
        driver.quit();



    }
}
