package tests;


import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import Utilities.ExcelRead;
import Utilities.MyListener;
import pages.HomePage;
import pages.LoginPage;
import pages.TestBase;

@Listeners(value=MyListener.class)
public class LoginTest extends TestBase{
	WebDriver d;
	HomePage h;
	LoginPage l;
	ExcelRead e = new ExcelRead();
	@DataProvider
	public Object[][] loginData() throws Exception
	{
		int LastRow = e.getLastRow("C:\\Users\\hp\\Downloads\\TestData.xls", "Sheet1");
		Object[][] mydata = new Object[LastRow+1][2];
		for ( int i=0;i<LastRow;i++)
		{
		
		mydata[i][0]=e.readExcel("C:\\Users\\hp\\Downloads\\TestData.xls", "Sheet1", i, 0);
		mydata[i][1]= e.readExcel("C:\\Users\\hp\\Downloads\\TestData.xls", "Sheet1", i, 1);
		}
		return mydata;
	}
	
  @Test(dataProvider="loginData")
  public void testLogin(String u,String p) {
	  h.clickLoginlink();
	  l.enterLoginDetails(u,p);
	  try
	  {
		  l.clickLogout();
	  }catch(Exception e)
	  {
		  AssertJUnit.fail("Sign Out not Present");
	  }
	 }
  @BeforeTest()
  public void setup() 
{
	  getBrowser();
	  h = new HomePage();
	  l = new LoginPage();
  }
}
