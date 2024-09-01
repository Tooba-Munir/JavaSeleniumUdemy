package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumLoginPageE2e {
    static WebDriver driver;

    public static void addItems(WebDriver driver) {
        List<WebElement> itemsList = driver.findElements(By.xpath("//app-card"));
        for (int i = 0; i < itemsList.size(); i++) {
            driver.findElements(By.cssSelector(".btn.btn-info")).get(i).click();
        }
        driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();

    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String name = "rahulshettyacademy";
        String psw = "learning";
        String countryName = "India";
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys(psw);
        driver.findElement(By.xpath("//label[@class='customradio']/input[@value='user']")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();
        WebElement dD = driver.findElement(By.xpath("//div[@class='form-group']/select[@class='form-control']"));
        Select options = new Select(dD);
        options.selectByVisibleText("Consultant");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-card")));
        addItems(driver);
        System.out.println(driver.findElement(By.cssSelector(".text-right h3 strong")).getText());
        driver.findElement(By.cssSelector(".btn.btn-success")).click();
        driver.findElement(By.id("country")).sendKeys("ind");
        List<WebElement> country = driver.findElements(By.xpath("//div[@class='suggestions']/ul"));
        for(WebElement index:country){
            if(index.getText().equalsIgnoreCase(countryName)){
                index.click();
                break;
            }
        }
        w.until(ExpectedConditions.textToBePresentInElementValue(By.id("country"), countryName));
        driver.findElement(By.xpath("//label[@for='checkbox2']")).click();
        driver.findElement(By.cssSelector(".btn.btn-success.btn-lg")).click();
        System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
        driver.close();
        driver.quit();


    }
}
