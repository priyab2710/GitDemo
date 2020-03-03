package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseUtility {
	public static Logger log= LogManager.getLogger(BaseUtility.class.getName());
	public Properties prop;
	public static WebDriver driver;

	public WebDriver initializeDriver() throws IOException {
	
		 prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
				
		prop.load(fis);
		//String browsername = prop.getProperty("browser");
		String browsername = System.getProperty("browser");
		// Invoke Chrome
		if (browsername.contains("chrome")) {
			log.info("Opening tests in chrome browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\BrowserDriver\\chromedriver.exe");
			ChromeOptions co= new ChromeOptions();
			//co.addArguments("headless");
			if(browsername.contains("headless"))
			{
			co.setHeadless(true);
			}
		
			driver = new ChromeDriver(co);
		}
		// Invoke Internet explorer
		else if (browsername.equalsIgnoreCase("IE")) {
			log.info("Opening tests in internet explorer browser");
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\BrowserDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		// Invoke Firefox browser
		else if (browsername.equalsIgnoreCase("firefox"))
				{
			log.info("Opening tests in firefox browser");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\BrowserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
	}
	
	public void screenshot(String result) throws IOException
	{
		File src =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Work_pri\\"+result+"screenshot.png"));
	}
	
}
