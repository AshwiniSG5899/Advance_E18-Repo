package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateProductsPage {

	WebDriver driver;
	
	public CreateProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="productName")
	private WebElement prodNameField;
	
	@FindBy(name="productCategory")
	private WebElement prodCatDD;
	
	@FindBy(name="quantity")
	private WebElement qualityTextField;
	
	@FindBy(name="price")
	private WebElement priceField;
	
	@FindBy(name="vendorId")
	private WebElement vendorDD;
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement addProdBtn;

	public WebElement getProdNameField() {
		return prodNameField;
	}

	public WebElement getProdCatDD() {
		return prodCatDD;
	}

	public WebElement getQualityTextField() {
		return qualityTextField;
	}

	public WebElement getPriceField() {
		return priceField;
	}

	public WebElement getVendorDD() {
		return vendorDD;
	}
	
	public WebElement getAddProdBtn() {
		return addProdBtn;
	}

	public void addProduct(String prod,String qual,String price)
	{
		prodNameField.sendKeys(prod);
		qualityTextField.clear();
		qualityTextField.sendKeys(qual);
		priceField.clear();
		priceField.sendKeys(price);
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.select(prodCatDD, 1);
		wlib.select(vendorDD, "VID_008");
		addProdBtn.click();
	}
	
	
	
	
	
	
	
}
