package com.github.extentreport;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtendReportListener implements ITestListener{

	protected static ExtentReports reports;
	protected static ExtentTest test;
	
	private static String resultPath = getResultPath();
	
	public static void deleteDirectory(File directory) {
		if(directory.exists()) {
			File[] files = directory.listFiles();
			if(files != null) {
				for(int i=0; i < files.length ; i ++) {
					System.out.println(files[i].getName());
					if(files[i].isDirectory()) {
						deleteDirectory(files[i]);
					} else {
						files[i].delete();
					}
				}
			}
		}
	}
	
	private static String getResultPath() {
		resultPath = "test"; //new SimpleDateFormat("yyyy-MM-dd hh-mm.ss").format(new Date());
		if(new File(resultPath).isDirectory()) {
			new File(resultPath);
		}
		return resultPath;
	}
	
	String ReportLocation = "test-output/Report/"+ resultPath+ "/";
	
	public void onTestStart(ITestResult result) {
		System.out.println("1111");
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName());
		System.out.println("1112");
		System.out.println(result.getTestClass().getTestName());
		System.out.println("1113");
		System.out.println(result.getMethod().getMethodName());
		System.out.println("1114");
	}
	
	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, "Test is pass");
	}
	
	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL, "Test is fail");
	}
	
	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, "Test is skipped");
	}
	
	public void  onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	public void onStart(ITestContext context) {
		System.out.println("1116");
		System.out.println(ReportLocation + "reportLocation");
		reports = new ExtentReports(ReportLocation + "extentReport.html");
		test = reports.startTest("");
		System.out.println("1117");
	}
	
	public void onFinish(ITestContext context) {
		reports.endTest(test);
		reports.flush();
	}
}
