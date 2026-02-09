package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashBoardPage;
import pages.HomePage;
import pages.PasswordPage;
import pages.SignInPage;
import utils.UtilityClass;

@Listeners(listeners.ListenerClass.class)
public class DashBoardPageTest extends BaseClass {
	DashBoardPage dashBoardPageObj;
	
	@BeforeMethod
	public void preSteps() throws IOException {
		HomePage homePageObj = new HomePage(driver);
		homePageObj.clickOnSignIn();
		
		SignInPage signInPageObj = new SignInPage(driver);
		signInPageObj.enterMobileNo(UtilityClass.readDataFromPropertiesFile("mobileNumber"));
		signInPageObj.clickOnSubmitButton();
		
		PasswordPage passwordPageObj = new PasswordPage(driver);
		passwordPageObj.enterPassword(UtilityClass.readDataFromPropertiesFile("password"));
		passwordPageObj.clickOnSubmitBtn();
	}
	
	@Test
	public void validateUserName() throws IOException {
		dashBoardPageObj = new DashBoardPage(driver);
		dashBoardPageObj.clickOkOnSecondPopUp(driver);
		dashBoardPageObj.clickOkOnFirstPopUp();
		
		String actualUserName = dashBoardPageObj.validateUN();
		String expectedUserName = UtilityClass.readDataFromExcelSheet(0, 1);
		
		assertEquals(actualUserName, expectedUserName);
	}
	
	
	@Test(dependsOnMethods = "validateUserName")
	public void validateInitialAmount() throws IOException {
		dashBoardPageObj = new DashBoardPage(driver);
		
		String actualAmount = dashBoardPageObj.validateCurrentMoney();
		String expectedAmount = UtilityClass.readDataFromExcelSheet(1, 1);
		
		assertEquals(actualAmount, expectedAmount);
	}
	
	@AfterMethod
	public void postSteps() {
		dashBoardPageObj.clickOnMenuOption();
		dashBoardPageObj.clickOnLogoutBtn();
	}
}
