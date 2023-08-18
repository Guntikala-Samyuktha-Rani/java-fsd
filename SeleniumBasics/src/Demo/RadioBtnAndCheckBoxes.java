package Demo;



import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioBtnAndCheckBoxes {

	

	public static void main(String[] args) {
		
		 ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://letcode.in/radio");
		
		driver.findElement(By.id("yes")).click();
		
		driver.findElement(By.xpath("(//input[contains(@type,'checkbox')])"));

	}

}
