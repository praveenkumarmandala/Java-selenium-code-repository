package TestngFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestngFrameworkDesign.TestingComponents.Basetest;
import TestngFrameworkDesign.pageobectmodel.Cartpage;
import TestngFrameworkDesign.pageobectmodel.Checkoutpage;
import TestngFrameworkDesign.pageobectmodel.Confirmationpage;
import TestngFrameworkDesign.pageobectmodel.Loginpage;
import TestngFrameworkDesign.pageobectmodel.Orderspage;
import TestngFrameworkDesign.pageobectmodel.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitorderTest extends Basetest {
	String myproduct = "IPHONE 13 PRO";

	@Test(dataProvider = "getdata" , groups = {"readingjsondata"})
	public void Submitorder(HashMap<String,String> input) throws IOException {
	
		
		ProductCatalogue catalogue = loginpage.details(input.get("email") , input.get("password"));
		List<WebElement> products = catalogue.getProductslist();
		catalogue.addtocart(input.get("product"));
		Cartpage cartpage = catalogue.gotocart();
		Boolean match = cartpage.Cartlistitmes(input.get("product"));
		Assert.assertTrue(match);
		Checkoutpage checkoutpage  = cartpage.Checkoutbtn();
		checkoutpage.Countryname("india");
		checkoutpage.Countryselect();
		Confirmationpage confirmpage = checkoutpage.PlaceOrder();
		String confirmmsg = confirmpage.Confirmationmsg();
	    Assert.assertTrue(confirmmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));   

	}
	@Test(dependsOnMethods = {"Submitorder"})
	public void OrderhistoryTest()
	{
		ProductCatalogue catalogue = loginpage.details("praveenkumar@gmail.com", "Praveen123");
		Orderspage orderspage = catalogue.checkorder();
		Assert.assertTrue(orderspage.Orderslist(myproduct));

	}
	
	
	@DataProvider
	public Object[][] getdata() throws IOException
	{
		List<HashMap<String,String>> data = getjsonDatatoMap(System.getProperty("user.dir")+"\\src\\test\\java\\ExternalData\\inputdetails.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	

}
