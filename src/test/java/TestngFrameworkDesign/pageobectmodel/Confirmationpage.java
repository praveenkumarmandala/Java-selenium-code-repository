package TestngFrameworkDesign.pageobectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Confirmationpage extends Abstractcomponents
{
	WebDriver driver;
	
	public Confirmationpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}
	
	By conmsg = By.cssSelector(".hero-primary");
	
	@FindBy(css = ".hero-primary")
	WebElement confirmationmsg;
	
	public String Confirmationmsg()
	{
		elementvisible(conmsg);
		return confirmationmsg.getText();
	}

	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
}
