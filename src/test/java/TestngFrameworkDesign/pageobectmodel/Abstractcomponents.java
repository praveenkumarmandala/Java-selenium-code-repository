package TestngFrameworkDesign.pageobectmodel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractcomponents {
	
	WebDriver driver;
	
	public Abstractcomponents(WebDriver driver) 
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cartbutton;
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement ordersbutton;
	
	
	
	
	public void elementvisible(By Findby) 
	{
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Findby));
	}
	
	public void elementinvisibility(WebElement ele)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void waitforWebElementToAppear(WebElement Element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Element));
	}
	
	public Cartpage gotocart()
	{
		cartbutton.click();
		Cartpage cartpage = new Cartpage(driver);
		return cartpage;
	}
	
	public Orderspage checkorder()
	{
		waitforWebElementToAppear(ordersbutton);
		ordersbutton.click();
		Orderspage orderspage = new Orderspage(driver);
		return orderspage;
		
	}
	
	

}
