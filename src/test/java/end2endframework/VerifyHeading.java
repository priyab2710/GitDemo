package end2endframework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjectRepository.HomePageObjects;
import resources.BaseUtility;

public class VerifyHeading extends BaseUtility {

	public static Logger log= LogManager.getLogger(BaseUtility.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		
		log.info("----------Initializing driver-------------");
		try {
		driver = initializeDriver();
		}
		catch (Exception e)
		{
			log.error("Initializing Driver Failed due to exception"+e);
		}

		driver.get(prop.getProperty("urlqa"));
		log.info("URL opened"+prop.getProperty("urlqa"));
	}
	
	@Test
	public void VerifyTitle() throws IOException
	{
		HomePageObjects hpo= new HomePageObjects(driver);
		log.info("Verifying title");
		Assert.assertEquals(hpo.headingtitle().getText(), "FEATURED COURSES");
		log.info("Verifying if navbar displayed");
		Assert.assertTrue(hpo.Navbar().isDisplayed());
	
	}
	@AfterTest
	public void teardown()
	{
		log.info("Closing browser");
		driver.close();
		driver=null;
	}
}
