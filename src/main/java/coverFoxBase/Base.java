package coverFoxBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

public class Base {
	static protected WebDriver driver;

	public void OpenBrowser() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.coverfox.com/");
		Reporter.log("Launching browser", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		Reporter.log("waiting...", true);
	}

	public void browserClose() throws InterruptedException {
		driver.close();
		Reporter.log("Closing browser", true);
		Thread.sleep(1000);
	}
}
