package Test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReader;
import Pages.ContactUsPage;
import Pages.HomePage;

public class ContactUsTest extends TestBase {

	@DataProvider(name = "ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		//get data from Excel
		ExcelReader ER = new ExcelReader();
			return ER.getExcelData();
		
	}
	
	HomePage homeObject;
	ContactUsPage contactObject;
	
	@Test(dataProvider = "ExcelData")
	public void SendInvalidMailsToContactUs(String name,String mail,String subject, String Message) {
	   homeObject = new HomePage(driver);
	   homeObject.OpenContactUsPage();
	   contactObject = new ContactUsPage(driver);
	   contactObject.SendContent(name, mail, subject, Message);
	   assertTrue(contactObject.ErrorMessage.isDisplayed());
	   driver.navigate().refresh();
	   
	   
	}
}
