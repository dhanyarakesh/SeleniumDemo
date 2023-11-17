package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import testbase.TestBaseClass;
public class HomePage extends TestBaseClass{
	@Test
	public static void HomePageTest() throws InterruptedException {
		driver.findElement(By.linkText("Sign in")).click();
		System.out.println("clicked successfully");
		Thread.sleep(3000);
		driver.findElement(By.id("login_id")).sendKeys("dhanyarakesh03@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
					Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Dha1357#");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='nextbtn']//span[contains(text(),'Sign in')]")).click();
			Thread.sleep(30000);
		driver.switchTo().frame(driver.findElement(By.id("zabFrame")));
		WebElement Zoho_Home_Title = driver.findElement(By.className("banner-section"));
		String homeTitle = Zoho_Home_Title.getText();
		System.out.println(homeTitle);
		String Title = " Some of our most popular apps";
		Assert.assertTrue(homeTitle.contains(Title));
		System.out.println("Home page loaded successfully");

	}
}