package TestngFrameworkDesign.pageobectmodel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orderspage extends Abstractcomponents 
{
	WebDriver driver;
	public Orderspage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class='ng-star-inserted'] td:nth-child(3)")
	List<WebElement> orderlist;
	
	public Boolean Orderslist(String pname)
	{
		Boolean match = orderlist.stream().anyMatch(product->product.getText().equalsIgnoreCase(pname));
		return match;
	}
	
	
}
