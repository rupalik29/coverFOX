package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetailsPage {

	//variable
	
	@FindBy(id = "Age-You") private WebElement ageDropDown;
	@FindBy(className = "next-btn") private WebElement next_btn;
	
	//constructor
	public CoverFoxMemberDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public void handleAgeDropDown(String age) {
		Select s=new Select(ageDropDown);
		s.selectByValue(age+"y");
		Reporter.log("age is selected", true);
	}
	
	public void clickOnNextButton() {
		next_btn.click();
		Reporter.log("clicking on next button", true);
	}
	
	
}
