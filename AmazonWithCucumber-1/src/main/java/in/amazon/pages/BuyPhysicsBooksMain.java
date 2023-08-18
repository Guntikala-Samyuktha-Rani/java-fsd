package in.amazon.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyPhysicsBooksMain {
    private WebDriver driver;
    private WebDriverWait wait;

    public BuyPhysicsBooksMain(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToAmazon() {
        driver.get("https://www.amazon.in");
    }

    public void searchBooks(String searchTerm) {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(searchTerm, Keys.ENTER);
    }

    public void clickOnFirstBook() {
        WebElement firstBook = driver.findElement(By.xpath("(//div[@data-asin])[1]"));
        firstBook.click();
    }

    public void addToCart() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        addToCartButton.click();
    }

    public void proceedToBuy() {
        WebElement proceedToBuyButton = driver.findElement(By.cssSelector("#sc-buy-box-ptc-button > span > input"));
        proceedToBuyButton.click();
    }

    public boolean isSignInPageDisplayed() {
        return driver.getCurrentUrl().contains("signin");
    }
}




	
	


 


