package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObject extends BasePageObjectModel {

	public HomePageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//i[@class='icon-user']")WebElement btnRegisterPatient;
	@FindBy(xpath="//i[@class='icon-search']")WebElement btnFindPatient;
	
	public void clickOnRegisterPatientBtn() {
		btnRegisterPatient.click();
	}
	public void clickOnFindPatientBtn() {
		btnFindPatient.click();
	}

}
