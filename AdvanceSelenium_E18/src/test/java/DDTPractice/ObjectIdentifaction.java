package DDTPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ObjectIdentifaction {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.adobe.com/products/photoshop.html");
		driver.findElement(By.linkText("United States")).click();
		Actions act = new Actions(driver);
		WebElement freeTrailEle = driver.findElement(By.xpath("//a[@class='modal link-block con-button outline']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(freeTrailEle));
		act.moveToElement(freeTrailEle).perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", freeTrailEle);
//		http://freeTrailEle.click();
//		WebElement frameElement = driver.findElement();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='https://www.adobe.com/mini-plans/photoshop.html?mid=ft&web=1']")));
		driver.findElement(By.xpath("//span[text()='Students and teachers']")).click(); 
		
		
	}
	

}
