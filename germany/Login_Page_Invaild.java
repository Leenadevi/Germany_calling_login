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

public class Login_Page_Invaild 
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
		s1.sendKeys("m.leenadevi@gmail.co");
		// enter the password in the password text field 
		WebElement s2 =d1.findElement(By.id("password"));
		s2.sendKeys("12345@R");
		// clicking on the login button 
		WebElement s3 = d1.findElement(By.xpath("//button [@ class ='btn btn-danger mt-3']"));
		s3.sendKeys(Keys.ENTER);
		// indicate that error message displayed properly
		WebElement s4  =d1.findElement(By.xpath("//div[@class='alert alert-danger']"));
		 if (s4.isDisplayed()==true)
		 {
			 System.out.println("Please enter a correct username and password. Note that both fields may be case-sensitive.");
		 }
		//Assert.assertTrue(s4.isDisplayed(), "Please enter a correct username and password. Note that both fields may be case-sensitive.");
		
		//  verify that the user is still on the login page
	    String expectedUrl = "https://germanyiscalling.com/login";
	    Assert.assertEquals(d1.getCurrentUrl(), expectedUrl, "User is in the login page itself.");
			
	}
@ AfterMethod
public void browser()
{
	d1.close();
}
}

