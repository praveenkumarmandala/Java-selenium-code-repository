package TestngFrameworkDesign.pageobectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Checkoutpage extends Abstractcomponents {
	
	WebDriver driver;
	
	public Checkoutpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver ; 
		PageFactory.initElements(driver , this);
		
	}
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement countryname;
	
	@FindBy(css= ".ta-item:nth-of-type(2)")
	WebElement ConSelection;
	
	@FindBy(css = ".action__submit")
	WebElement Placeorder;
	
	By ConuntryRes = By.cssSelector(".ta-results");
	
	public void Countryname(String Cname)
	{
		countryname.sendKeys(Cname);
		elementvisible(ConuntryRes);
	}
	public void Countryselect()
	{
		ConSelection.click();
	}
	
	public Confirmationpage PlaceOrder()
	{
		Placeorder.click();
		Confirmationpage confirmpage = new Confirmationpage(driver);
		return confirmpage;
		
	}
	

}
