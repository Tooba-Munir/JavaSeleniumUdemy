package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SeleniumCountLinks {
    static WebDriver driver;
    public static void main (String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());
        WebElement footerSection1Driver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        List<WebElement> linkList = footerSection1Driver.findElements(By.tagName("a"));
        System.out.println(linkList.size());
        for(WebElement i:linkList){
            String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            i.sendKeys(clickOnLink);
            Thread.sleep(2000);
        }

        Set<String> titles = driver.getWindowHandles();
        Iterator<String> iti = titles.iterator();
        while (iti.hasNext()){
            driver.switchTo().window(iti.next());
            System.out.println(driver.getTitle());
        }
        driver.close();
        driver.quit();

    }
}
