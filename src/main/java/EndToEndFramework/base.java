package EndToEndFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class base {

	public WebDriver driver;
	String qaAcademyUrl;
	public WebDriver driverInvoke() throws IOException {
		
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		//For changing brwoser input from data property file to jenkins build, take the variable from System properties
		
		String browsername=System.getProperty("browser");
		
		//With mvn test -Dbrowser=chrome (Jenkins can assign browser value to chrome)
		
		/*System.out.println(prop.getProperty("browser"));
		String browsername=prop.getProperty("browser");*/
		
		qaAcademyUrl=prop.getProperty("qaAcademyUrl");
		
		if (browsername.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sony\\chromedriver.exe");
			
			//Headless can be added to perform execution without invoking browser
			ChromeOptions options= new ChromeOptions();
			
			if (browsername.contains("headless")) {
			options.addArguments("headless");
			}
				
			 driver=new ChromeDriver(options);
		}
		else if (browsername.contentEquals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sony\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Select browser as chrome or firefox");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	public String screenshot(String TestName,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
	    File source=	ts.getScreenshotAs(OutputType.FILE);
	    String destinationFile=System.getProperty("user.dir")+"\\reports\\"+TestName+".png";
		FileUtils.copyFile(source,new File(destinationFile) );
		
		return destinationFile;
	}
	
	
}
