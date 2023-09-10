package tests;
import java.net.MalformedURLException;


import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GridDemo {
    WebDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException  {
       driver = new ChromeDriver();
      driver.get("https://demowebshop.tricentis.com/");
    }

    @Test
    public void titleVerification() {
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Guntikala");
        driver.findElement(By.id("LastName")).sendKeys("Aravind");
        driver.findElement(By.id("Email")).sendKeys("aravind123@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("aravind@123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("aravind@123");
        driver.findElement(By.id("register-button")).click();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}



	

