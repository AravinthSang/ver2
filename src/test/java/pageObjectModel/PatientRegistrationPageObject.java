package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PatientRegistrationPageObject extends BasePageObjectModel {

	public PatientRegistrationPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name = "givenName")
	WebElement txtName;
	@FindBy(name = "middleName")
	WebElement txtMiddleName;
	@FindBy(name = "familyName")
	WebElement txtFamilyName;
	@FindBy(id = "next-button")
	WebElement btnNext;
	@FindBy(id = "checkbox-unknown-patient")
	WebElement chkbxUnidentified;
	@FindBy(id = "gender-field")
	WebElement slctGender;
	@FindBy(name = "birthdateDay")
	WebElement txtDay;
	@FindBy(name = "birthdateMonth")
	WebElement slctMonth;
	@FindBy(name = "birthdateYear")
	WebElement txtYear;
	@FindBy(name = "birthdateYears")
	WebElement txtEstimateYears;
	@FindBy(name = "birthdateMonths")
	WebElement txtEstimateMonths;

	@FindBy(id = "address1")
	WebElement txtAddress1;
	@FindBy(id = "address2")
	WebElement txtAddress2;
	@FindBy(id = "cityVillage")
	WebElement txtVillageCity;
	@FindBy(id = "stateProvince")
	WebElement txtStateProvince;
	@FindBy(id = "country")
	WebElement txtCountry;
	@FindBy(id = "postalCode")
	WebElement txtPostalCode;

	@FindBy(name="phoneNumber")
	WebElement txtPhoneNumber;
	
	@FindBy(name="relationship_type")
	WebElement slctRelationship;
	
	@FindBy(xpath="//*[@id='relationship']/p[2]/input[1]")
	WebElement txtPersonName;
	@FindBy(id="submit")
	WebElement btnConfirm;
	
	public void clickOnConfimBtn() {
		btnConfirm.click();
	}
	public void sendTextToPersonName(String name) {
		txtPersonName.sendKeys(name);
	}
	public void selectRelationship(String relation) {
		Select select=new Select(slctRelationship);
		select.deselectByVisibleText(relation);
	}
	public void sendTextToPhoneNumber(String ph) {
		txtPhoneNumber.sendKeys(ph);
	}
	public void sendTextToAddress1(String address) {
		txtAddress1.sendKeys(address);
	}

	public void sendTextToAddress2(String address) {
		txtAddress2.sendKeys(address);
	}

	public void sendTextToVillageCity(String villageCity) {
		txtVillageCity.sendKeys(villageCity);
	}

	public void sendTextToState(String state) {
		txtStateProvince.sendKeys(state);
	}

	public void sendTextToCountry(String country) {
		txtCountry.sendKeys(country);
	}
	public WebElement getSlctMonth() {
		
		return slctMonth;
	}

	public void sendTextToPostalCode(String code) {
		txtPostalCode.sendKeys(code);
	}

	public void selectMonth(String month) {
		Select select = new Select(slctMonth);
		select.selectByVisibleText(month);
	}

	public void sendTxtToDay(String day) {
		txtDay.sendKeys(day);
	}

	public void sendTxtToYear(String year) {
		txtYear.sendKeys(year);
	}

	public void sendTxtToEstimateYears(String year) {
		txtEstimateYears.sendKeys(year);
	}

	public void sendTxtToMonths(String month) {
		txtEstimateMonths.sendKeys(month);
	}

	public void clickOnNext() {
		btnNext.click();
	}

	public void clickOnUnidentified() {
		chkbxUnidentified.click();
	}

	public void sendTextToName(String name) {
		txtName.sendKeys(name);
	}

	public void sendTextToMiddleName(String name) {
		txtMiddleName.sendKeys(name);
	}

	public void sendTextToFamilyName(String name) {
		txtFamilyName.sendKeys(name);
	}

	public void selectGender(String gender) {

		Select select = new Select(slctGender);
		wait.until(ExpectedConditions.visibilityOf(slctGender));
		select.selectByVisibleText(gender);
//		WebElement btnConfirm=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
//		btnConfirm.click();

	}
	public void clearName() {
		txtName.clear();
	}
	public void clearFamilyName() {
		txtFamilyName.clear();
	}
	public void clearDOB() {
		txtDay.clear();
		txtYear.clear();
		
	}
	public void clearPhoneNumber() {
		txtPhoneNumber.clear();
	}

}
