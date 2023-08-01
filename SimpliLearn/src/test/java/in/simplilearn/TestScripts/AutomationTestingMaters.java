package in.simplilearn.TestScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomationTestingMaters {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
   
     @Test
    
    public void navigateToCourse() {
        driver.get("https://www.simplilearn.com/");

        // Perform the actions using explicit waits and By.linkText
        WebElement allCourses = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@title,'All Courses')]")));
        allCourses.click();

        WebElement dataScienceCourse = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@title,'Data Science & Business Analytics')]")));
        dataScienceCourse.click();

        // Wait for the parent element that contains the "Masters Programs" section to be present
        WebDriverWait parentWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement parentElement = parentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'master-wrap')])[1]")));

        // Scroll to the parent element for better visibility (if needed)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", parentElement);

        // Click on the "Data Analyst" option within the "Masters Programs" section
        try {
            WebDriverWait dataAnalystWait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement dataAnalystOption = dataAnalystWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title,'Data Analyst')]")));
            dataAnalystOption.click();
        } catch (Exception e) {
            System.out.println("Data Analyst option is not clickable or not found.");
            e.printStackTrace();
        }

        System.out.println("Current Page Title: " + driver.getTitle());
    }
@AfterTest
    public void tearDown() {

        // Close the browser
        driver.quit();
    }
}
