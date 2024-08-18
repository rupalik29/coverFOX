package coverFoxTest;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import coverFoxUtility.Utility;
import coverFoxBase.Base;
import coverFoxPOM.CoverFoxAddressDetailsPage;
import coverFoxPOM.CoverFoxHealthPlanPage;
import coverFoxPOM.CoverFoxHomePage;
import coverFoxPOM.CoverFoxMemberDetailsPage;
import coverFoxPOM.CoverFoxResultPage;

public class CoverFoxTC1 extends Base {
	CoverFoxHomePage homePage;
	CoverFoxHealthPlanPage healthPlanPage;
	CoverFoxAddressDetailsPage addressDetailsPage;
	CoverFoxMemberDetailsPage memberDetailsPage;
	CoverFoxResultPage resultPage;
	String filePath;
	public static Logger logger;
	
	@BeforeTest
	public void launchBrowser() {
		logger=Logger.getLogger("CoverFoxInsurance");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Opening browser");
		OpenBrowser();
		homePage=new CoverFoxHomePage(driver);
		healthPlanPage=new CoverFoxHealthPlanPage(driver);
		memberDetailsPage=new CoverFoxMemberDetailsPage(driver);
		addressDetailsPage=new CoverFoxAddressDetailsPage(driver);
		resultPage=new CoverFoxResultPage(driver);
		filePath=System.getProperty("user.dir")+"\\Demo1.xlsx";
	}
	@BeforeClass
	public void preConditions() throws InterruptedException, EncryptedDocumentException, IOException {
		homePage.clickOnFemaleButton();
		logger.info("Clicking on female button");
		Thread.sleep(2000);
		healthPlanPage.ClickOnNextButton();
		logger.info("Click on next button");
		Thread.sleep(2000);
		memberDetailsPage.handleAgeDropDown(Utility.readDataFromExcel(filePath, "Sheet5", 0, 0));
		logger.warn("Enter age between 18-90 years");
		logger.info("Handling age drop down");
		memberDetailsPage.clickOnNextButton();
		logger.info("Click on next button");
		Thread.sleep(2000);
		addressDetailsPage.enterpincode(Utility.readDataFromExcel(filePath, "Sheet5", 0, 1));
		logger.warn("Please enter valid pin code");
		logger.info("Entering pin code");
		Thread.sleep(1000);
		addressDetailsPage.enterContactNumber(Utility.readDataFromExcel(filePath, "Sheet5", 0, 2));
		logger.warn("Please enter valid mobile number");
		logger.info("Entering mobile number");
		Thread.sleep(1000);
		addressDetailsPage.continueButtonClick();
		logger.info("Click on continue button");
		Thread.sleep(2000);
	}
	@Test
	public void validateBanners() throws InterruptedException {
		Thread.sleep(2000);
		int bannerPlanNumbers = resultPage.getPlanNumbersFromBanners();
		int StringPlanNumbers = resultPage.getPlanNumbersFromString();
		logger.info("Validating banners");
		Assert.assertEquals(bannerPlanNumbers, StringPlanNumbers,"Plans of banners are not matching with String result,Tc failed");
	}
	@Test
	public void validatePresenceofSortButton() throws InterruptedException, IOException {
		//Assert.fail();
		Thread.sleep(3000);
		logger.info("Validating presence of sort button");
		assertTrue(resultPage.sortPlanFilterIsDisplayed(), "sort plan filter is not displayed ,TC is failed");
		Utility.Screenshot(driver, "validatePresenceofSortButton");
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		logger.info("Closing browser");
		browserClose();
	}
}
