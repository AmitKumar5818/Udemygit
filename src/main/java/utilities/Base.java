package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public WebDriver driver;
	
	public   WebDriver initializeDriver() throws IOException {
		Properties prop= new Properties();
		FileInputStream fis = new FileInputStream("D:\\AutomationPractice\\frmork\\src\\main\\java\\utilities\\ConfigReader.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromeDriverpath"));
			driver= new ChromeDriver();
			System.out.println(browserName);
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			System.out.println(browserName);
			System.setProperty("webdriver.gecko.driver", prop.getProperty("GeckoDriverpath"));
			driver= new FirefoxDriver();
			
		}
		else if (browserName.equalsIgnoreCase("IE")) {
			System.out.println(browserName);
			System.setProperty("webdriver.ie.driver", prop.getProperty("IEDriverpath"));
			driver= new InternetExplorerDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	


}
