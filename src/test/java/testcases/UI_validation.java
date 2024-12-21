package testcases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.HomePageObject;
import pageObjectModel.PatientRegistrationPageObject;

public class UI_validation extends BaseTestCase {

	@Test
	public void formValidation() {
		SoftAssert softAssert=new SoftAssert();
		driver.get("https://demo.openmrs.org/openmrs/referenceapplication/home.page");
		HomePageObject homepage=new HomePageObject(driver);
		homepage.clickOnRegisterPatientBtn();
		PatientRegistrationPageObject patientPage=new PatientRegistrationPageObject(driver);
		
		//empty name field
		patientPage.sendTextToName("");
		patientPage.sendTextToFamilyName("");
		patientPage.clickOnNext();
		WebElement nameRequiredError=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Required']")));
		softAssert.assertTrue(nameRequiredError.isDisplayed());
	
		patientPage.clearName();
		
		//Providing numeric data
		patientPage.sendTextToName("234234");
		patientPage.sendTextToFamilyName("224324");
		patientPage.clickOnNext();
		//should not proceed to gender,selection so gender element should not be visible
		WebElement gender=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='gender']")));
		softAssert.assertFalse(gender.isDisplayed());
		
		
		patientPage.clearFamilyName();
		
		patientPage.sendTextToName("Sujith");
		patientPage.sendTextToFamilyName("Kumar");
		patientPage.clickOnNext();
		patientPage.selectGender("Male");
		patientPage.clickOnNext();
		
		
		//providing non numeric data to estimate year and month
		patientPage.sendTxtToMonths("mon");
		patientPage.sendTxtToEstimateYears("year");
		patientPage.clickOnNext();
		WebElement numberError=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Must be a number']")));
		softAssert.assertTrue(numberError.isDisplayed());
		patientPage.clearDOB();
		patientPage.sendTxtToEstimateYears("55");
		patientPage.sendTxtToMonths("3");
		patientPage.clickOnNext();
		
		patientPage.sendTextToAddress1("19 GeorgeTown");
		patientPage.clickOnNext();
		
		//providing non numeric data to phone number
		patientPage.sendTextToPhoneNumber("phone");
		patientPage.clickOnNext();
		WebElement phoneError=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Must be a valid phone number (with +, -, numbers or parentheses)']")));
		softAssert.assertTrue(phoneError.isDisplayed());
		
		patientPage.clearPhoneNumber();
		patientPage.clickOnNext();
		//providing numeric data to person name
		patientPage.sendTextToPersonName("543");
		patientPage.clickOnNext();
		WebElement nameError=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='field-error']")));
		softAssert.assertTrue(nameError.isDisplayed());
		
		softAssert.assertAll();
		
	}
	@Test
	public void navigateBackAndForth() {
		
		
		SoftAssert softAssert=new SoftAssert();
		driver.get("https://demo.openmrs.org/openmrs/referenceapplication/home.page");
		HomePageObject homepage=new HomePageObject(driver);
		
		//Testing navigation to register patient page
		homepage.clickOnRegisterPatientBtn();
		String url=driver.getCurrentUrl();
		softAssert.assertTrue(url.contains("registerPatient"));
		driver.navigate().back();
		String title=driver.getTitle();
		softAssert.assertTrue(title.contains("Home"));
		
		//navigation to findPaitent page
		homepage.clickOnFindPatientBtn();
		url=driver.getCurrentUrl();
		softAssert.assertTrue(url.contains("findPatient"));
		driver.navigate().back();
		title=driver.getTitle();
		softAssert.assertTrue(title.contains("Home"));
				
	}
}