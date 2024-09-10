package germany;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_Page
{
	WebDriver d1;
	@BeforeMethod
	public void brower_launch()
	{
	d1 =new ChromeDriver();
	d1.get("https://app.germanyiscalling.com/common/login/?next=https%3A%2F%2Fapp.germanyiscalling.com%2Fcv%2Fhome%2F");
	
	}
	@Test
	public void login()
	{
		// enter the username in the username text field
		WebElement s1 =d1.findElement(By.id("username"));
		s1.sendKeys("m.leenadevi@gmail.com");
		// enter the password in the password text field 
		WebElement s2 =d1.findElement(By.id("password"));
		s2.sendKeys("12345@RL");
		// clicking on the login button 
		WebElement s3 = d1.findElement(By.xpath("//button [@ class ='btn btn-danger mt-3']"));
		s3.sendKeys(Keys.ENTER);
		// After clicking the login button, check the URL of the next page 
		String actualUrl ="https://app.germanyiscalling.com/cv/upload/";
		String expectedUrl = "https://app.germanyiscalling.com/cv/upload/";

		// Assert that the actual URL matches the expected URL
		Assert.assertEquals(actualUrl, expectedUrl, "User is redirected to the expected URL after login.");
			
	}
@ AfterMethod
public void browser()
{
	d1.close();
}
}
