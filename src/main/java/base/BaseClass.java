package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.UtilityClass;

public class BaseClass {
	public WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(UtilityClass.readDataFromPropertiesFile("url"));
		UtilityClass.implicitWaitMethod(driver, 40);
	}
	
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
