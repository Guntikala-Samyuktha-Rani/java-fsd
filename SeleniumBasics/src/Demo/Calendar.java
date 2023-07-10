package Demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.expedia.co.in/");
			
		driver.findElement(By.id("date_from_field_btn")).click();
		
		WebElement nextMonth = driver.findElement(By.xpath("(//table[contains(@class,'weeks')])[2]"));
		List<WebElement> rows =  nextMonth.findElements(By.tagName("tr"));
		 for (int i=1; i < rows.size(); i++) {
			WebElement row = rows.get(i);
			List<WebElement> columns = row.findElements(By.tagName("button"));
			
			for (WebElement x : columns) {
				if (x.getAttribute("date-day").equals("9")) {
					x.click();
					break;
				}
			}
		 }
		 driver.findElement(By.xpath("//button[contains(@data-stid,'apply-date')]")).click();
		
	}
}
		
		
		
		
		
	
	
	
	


