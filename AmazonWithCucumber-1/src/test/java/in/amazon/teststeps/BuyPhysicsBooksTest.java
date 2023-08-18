package in.amazon.teststeps;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import in.amazon.pages.BuyPhysicsBooksMain;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class BuyPhysicsBooksTest {
    private WebDriver driver;
    private BuyPhysicsBooksMain mainFunctionality;

    @Given("User is on the Amazon website")
    public void userIsOnAmazonWebsite() {
        driver = new ChromeDriver(); // You can set up the WebDriver instance here or use dependency injection
        driver.manage().window().maximize();
        mainFunctionality = new BuyPhysicsBooksMain(driver);
        mainFunctionality.goToAmazon();
    }

    @When("User searches for {string}")
    public void userSearchesFor(String searchTerm) {
        mainFunctionality.searchBooks(searchTerm);
    }

    @When("User clicks on the first book in the search results")
    public void userClicksOnFirstBook() {
        mainFunctionality.clickOnFirstBook();
    }

    @When("User adds the book to the cart")
    public void userAddsBookToCart() {
        mainFunctionality.addToCart();
    }

    @When("User proceeds to buy")
    public void userProceedsToBuy() {
        mainFunctionality.proceedToBuy();
    }

    @Then("User should be on the sign-in page")
    public void userShouldBeOnSignInPage() {
        Assert.assertTrue(mainFunctionality.isSignInPageDisplayed());
    }

    
}

