package pageObjectModel;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject extends BasePageObjectModel {

	public LoginPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	@FindBy(name = "username")
	WebElement txtUsername;
	@FindBy(id = "loginButton")
	WebElement btnLogin;
	@FindBy(id = "password")
	WebElement txtPassword;
	@FindBy(id = "Pharmacy")
	WebElement btnPharmacy;

	public void sendTextToUsername(String username) {
		txtUsername.sendKeys(username);
	}

	public void sendTextToPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickLoginBtn() {
		btnLogin.click();
	}

	public void clickOnPharmacyBtn() {
		btnPharmacy.click();
	}
}
