package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CompanyPage extends PageBase{

	Actions action;
	
	public CompanyPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[contains(text(),'Leadership')]")
	public WebElement LeaderShipTitle;
	
	@FindBy(xpath = "//body/footer[1]/div[1]/div[1]/a[4]/span[1]")
	WebElement FacebookIcon;
	
	@FindBy(xpath = "//body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/img[1]")
	public WebElement MusalaPicture;
	
	public void OpenFacebookPage()
	{
		ClickButton(FacebookIcon);
	    action = new Actions(driver);
		    action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
	}


}
