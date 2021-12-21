package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "cf-1")
	WebElement NameField;
	
	@FindBy(id = "cf-2")
	WebElement EmailField;
	
	@FindBy(id = "cf-4")
	WebElement SubjectField;
	
	@FindBy(id = "cf-5")
	WebElement MessageField;
	
	@FindBy(xpath = "//body/div[@id='fancybox-wrap']/div[@id='fancybox-outer']/div[@id='fancybox-content']/div[1]/div[1]/div[1]/form[1]/div[2]/p[1]/input[1]")
	WebElement recaptchaField;   
	
	@FindBy(xpath = "//body/div[@id='fancybox-wrap']/div[@id='fancybox-outer']/div[@id='fancybox-content']/div[1]/div[1]/div[1]/form[1]/div[2]/p[1]/input[1]\r\n")
	WebElement SendButton;
	
	@FindBy(xpath = "//span[contains(text(),'The e-mail address entered is invalid.')]")
	public WebElement ErrorMessage;
	
	@FindBy(id = "fancybox-close")
	WebElement CloseButton;
	
	public void SendContent(String name ,String mail, String subject, String message)
	{
		SendKeysMethod(NameField, name);
		SendKeysMethod(EmailField, mail);
		SendKeysMethod(SubjectField, subject);
		SendKeysMethod(MessageField, message);
		ClickButton(recaptchaField);
		ClickButton(SendButton);
	}
	public void ClosePopup()
	{
		ClickButton(CloseButton);
	}
	
	
}
