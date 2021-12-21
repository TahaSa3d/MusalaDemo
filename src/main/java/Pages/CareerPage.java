package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerPage extends PageBase {

	public CareerPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'Check our open positions')]")
	WebElement CheckPositionButton;

	@FindBy(id = "get_location")
	WebElement LocationSelector;

	@FindBy(xpath = "//body/main[@id='join-us']/div[@id='primary']/div[@id='content']/section[1]/div[2]/article[2]/div[1]/a[1]/div[1]/div[1]")
	WebElement QAPosition;

	@FindBy(xpath = "//h2[contains(text(),'General description')]")
	public WebElement GeneralDescription;

	@FindBy(xpath = "//h2[contains(text(),'Requirements')]")
	public WebElement Requirments;

	@FindBy(xpath = "//h2[contains(text(),'Responsibilities')]")
	public WebElement Responsibilities;

	@FindBy(xpath = "//h2[contains(text(),'What we offer')]")
	public WebElement WhatWeOffer;

	@FindBy(xpath = "//body/main[1]/div[1]/div[1]/section[1]/article[1]/div[1]/div[2]/div[2]/a[1]/input[1]")
	public WebElement ApplyButton;

	@FindBy(id = "cf-1")
	WebElement NameField;

	@FindBy(id = "cf-2")
	WebElement EmailField;

	@FindBy(id = "cf-3")
	WebElement MobileField;

	@FindBy(id = "uploadtextfield")
	WebElement uploadtextfield; 

	@FindBy(xpath = "//span[@id='recaptcha-anchor']")
	WebElement recaptcha; 

	@FindBy(xpath = "//body/div[@id='fancybox-wrap']/div[@id='fancybox-outer']/div[@id='fancybox-content']/div[1]/div[1]/div[1]/form[1]/div[3]/p[1]/input[1]")
	public WebElement SendButton;

	@FindBy(xpath = "//button[contains(text(),'Close')]")
	WebElement CloseButton;

	@FindBy(xpath = "//span[contains(text(),'The e-mail address entered is invalid.')]")
	public WebElement MailErrorMessage;

	@FindBy(xpath = "//article[@class='card-jobsHot']")
	List<WebElement> AvailablePosition;

	@FindBy(xpath = "//article[@class = 'card-jobsHot card-regular']")
	List<WebElement> OtherAvailablePosition;

	@FindBy(xpath = "//h2[@class = 'card-jobsHot__title']")
	List<WebElement> Positiontitle;

	@FindBy(xpath = "//a[@class = 'card-jobsHot__link']")
	List<WebElement> PositionInfo;

	public void OpenPositionsPage() 
	{
		ClickButton(CheckPositionButton);

	}
	public void ChooseThePosition(String location)
	{
		SelectDropDown(LocationSelector, location);
	}
	public void ClickOnQAPosition() {
		ClickButton(QAPosition);
	}
	public void ApplyForQAJob_InvalidMail(String name,String mail,String mobile) 
	{
		ClickButton(ApplyButton);
		SendKeysMethod(NameField, name);
		SendKeysMethod(EmailField, mail);
		SendKeysMethod(MobileField, mobile);
		SendKeysMethod(uploadtextfield, "C:\\Users\\NasserR\\Downloads\\CV.pdf");
		ClickButton(SendButton);
		ClickButton(CloseButton);
	}
	public void GetAvailablePosition(String location)
	{
		String title;
		String info;
		System.out.println(location);

			for (int i=0;i<AvailablePosition.size();++i) {
				if (AvailablePosition.get(i).getText().contains(location))
				{
					title = Positiontitle.get(i).getText();
					info = PositionInfo.get(i).getAttribute("href");
					System.out.println("Position : "+ title);
					System.out.println("MoreInfo :" + info);
				}

			}


			for (int i=0;i<OtherAvailablePosition.size();++i) {
				if (OtherAvailablePosition.get(i).getText().contains(location))
				{
					int index = i;
					title = Positiontitle.get(index+AvailablePosition.size()).getText();
					info= PositionInfo.get(index+AvailablePosition.size()).getAttribute("href");
					System.out.println("Position : " +title );
					System.out.println("More Info : " +info);
				}

			}

	}

}
