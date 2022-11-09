package TestngFrameworkDesign;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestngFrameworkDesign.TestingComponents.Basetest;
import TestngFrameworkDesign.pageobectmodel.Cartpage;
import TestngFrameworkDesign.pageobectmodel.ProductCatalogue;

public class ErrorvalidationsTest extends Basetest
{
	@Test(groups = {"errorhandling"})
	public void LoginErrorValidation()
	{
		loginpage.details("praveen@gmail.com", "12345678");
		Assert.assertEquals("Incorrect email or password.", loginpage.geterrormsg());
	}
	
	@Test
	public void ProductErrorValidation() throws IOException {
		
		String myproduct = "ZARA COAT 3";
		ProductCatalogue catalogue = loginpage.details("anshika@gmail.com" , "Iamking@000");
		
		List<WebElement> products = catalogue.getProductslist();
		
		catalogue.addtocart(myproduct);
		
		Cartpage cartpage = catalogue.gotocart();
		
		Boolean match = cartpage.Cartlistitmes(myproduct);
		
		Assert.assertTrue(match);

}
}
