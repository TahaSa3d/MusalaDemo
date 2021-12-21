package Test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Pages.CareerPage;
import Pages.HomePage;

public class AvailablePositions extends TestBase {

	HomePage homeObject;
	CareerPage careerObject;
	
	@Test
	public void SearchOnPositions() 
	{
		homeObject = new HomePage(driver);
		homeObject.OpenCareerPage();
		careerObject = new CareerPage(driver);
		careerObject.OpenPositionsPage();
		careerObject.ChooseThePosition("Sofia");
		careerObject.GetAvailablePosition("Sofia");
		careerObject.ChooseThePosition("Skopje");
		careerObject.GetAvailablePosition("Skopje");
		
	}
}
