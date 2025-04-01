package Login;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericUtility.PropertiesFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;


public class LoginTest extends BaseClass {

	//@Parameters("browser")
	@Test(retryAnalyzer =genericListenerUtility.RetryListenerImp.class )
	public void loginTest() throws InterruptedException, IOException {
		
		String expectedURL="http://49.249.28.218:8098/dashboard";
		//Launching the browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//navigating to ninza CRM
		
		Thread.sleep(2000);
		//verification of dashboard
		String actualURL=driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL,"Validation is failed");
		Reporter.log("Validation is passed",true);
		//logout
		DashboardPage dp=new DashboardPage(driver);
			}

}
