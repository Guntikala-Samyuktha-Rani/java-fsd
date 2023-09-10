package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class DesCap {
	
	WebDriver d;
	@Test(enabled=false)
	public void f() {
		System.setProperty("WebDriver.ie.driver","");
		d = new InternetExplorerDriver();
		d.get("https://github.com/SeleniumHQ/selenium/wiki/DesiredCapabilities");
		
	}
@Test
public void chromeDesCap()
{
	ChromeOptions cs = new ChromeOptions();
	cs.addArguments("start-maximized");
	d=new ChromeDriver(cs);
}
	
}
