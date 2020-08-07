package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	static ExtentReports report;
	
	public static ExtentReports getReportObject() {
		
		// create a folder for all the test report inside project
		//command to get to project path in java
		
	    String reportPath=	System.getProperty("user.dir")+"\\reports\\index.html";
		
		ExtentSparkReporter reporter= new ExtentSparkReporter(reportPath);
		
		//configuring report
		
		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("Extent Test Results");
		
		//Extent Reports class is the main class for test case execution report
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("QA", "Ankur Saxena");
		return report;
		
	}

}
