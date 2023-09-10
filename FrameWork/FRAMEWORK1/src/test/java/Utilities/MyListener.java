package Utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class MyListener implements ITestListener {
	ExtentReports e;
	ExtentTest t;
	Screenshot s;
	
public void onTestStart(ITestResult result) {
		System.out.println("Test Case started");
		t.log(LogStatus.INFO,result.getMethod().getMethodName()+" has started");
	}
public void onTestSuccess(ITestResult result) {
	System.out.println("Test Case Passes");
	try {
		t.log(LogStatus.PASS, "Screenshot"+t.addScreenCapture(s.takeScreenshot()));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	t.log(LogStatus.PASS, result.getMethod().getMethodName()+" has passed");
		
	}
public void onTestFailure(ITestResult result) {
	System.out.println("Test Case Failure");
	t.log(LogStatus.FAIL, result.getMethod().getMethodName()+" has failed");
}
public void onTestSkipped(ITestResult result) {
	System.out.println("Test Case skipped");
	t.log(LogStatus.SKIP, result.getMethod().getMethodName()+" has skipped");
}
public  void onStart(ITestContext contest) {
	s= new Screenshot();
	
		e=new ExtentReports("test-output\\MyReport.html");
	t=e.startTest("Login Start Has Started");
	e.addSystemInfo("Browser","Chrome");
	e.addSystemInfo("Build","Smoke Testing");
}
public void onFinish(ITestContext contest) {
	System.out.println("TestNG Finished");
	e.endTest(t);
	e.flush();
}

}

	


