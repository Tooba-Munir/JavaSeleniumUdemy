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
        List<Integer> price;
        List<WebElement> elementsAfterSort = driver.findElements(By.xpath("//tbody/tr/td[1]"));
        List<String> listAfterSort = elementsAfterSort.stream().map(s->s.getText()).collect(Collectors.toList());
//        Assert.assertTrue(newList.equals(listAfterSort));
        do {
            List<WebElement> listElements = driver.findElements(By.xpath("//tbody/tr/td[1]"));
            price = listElements.stream().filter(s -> s.getText().contains("Rice")).map(s -> getVeggiePrice(s)).collect(Collectors.toList());
            if (price.size() < 1) {
                driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
            }
            price.forEach(s -> System.out.println(s));
        }while (price.size()<1);

        driver.findElement(By.id("search-field")).sendKeys("Rice");
        List<WebElement> veg=driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> newVeg= veg.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
        Assert.assertEquals(veg.size(),newVeg.size());

        driver.close();
        driver.quit();



    }
    public static Integer getVeggiePrice(WebElement s){
    int price= Integer.parseInt(s.findElement(By.xpath("following-sibling::td[1]")).getText());
    return price;
    }
}
