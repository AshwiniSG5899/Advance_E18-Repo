package CampaignTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

import DDTPractice.DataProviderUsage;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.CampaignsPage;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;


public class CreateCampaignTest extends BaseClass{

	//@Parameters("browser")
	
	@Test()
	public void createCampaignTest() throws InterruptedException, IOException {
		
		JavaUtility jUtil=new JavaUtility();
		int randomNum = jUtil.getRandomNum(10000);
		
		ExcelFileUtility exUtil=new ExcelFileUtility();
		String Campaign = exUtil.readingDataFromExcel("DDT", 1, 2)+randomNum;
		String targetSize = exUtil.readingDataFromExcel("DDT", 1, 3);
		
		String expectedURL="http://49.249.28.218:8098/dashboard";
		//Launching the browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		DashboardPage dp=new DashboardPage(driver);
		Thread.sleep(2000);
		dp.getCampaignsLink().click();
		CampaignsPage cp=new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		CreateCampaignsPage ccp=new CreateCampaignsPage(driver);
		ccp.createCampaignWithmandatoryFields(Campaign, targetSize);
		Thread.sleep(5000);
		String ConfMsg = cp.getConfMsg().getText();
		boolean status = ConfMsg.contains(Campaign);
		Assert.assertEquals(status, true, "campaign not added");
		//Assert.assertTrue(status, "Campaign not added");
		Reporter.log("Campaign "+Campaign+" added successfully",true);
		Thread.sleep(5000);
		
		

	}
	//@Parameters("browser")
	@Test()
	public void createCampaignWithCloseDateTest() throws InterruptedException, IOException
	{
		
		
		JavaUtility jUtil=new JavaUtility();
		int randomNum = jUtil.getRandomNum(10000);
		
		ExcelFileUtility exUtil=new ExcelFileUtility();
		String Campaign = exUtil.readingDataFromExcel("DDT", 1, 2)+randomNum;
		String targetSize = exUtil.readingDataFromExcel("DDT", 1, 3);
		
		String closeDate = jUtil.generateReqDate(30);
		
		String expectedURL="http://49.249.28.218:8098/dashboard";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		DashboardPage dp=new DashboardPage(driver);
		Thread.sleep(2000);
		dp.getCampaignsLink().click();
		CampaignsPage cp=new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		CreateCampaignsPage ccp=new CreateCampaignsPage(driver);
		ccp.createCampaignWithCloseDate(Campaign, targetSize,closeDate);
		Thread.sleep(5000);
		String ConfMsg = cp.getConfMsg().getText();
		boolean status = ConfMsg.contains(Campaign);
		Assert.assertEquals(status, true, "Campaign not added");
		//Assert.assertTrue(status, "Campaign not added");
	    Reporter.log("campaign "+Campaign+" added successfully",true);
		Thread.sleep(5000);
		
	}

}
