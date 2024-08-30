package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class SeleniumStaticDd {
    static WebDriver driver;
    public static void main (String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        WebElement staticDd = driver.findElement(By.xpath("//select[contains(@id,'DropDownListCurrency')]"));
        Select selectDd = new Select(staticDd);
        selectDd.selectByIndex(3);
        System.out.println(selectDd.getFirstSelectedOption().getText());
        selectDd.selectByVisibleText("AED");
        System.out.println(selectDd.getFirstSelectedOption().getText());
        selectDd.selectByValue("INR");
        System.out.println(selectDd.getFirstSelectedOption().getText());

        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }
}
