package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import testbase.TestBaseClass;

public class HomePage extends TestBaseClass {
	@Test
	public static void HomePageTest() throws InterruptedException {
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