package Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Pages.CompanyPage;
import Pages.HomePage;

public class CompanyTest extends TestBase{

	HomePage homeObject;
	CompanyPage companyObject;
	
	@Test
	public void VerifyCompanyTest() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.OpenCompanyPage();
		companyObject = new CompanyPage(driver);
		assertEquals(driver.getCurrentUrl(), "https://www.musala.com/company/");
		assertTrue(companyObject.LeaderShipTitle.isDisplayed());
		companyObject.OpenFacebookPage();
		String parent_tab = driver.getWindowHandle();;
		WebDriverWait wait = new WebDriverWait(driver,5);
	    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	    Set<String> s1 = driver.getWindowHandles();
	    Iterator<String> i1 = s1.iterator();
	    while(i1.hasNext())
	    {
	       String child_tab = i1.next();
	        if (!parent_tab.equalsIgnoreCase(child_tab))
	        {
	        driver.switchTo().window(child_tab);
	        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("facebook.com"));
	        String currentURL;
	        currentURL = driver.getCurrentUrl();
		assertEquals(currentURL, "https://www.facebook.com/MusalaSoft?fref=ts");
		assertTrue(companyObject.MusalaPicture.isDisplayed());
	}
	    }
	    }}
