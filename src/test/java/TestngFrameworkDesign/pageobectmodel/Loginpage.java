package TestngFrameworkDesign.pageobectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends Abstractcomponents {
	
	WebDriver driver;

	public Loginpage(WebDriver driver) {
		
        super(driver);	
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}




	@FindBy(id="userEmail")
	WebElement UserEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(css="#login")
	WebElement submit;
	
	@FindBy(css="[class*=flyInOut]")
	WebElement errormsg;
	
	public ProductCatalogue details(String uname,String pwd)
	{
		UserEmail.sendKeys(uname);
		password.sendKeys(pwd);
		submit.click();
		ProductCatalogue catalogue  =  new ProductCatalogue(driver);
		return catalogue;
	}
	
	
	public String geterrormsg()
	{
		waitforWebElementToAppear(errormsg);
		return errormsg.getText();
	}
	
	public void Goto()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
