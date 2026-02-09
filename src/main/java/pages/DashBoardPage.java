package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
	//web elements
	@FindBy (xpath = "//span[@class='righttopmenu1']") private WebElement menuOption;
	@FindBy (xpath = "//a[@id='lnk_logout']") private WebElement logout;
	@FindBy (xpath = "(//a[@class=\"btn btn-sm neobutton\"])[7]") private WebElement secondPopUp;
	@FindBy (xpath = "//a[@class=\"btn btn-success\"]") private WebElement firstPopUp;
	@FindBy (xpath = "//span[@id='lbl_username']") private WebElement userName;
	@FindBy (xpath = "//span[@id='lbl_curbalancetop']") private WebElement currentBalance;
		
		
	//constructor
	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	//methods
	public void clickOkOnSecondPopUp(WebDriver driver) {
		secondPopUp.click();
	}
		
		
	public void clickOkOnFirstPopUp() {
		firstPopUp.click();
	}
		
	public String validateUN() {
		return userName.getText();
	}
			
	public String validateCurrentMoney() {
		return currentBalance.getText();
	}
		
	public void clickOnMenuOption() {
		menuOption.click();
	}
		
	public void clickOnLogoutBtn() {
		logout.click();
	}
}
