package Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.FileReader;
import java.io.IOException;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import Pages.CareerPage;
import Pages.HomePage;

public class CareerTest extends TestBase{

	CSVReader reader;
	HomePage homeObject;
	CareerPage careerObject;
	
	
	@Test
	public void ApplyForJobWithInvalidMail() throws CsvValidationException, IOException 
	{
		String CSV_File = System.getProperty("user.dir")+"/src/test/java/Data/CareerData.csv";
		reader = new CSVReader(new FileReader(CSV_File));
		
		String[] csvcell;
		
		//while loop will be executed till the last value in csv file
		while((csvcell= reader.readNext()) != null)
		{
			String location = csvcell[0];
			String name = csvcell[1];
			String email = csvcell[2];
			String mobile = csvcell[3];
		homeObject = new HomePage(driver);
		homeObject.OpenCareerPage();
		careerObject = new CareerPage(driver);
		careerObject.OpenPositionsPage();
		assertEquals(driver.getCurrentUrl(), "https://www.musala.com/careers/join-us/");
		careerObject.ChooseThePosition(location);
		assertTrue(careerObject.GeneralDescription.isDisplayed());
		assertTrue(careerObject.Requirments.isDisplayed());
		assertTrue(careerObject.Responsibilities.isDisplayed());
		assertTrue(careerObject.WhatWeOffer.isDisplayed());
		assertTrue(careerObject.ApplyButton.isDisplayed());
		careerObject.ApplyForQAJob_InvalidMail(name, email, mobile);
		assertTrue(careerObject.MailErrorMessage.isDisplayed());

		}
	}
		
}
