package testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.HomePageObject;
import pageObjectModel.PatientRegistrationPageObject;

public class TC01_RegistrationOfPatient extends BaseTestCase {


	@Test
	public void validateWithOnlyMandatoryData() {
		SoftAssert softAssert=new SoftAssert();
		driver.get("https://demo.openmrs.org/openmrs/referenceapplication/home.page");
		HomePageObject homepage=new HomePageObject(driver);
		homepage.clickOnRegisterPatientBtn();
		PatientRegistrationPageObject patientPage=new PatientRegistrationPageObject(driver);
		patientPage.sendTextToName("Sujith");
		patientPage.sendTextToFamilyName("Kumar");
		patientPage.clickOnNext();
		patientPage.selectGender("Male");
		patientPage.clickOnNext();
		patientPage.sendTxtToDay("04");
		patientPage.selectMonth("January");
		patientPage.sendTxtToYear("2001");
		patientPage.clickOnNext();
		patientPage.sendTextToAddress1("19 GeorgeTown");
		patientPage.clickOnNext();
		//skipping fields that are not mandatory
		patientPage.clickOnNext();//phoneNumber
		patientPage.clickOnNext();//Relatives
		patientPage.clickOnConfimBtn();
		//Confirming registration by validating paitent name
		WebElement nameSpan=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='PersonName-givenName']")));
		String name=nameSpan.getText();
		softAssert.assertTrue(name.contains("Sujith"));
	
	}
	@Test
	public void validateUnIdentifiedPatient() {
		SoftAssert softAssert=new SoftAssert();
		driver.get("https://demo.openmrs.org/openmrs/referenceapplication/home.page");
		HomePageObject homepage=new HomePageObject(driver);
		homepage.clickOnRegisterPatientBtn();
		PatientRegistrationPageObject patientPage=new PatientRegistrationPageObject(driver);
		patientPage.clickOnUnidentified();
		patientPage.selectGender("Male");
		patientPage.clickOnNext();
		patientPage.clickOnConfimBtn();
		//confirming registration by presence of Id
		WebElement id=wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em[normalize-space()='Patient ID']/following-sibling::span")));
		softAssert.assertFalse(id.getText().isEmpty());// expecting false because ID will Be generated
		
	}
	@Test
	public void validateByprovindingInvalidData() {
		SoftAssert softAssert=new SoftAssert();
		driver.get("https://demo.openmrs.org/openmrs/referenceapplication/home.page");
		HomePageObject homepage=new HomePageObject(driver);
		homepage.clickOnRegisterPatientBtn();
		PatientRegistrationPageObject patientPage=new PatientRegistrationPageObject(driver);
		patientPage.sendTextToName("Sujith");
		patientPage.sendTextToFamilyName("Kumar");
		patientPage.clickOnNext();
		patientPage.selectGender("Male");
		patientPage.clickOnNext();
		//providing invalid data in DOB
		patientPage.sendTxtToDay("32");
		patientPage.selectMonth("January");
		patientPage.sendTxtToYear("2027");
		patientPage.clickOnNext();
		//validation of error message
		WebElement dayError=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Maximum: 31']")));
		WebElement yearError=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Maximum: 2024']")));
		softAssert.assertTrue(dayError.isDisplayed());
		softAssert.assertTrue(yearError.isDisplayed());
		//clearing invalid & providing valid data to DOB
		patientPage.clearDOB();
		patientPage.sendTxtToDay("31");
		patientPage.sendTxtToYear("2001");
		patientPage.clickOnNext();
	
		patientPage.sendTextToAddress1("19 GeorgeTown");
		patientPage.clickOnNext();
		
		patientPage.sendTextToPhoneNumber("4234234");
		patientPage.clickOnNext();

		softAssert.assertAll();
		
		
	}
}
