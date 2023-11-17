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

import Pages.LoginPage;
import Util.ReadXLSdata;
import Util.Utility;
import testbase.TestBaseClass;

public class LoginPageTest extends TestBaseClass{
LoginPage loginpage;
ExtentTest logger;
ExtentReports extent;

public LoginPageTest() {
super();
}
@BeforeMethod
public void Init() throws IOException
{
	setUp();
	ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\reports\\learn_automation1.html");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	logger=extent.createTest("LoginTest");
}
@Test
public void getTitle()
{
	LoginPage.PageTiTleTest();
	
}
@Test(dataProviderClass=ReadXLSdata.class,dataProvider="data")
public void LoginTest(String s1, String s2) throws InterruptedException
{
	System.out.print("S1 : "+s1+" S2 : "+s2);
	LoginPage.LoginTest(s1, s2);
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
