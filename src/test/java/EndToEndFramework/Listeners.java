package EndToEndFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporter;

public class Listeners extends base implements ITestListener  {

public static Logger log= LogManager.getLogger(Listeners.class.getName());

ExtentReports report = ExtentReporter.getReportObject();
ExtentTest test;
ThreadLocal<ExtentTest> tl= new ThreadLocal<ExtentTest>();

public void onTestStart(ITestResult result) {
	
	String tescase=result.getMethod().getMethodName();
		
	 test=report.createTest(tescase);
	 
	 tl.set(test);
	
}

	public void onFinish(ITestContext context) {
		report.flush();
	}

	public void onStart(ITestContext context) {
		
	}

	public void onTestFailure(ITestResult result) {
		
		tl.get().fail(result.getThrowable());
		WebDriver driver=null;
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		
		String FailedCase=result.getMethod().getMethodName();
		log.info(FailedCase+" Test cases is failed");
		try {
			tl.get().addScreenCaptureFromPath(screenshot(FailedCase,driver),FailedCase);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
	
	}


	public void onTestSuccess(ITestResult result) {
		tl.get().log(Status.PASS, "Test passed");
	}

	
	
}
