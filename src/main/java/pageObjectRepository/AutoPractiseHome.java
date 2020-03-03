package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoPractiseHome {

	public WebDriver driver;
	
	public AutoPractiseHome(WebDriver driver) {
		this.driver=driver;
	}
	
	private By signin= By.xpath("//a[contains(text(),'Sign in')]");
	private By searchbox =By.id("search_query_top");
	private By Navbar= By.cssSelector("div[role='navigation']");
		

	public WebElement signin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement searchbox()
	{
		return driver.findElement(searchbox);
	}
}
