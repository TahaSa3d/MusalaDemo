package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class PageBase {


	protected WebDriver driver;
	public JavascriptExecutor jse;
	public Actions action;
	
	
	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	protected static void SendKeysMethod(WebElement element,String Text) {
		element.sendKeys(Text);
	}

	protected static void ClickButton(WebElement element) {
		element.click();
	}
	protected static void SelectDropDown(WebElement element,String text) {

		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void Scrolldown()
	{
		jse.executeScript("scrollBy(0,2500)");
	}
}
