package end2endframework;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectRepository.AutoPractiseHome;
import pageObjectRepository.AutoPractiseLogin;
import resources.BaseUtility;

public class LoginPageTest extends BaseUtility{
public resources.MysqlConnect conc;
public AutoPractiseHome hpo;
public AutoPractiseLogin lpo;

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
	
}

@Test
	public void VerifyLogin() throws SQLException, IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		 hpo=new AutoPractiseHome(driver);
		 lpo=new AutoPractiseLogin(driver);
		hpo.signin().click();
		conc= new resources.MysqlConnect();
		Statement st= conc.databaseconnection1();
		ResultSet rs= st.executeQuery("select * from employeelogin");
		rs.next();
		lpo.email().sendKeys(rs.getString("Username"));
		lpo.password().sendKeys(rs.getString("password")); 
		lpo.Submit().click();
			
	}

@AfterTest
public void teardown()
{
	driver.close();
	driver=null;
}
	
}
	

