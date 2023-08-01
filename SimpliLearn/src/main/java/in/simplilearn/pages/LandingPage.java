package in.simplilearn.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LandingPage {

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
        // Navigate to the application - https://www.simplilearn.com/
        driver.get("https://www.simplilearn.com/");

        // Perform the actions using explicit waits and By.linkText
        WebElement allCourses = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@title,'All Courses')]")));
        allCourses.click();

        WebElement dataScienceCourse = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@title,'Data Science & Business Analytics')]")));
        dataScienceCourse.click();

        // Wait for the "Data Scientist" option to be present before trying to click it
        By dataScientistOptionLocator = By.xpath("//a[contains(@title,'Data Scientist')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(dataScientistOptionLocator));

        // Attempt to click the "Data Scientist" option
        try {
            WebElement dataScientistOption = wait.until(ExpectedConditions.elementToBeClickable(dataScientistOptionLocator));
            dataScientistOption.click();
        } catch (Exception e) {
            System.out.println("Data Scientist option is not clickable or not found.");
            e.printStackTrace();
        }

        // At this point, the "Data Scientist" option should be clicked if found.
        // You can add further actions or assertions as needed.

        // For demonstration purposes, let's print the current page title
        System.out.println("Current Page Title: " + driver.getTitle());
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

