package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {

	
	public WebDriver driver;
	
	public HomePageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	private By signin= By.cssSelector("a[href*='sign_in']");
	private By headingtitle =By.cssSelector("div[class='text-center'] h2");
	private By Navbar= By.cssSelector("div[role='navigation']");
		

	public WebElement signin()
	{
		return driver.findElement(signin);
	}
	public WebElement headingtitle()
	{
		return driver.findElement(headingtitle);
	}
	public WebElement Navbar()
	{
		return driver.findElement(Navbar);
	}
}
