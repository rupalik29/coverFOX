package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPage {
	//variable
	@FindBy(className = "mp-input-text") private WebElement addressField;
	@FindBy(id = "want-expert") private WebElement contactNumberField;
	//testNG assignment
	@FindBy(xpath = "//div[text()=' Please enter a valid pincode ']")private WebElement pincodeError;
	@FindBy(xpath = "//div[text()=' Please enter a valid mobile no. ']")private WebElement mobNumError;
	@FindBy(className = "next-btn") private WebElement continueButton;
	
	//constructor
	public CoverFoxAddressDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//methods
	public void enterpincode(String pincode) {
		addressField.sendKeys(pincode);
		Reporter.log("entering pincode", true);
	}
	public void enterContactNumber(String mobileNumber) {
		contactNumberField.sendKeys(mobileNumber);
		Reporter.log("entering mobile number", true);

	}
	//newly added methods fromTestNG assignment
	public void enterInvalidPinCode(String InvalidPincode) {
		addressField.sendKeys(InvalidPincode);
	}
	public void enterInvalidMobNum(String InvalidMobNum) {
		contactNumberField.sendKeys(InvalidMobNum);
	}
	public String invalidPinCodeErrorMsg() {
		String PinErrorMsg = pincodeError.getText();
		return PinErrorMsg;
	}
	public String invalidMobNumErrorMsg() {
		String MobNumErrorMsg=mobNumError.getText();
		return MobNumErrorMsg;
	}
	public void continueButtonClick() {
		continueButton.click();
		Reporter.log("click on continue button", true);

	}
	
}
