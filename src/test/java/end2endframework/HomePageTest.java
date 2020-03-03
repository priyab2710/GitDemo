package end2endframework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectRepository.HomePageObjects;
import pageObjectRepository.LoginPage;
import resources.BaseUtility;


public class HomePageTest extends BaseUtility{

	public static Logger log= LogManager.getLogger(HomePageTest.class.getName());
	
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
		
	}
	
	@Test(dataProvider="getdata")	
	public void openhomepage(String username, String password, String usertype) throws IOException
	{
		driver.get(prop.getProperty("urlqa"));
		HomePageObjects hpo= new HomePageObjects(driver);
		hpo.signin().click();
		//System.out.println(driver.getTitle());
		LoginPage lp= new LoginPage(driver);
		System.out.println("***********Test for " + usertype+" *************");
		
		lp.getemail().sendKeys(username);
		lp.password().sendKeys(password);
		lp.loginbutton().click();
		
		String actualmessage= driver.findElement(By.cssSelector("[class*='alert alert-danger']")).getText();
		//Assert.assertEquals(actualmessage, "Invalid email or password.");
		Assert.assertEquals(actualmessage, "Invalid email or password.", "This test is for "+ usertype);
			
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	
	@DataProvider
    public Object[][] getdata() 
	{
		Object[][] obj = new Object[2][3];
		/*obj[0][0]="priyab2710@gmail.com";
		obj[0][1]="password1";
		obj[0][2]="Restricted User";
	
		obj[1][0]="username2@testing.com";
		obj[1][1]="password2";
		obj[1][2]="Non Restricted User";*/
		
		obj[0][0]=prop.getProperty("username1");
		obj[0][1]=prop.getProperty("password1");
		obj[0][2]=prop.getProperty("Restricted User");
	
		obj[1][0]=prop.getProperty("username2");
		obj[1][1]=prop.getProperty("password2");
		obj[1][2]=prop.getProperty("Non Restricted User");
		return obj;
	}
	
	
}
