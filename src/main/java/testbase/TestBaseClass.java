package testbase;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

//this will act as a parent class
public class TestBaseClass {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
    
	public void setUp() throws IOException {
		if (driver == null) {
						FileReader fr = new FileReader(
					System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
			prop.load(fr);
					}
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriverpath"));
			 driver = new ChromeDriver();
			driver.get(prop.getProperty("applicationurl"));
		} 
		else if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			driver.get(prop.getProperty("applicationurl"));
		}
	}

	public void tearDown() {
    driver.close();
	}
}