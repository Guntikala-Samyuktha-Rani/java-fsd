package Demo;

import org.openqa.selenium.By;


import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyErrorMessage {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://facebook.com");
		
		driver.findElement(By.id("email")).sendKeys("batmans554466@gmail.com");
		
		driver.findElement(By.id("pass")).sendKeys("password@123");
		
		driver.findElement(By.name("login")).click();
		
		String expectedErrMsg = "The email address you entered isn't connected to an account. Find your account and log in.";
		
		String actualErrMsg = driver.findElement(By.xpath("//div[contain(@class,'ay')]")).getText();
		
		if(expectedErrMsg.equals(actualErrMsg)) {
			System.out.println("Test Case Passed");
			
		}
		else {
			System.out.println("Test Case Failed");
		}
		driver.quit();
		
	}

}
