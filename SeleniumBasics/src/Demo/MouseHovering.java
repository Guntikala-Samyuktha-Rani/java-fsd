package Demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHovering {

	public static void main(String[] args) {
		

		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://ebay.com");
		
		WebElement motors = driver.findElement(By.linkText("Motors"));
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(motors).build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Engines and parts")));
		
		driver.findElement(By.linkText("Engines and parts")).click();
	}

}
