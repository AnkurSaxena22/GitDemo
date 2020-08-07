package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[contains(text(),'Login')]")
	WebElement SignIn;
	
	@FindBy(css="[class='text-center']>h2")
	WebElement Title;
	
	@FindBy(css="[class*='nav navbar-nav']")
	WebElement NavigateTabs;
	
	
	public WebElement login() {
		return SignIn;
	}
	
	public WebElement getTitle() {
		return Title;
	}
	
	public WebElement NavigateTabs() {
		return NavigateTabs;
	}

}
