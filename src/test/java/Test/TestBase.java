package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Data.ConfigFileReader;
import Utilites.Helper;


public class TestBase {

	public static WebDriver driver;
    ConfigFileReader ConfigFileReader;
	
	@BeforeSuite
	@Parameters({"browser"})
	public void StartDriver(@Optional("chrome") String Browsername) {
         ConfigFileReader = new ConfigFileReader();
         
		//ignore case(capital & small) of the browser characters 
		if(Browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Browsername.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to(ConfigFileReader.getApplicationUrl());
        
	}
	@AfterSuite
	public void StopDriver() {
		driver.quit();
	}
     
	//Take screenshot when test case fails
	@AfterMethod
	public void TakescreenshotOnFailure(ITestResult result) 
	{
		if(result.getStatus() == ITestResult.FAILURE) 
		{
			System.out.println("Failed");
			System.out.println("Take ScreenShot ....");
			Helper.CaptureScreenShot(driver, result.getName());
		}
	}

}
