package Pages;
import org.openqa.selenium.By;
import org.testng.Assert;

import testbase.TestBaseClass;
public class LoginPage extends TestBaseClass {
	
	
	public static void PageTiTleTest()
	{
	String SigninTitle=	driver.findElement(By.linkText("Sign in")).getText();
	String Title="Sign in";
  Assert.assertTrue(SigninTitle.equals(Title), "Sign in button not present");
	}
public static void LoginTest(String username,String password) throws InterruptedException
{
	driver.findElement(By.linkText("Sign in")).click();
	System.out.println("clicked successfully");
	Thread.sleep(3000);
	driver.findElement(By.id("login_id")).sendKeys(username);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='nextbtn']//span[contains(text(),'Sign in')]")).click();
		Thread.sleep(30000);
}   
}