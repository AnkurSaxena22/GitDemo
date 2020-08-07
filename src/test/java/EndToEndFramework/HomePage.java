package EndToEndFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends base {
	public WebDriver driver;
	public static Logger log= LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	
	public void browserInvoke() throws IOException {
		driver=driverInvoke();
	}
   
	@Test(dataProvider="getData")
	public void openURL(String username, String password) throws IOException  {
		
		driver.get(qaAcademyUrl);
		LandingPage lp=new LandingPage(driver);
		lp.login().click();
		
		LoginPage l=new LoginPage(driver);
		l.emailid().sendKeys(username);
		l.password().sendKeys(password);
		log.info("Test Validation successfull");
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		//Row stands for number of data set you need to pass (valid or invalid email id)
		//Column stand for no. of parameters you need to send for part of one data set
		Object[][] data=new Object[2][2];
		
		data[0][0]="ankur";
		data[0][1]="rukna";
		data[1][0]="ankit";
		data[1][1]="tikna";
		
		return data;
		
	}
@AfterTest
	
	public void closebrowser() {
		driver.quit();
	}


}
