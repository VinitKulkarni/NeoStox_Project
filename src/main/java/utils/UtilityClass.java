package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {
	String expectedUserName;
	String expectedAmount;
	//static String excelFilePath = "C:\\Users\\vinit\\eclipse-workspace\\NeoStox\\src\\test\\resources\\Neostox_data.xlsx";
	static String excelFilePath = System.getProperty("user.dir")+"/src/test/resources/Neostox_data.xlsx";
	
	//read data from excel sheet
	public static String readDataFromExcelSheet(int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		File myFile = new File(excelFilePath);
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet1");
		String value = mySheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;
	}
	
	
	//implicit wait method
	public static void implicitWaitMethod(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	
	//read data from properties file
	public static String readDataFromPropertiesFile(String key) throws IOException {
		//String filePath = "C:\\Users\\vinit\\eclipse-workspace\\NeoStox\\src\\test\\resources\\NeoStoxFile.properties";
		String filePath = System.getProperty("user.dir")+"/src/test/resources/NeoStoxFile.properties";
		Properties prop = new Properties();
		FileInputStream reader = new FileInputStream(filePath);
		prop.load(reader);
		
		String value = prop.getProperty(key);
		return value;
	}
	
	
	//screen shot code
	public static void takeScreenShot(WebDriver driver, String imageName) throws IOException {
		int random = (int)(Math.random() * 1000);
		imageName = imageName + "_screenshot_" +random;
		//String screenShotName = "C:\\Users\\vinit\\OneDrive\\Pictures\\Screenshots\\" + imageName + ".jpg";
		String screenShotName = System.getProperty("user.dir")+"/screenshots/"+imageName + ".jpg";
		
		File Temp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		File desirdlc = new File(screenShotName);
		FileHandler.copy(Temp, desirdlc);
	}
}
