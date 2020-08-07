package EndToEndFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPage;

public class ValidateText extends base {
	public static Logger log= LogManager.getLogger(ValidateText.class.getName());
	
	//Sometimes when test cases are run in parallel it can fail as multiple class are using same driver instance from base class it gets overwritten
	//It is good practice to declare one global driver for each class.
	public WebDriver driver;
	
	@BeforeTest
	
	public void prerequiste() throws IOException {
		driver=driverInvoke();
		log.info("Driver is initialised");
		
		driver.get(qaAcademyUrl);
		
		log.info("Opening URL");
	}

	@Test

	public void textcheck() {
		
		LandingPage lp= new LandingPage(driver);
		String value=lp.getTitle().getText();
		
		Assert.assertEquals(value, "FATURE COURSE");
		log.info("Test Validation successfull");
		System.out.println("Created copy from Github");
		
		
	}
	@Test
	public void navigationtab() {
		LandingPage lp= new LandingPage(driver);
		Assert.assertTrue(lp.NavigateTabs().isDisplayed());
		log.info("Test Validation successfull");
	}
	@AfterTest
	
	public void closebrowser() {
		driver.close();
	}

}
