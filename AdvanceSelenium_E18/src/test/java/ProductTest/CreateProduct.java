package ProductTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.CreateProductsPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;


public class CreateProduct extends BaseClass {

	//@Parameters("browser")
	@Test(groups= {"Integration"})
	public void createProductTest() throws IOException, InterruptedException {
		JavaUtility jutil=new JavaUtility();
		int randNum = jutil.getRandomNum(10000);
		ExcelFileUtility excelUtil=new ExcelFileUtility();
		String prodName = excelUtil.readingDataFromExcel("Product", 1, 2)+randNum;
		String quantity = excelUtil.readingDataFromExcel("Product", 1, 3);
		String price = excelUtil.readingDataFromExcel("Product", 1, 4);
		
		String expectedURL="http://49.249.28.218:8098/dashboard";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//navigating to ninza CRM
		
		Thread.sleep(2000);
		//verification of dashboard
		DashboardPage dp=new DashboardPage(driver);
		dp.getProductsLink().click();
		ProductPage pp=new ProductPage(driver);
		pp.getAddProductBtn().click();
		CreateProductsPage cpp=new CreateProductsPage(driver);
		cpp.addProduct(prodName, quantity, price);
		Thread.sleep(5000);
		String confMsg = pp.getConfMsg().getText();
		boolean status = confMsg.contains(prodName);
		Assert.assertTrue(status);
		Thread.sleep(5000);
		//logout
		
	}

}
