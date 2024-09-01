package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class SeleniumCarte2e {
    static WebDriver driver;
    public static void main (String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> vegList = driver.findElements(By.xpath("//h4[@class='product-name']"));
        String [] vegToAdd = new String[]{"Cauliflower","Brocolli","Cucumber", "Brinjal"};
        int valueChecked=0;

        for(int i=0;i<vegList.size();i++) {
            String [] name = (vegList.get(i).getText().split("-"));
             String formattedName = name[0].trim();
            List<String> checkVeg = Arrays.asList(vegToAdd);
            if(checkVeg.contains(formattedName)){
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                valueChecked++;
                if(valueChecked==vegToAdd.length){
                    break;
                }

            }

        }
        Thread.sleep(1000);
        driver.close();
        driver.quit();

    }
}
