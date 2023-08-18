package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		
		driver.get("https://letcode.in/dropdowns");
		
		WebElement languages = driver.findElement(By.id("lang"));
		Select select = new Select(languages);
		select.selectByVisibleText("java");
		

	}

	
	}


