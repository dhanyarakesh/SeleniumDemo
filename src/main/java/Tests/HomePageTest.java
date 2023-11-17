package Tests;
import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.HomePage;
import Pages.LoginPage;
import Util.ReadXLSdata;
import Util.Utility;
import testbase.TestBaseClass;

public class HomePageTest extends TestBaseClass{
	LoginPage loginpage;
	HomePage homepage;
	ExtentTest logger;
	ExtentReports extent;

	public HomePageTest() {
	super();
	}
	@BeforeMethod
	public void Init() throws IOException
	{
		setUp();
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\reports\\learn_automation1.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger=extent.createTest("HomeTest");
	}
	@Test
	public void getTitle() throws InterruptedException
	{
		HomePage.HomePageTest();
	
		
	}
		@AfterMethod
	public void Quit(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String temp=Utility.getScreenshot(driver);
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		extent.flush();
		driver.quit();
	}
	}


