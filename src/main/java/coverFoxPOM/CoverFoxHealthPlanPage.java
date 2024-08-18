package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlanPage {

	//variable
	@FindBy(className = "next-btn") private WebElement next_btn;
	
	//constructor
	public CoverFoxHealthPlanPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public void ClickOnNextButton() {
		next_btn.click();
		Reporter.log("clicking on next button", true);
	}
	
	
	
	
	
	
	
}
