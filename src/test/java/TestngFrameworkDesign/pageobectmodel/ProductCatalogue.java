package TestngFrameworkDesign.pageobectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue extends Abstractcomponents{
	
	WebDriver driver; 
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement animating_wait;
	
	By productsby = By.cssSelector(".mb-3");
	By toastmessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductslist() {
		
		elementvisible(productsby);
		return products;
		
	}
	
	public WebElement getitem(String productname) {
	
	WebElement prod = getProductslist().stream().filter(product->
    product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productname)).findFirst().orElse(null);
	return prod;
	}
	
	public void addtocart(String productname)
	{
		
		WebElement prod = getitem(productname);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		elementvisible(toastmessage);
		elementinvisibility(animating_wait);
	}
	
	
	

}
