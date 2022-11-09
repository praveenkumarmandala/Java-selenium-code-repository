package TestngFrameworkDesign.pageobectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartpage extends Abstractcomponents
{
	WebDriver driver;
	
	public Cartpage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutbtn;
	
	public boolean Cartlistitmes(String Product)
	{
		List <WebElement> cartitems = driver.findElements(By.cssSelector(".cartSection h3"));
	    boolean match = cartitems.stream().anyMatch(cartitem->cartitem.getText().equalsIgnoreCase(Product));
	    return match;
	    
	}
	
	public Checkoutpage Checkoutbtn()
	{
		checkoutbtn.click();
		Checkoutpage checkoutpage = new Checkoutpage(driver);
		return checkoutpage;
	}
	
	
	
	

}

