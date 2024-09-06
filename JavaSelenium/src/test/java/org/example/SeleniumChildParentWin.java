package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SeleniumChildParentWin {
    static WebDriver driver;
    public static void main (String [] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> windows= driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow= it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        System.out.println(driver.findElement(By.tagName("h3")).getText());
        driver.switchTo().window(parentWindow);
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        driver.close();
        driver.quit();


    }
}
