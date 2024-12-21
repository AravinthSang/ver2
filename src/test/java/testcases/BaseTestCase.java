package testcases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObjectModel.LoginPageObject;

public class BaseTestCase {

	public static WebDriver driver;
	public Properties properties;
	
	WebDriverWait wait;

	@BeforeClass
	public void setup() {

		driver = new EdgeDriver();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		LoginPageObject loginPage = new LoginPageObject(driver);
		driver.manage().window().maximize();
		FileReader file;
		try {
			file = new FileReader("./src/test/resources/data.properties");
			properties = new Properties();
			properties.load(file);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(properties.getProperty("appUrl"));
			loginPage.sendTextToUsername(properties.getProperty("username"));
			loginPage.sendTextToPassword(properties.getProperty("password"));
			loginPage.clickOnPharmacyBtn();
			loginPage.clickLoginBtn();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
