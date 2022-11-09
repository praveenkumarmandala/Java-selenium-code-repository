package TestngFrameworkDesign.TestingComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import TestngFrameworkDesign.pageobectmodel.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	
	public WebDriver driver;
	public Loginpage loginpage;
	
	public WebDriver InitializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\TestngFrameworkDesign\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "path");
			 driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "path");
			 driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		return driver;
	}
	@BeforeMethod(alwaysRun=true)
	public Loginpage launchingApplication() throws IOException
	{
		driver = InitializeDriver();
		loginpage = new Loginpage(driver);
		loginpage.Goto();
		return loginpage;
	}
	
	public List<HashMap<String, String>> getjsonDatatoMap(String filepath) throws IOException
	{
		String jsoncontent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		
		//jackson databind dependencies from mvn rep and paste in pom.xml
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String,String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>() {});
		
		return data;
	}
	
	
	
	
	@AfterMethod(alwaysRun = true)
	public void teardown()
	{
		driver.close();
	}

}
