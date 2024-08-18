package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePage {
	
	//variable
	@FindBy(xpath = "//div[text()='Female']") private WebElement femaleButton;
	
	//constructor
	public CoverFoxHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//methods
	
	public void clickOnFemaleButton() {
		femaleButton.click();
		Reporter.log("clicking on female button", true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
