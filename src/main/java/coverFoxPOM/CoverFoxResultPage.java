package coverFoxPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxResultPage {

	// variable
	@FindBy(xpath = "//div[contains(text(),'Health Insurance')]")
	private WebElement resultText;

	@FindBy(className = "plan-card-container")
	private List<WebElement> banners;

	@FindBy(xpath = "//div[text()='Sort Plans']")
	private WebElement sortPlanFilter;

	// constructor
	public CoverFoxResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// new methods added below for TestNG TC
	public int getPlanNumbersFromString() {
		String[] ar = resultText.getText().split(" ");
		int result = Integer.parseInt(ar[0]);
		return result;
	}

	public int getPlanNumbersFromBanners() {
		int bannerSize = banners.size();
		return bannerSize;
	}

	public boolean sortPlanFilterIsDisplayed() {
		boolean result = sortPlanFilter.isDisplayed();
		return result;
	}

}
