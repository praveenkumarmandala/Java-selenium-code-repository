package TestngFrameworkDesign;

import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalonecode {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		String myproduct = "IPHONE 13 PRO";
		driver.findElement(By.id("userEmail")).sendKeys("praveenkumar@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Praveen123");
		driver.findElement(By.cssSelector("#login")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
	    WebElement prod = products.stream().filter(product->
	    product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("iphone 13 pro")).findFirst().orElse(null);
	    prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	    
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
	    
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
	    driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
	    
	    List <WebElement> cartitems = driver.findElements(By.cssSelector(".cartSection h3"));
	    Boolean match = cartitems.stream().anyMatch(cartitem->cartitem.getText().equalsIgnoreCase(myproduct));
	    Assert.assertTrue(match);
	    
	    driver.findElement(By.cssSelector(".totalRow button")).click();
	    driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("India");
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	    driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	    driver.findElement(By.cssSelector(".action__submit")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
	    String confirmmsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
	    
	  
	    Assert.assertTrue(confirmmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	    
	    System.out.println("praveen kumar");
	    System.out.println("praveen kumar");
	    System.out.println("praveen kumar");
	    
	    System.out.println("praveen kumar m");
	    System.out.println("praveen kumar m");
	    
	    driver.close();
	    

	}

}
