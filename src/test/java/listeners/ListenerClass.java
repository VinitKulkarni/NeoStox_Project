package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import utils.ExtentManager;
import utils.UtilityClass;

public class ListenerClass implements ITestListener {
	ExtentReports report = ExtentManager.getReport();
    ExtentTest test;
	
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("WELCOME TO NEOSTOX TESTING");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + "->testcase started execution");
		test = report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + "->testcase executed successfully");
		test.pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + "->testcase execution failed");
		String imageName = result.getName();
		
		Object testClass = result.getInstance();
	    BaseClass baseObj = (BaseClass) testClass;
	    WebDriver driver = baseObj.driver;
	    
	    try {
			UtilityClass.takeScreenShot(driver, imageName);
			System.out.println("screenshot taken and path is:-> NeoStox\\screenshots" );
		} catch (IOException e) {
			e.printStackTrace();
		}
	    test.fail(result.getName() + " failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName() + "->testcase execution skipped");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println(result.getName() + "->testcase execution failed due to timeout");
	}

	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("END OF NEOSTOX TESTING");
		report.flush();
	}
}
