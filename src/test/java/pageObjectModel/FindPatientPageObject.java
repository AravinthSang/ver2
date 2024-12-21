package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindPatientPageObject extends BasePageObjectModel {

	public FindPatientPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id="patient-search") WebElement txtPatientSearch;
	
	public void sendTextToPatientSearch(String value) {
		txtPatientSearch.clear();
		txtPatientSearch.sendKeys(value);
	}

}
