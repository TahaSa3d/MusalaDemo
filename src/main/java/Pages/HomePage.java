package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
    @FindBy(xpath = "//span[contains(text(),'Contact us')]")
    WebElement ContactUsButton;
    
    @FindBy(xpath = "//header/nav[2]/div[1]/div[1]/ul[1]/li[1]/a[1]")
	WebElement CompanyLink;
    
    @FindBy(xpath = "//header/nav[2]/div[1]/div[1]/ul[1]/li[5]/a[1]")
	WebElement CareerLink;
    
    public void OpenContactUsPage() 
    {
    	ClickButton(ContactUsButton);
    }
    public void OpenCompanyPage() 
    {
    	ClickButton(CompanyLink);
    }
    public void OpenCareerPage() 
    {
    	ClickButton(CareerLink);
    }
}
