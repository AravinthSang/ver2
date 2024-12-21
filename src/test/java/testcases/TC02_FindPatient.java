package testcases;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import pageObjectModel.FindPatientPageObject;
import pageObjectModel.HomePageObject;

public class TC02_FindPatient extends BaseTestCase {

	@Test
	public void validateFindingPatientByName() {
		driver.get("https://demo.openmrs.org/openmrs/referenceapplication/home.page");
		HomePageObject homepage = new HomePageObject(driver);
		homepage.clickOnFindPatientBtn();
		FindPatientPageObject findPaitent = new FindPatientPageObject(driver);
		findPaitent.sendTextToPatientSearch("Paul Walker");
		// validate response by corresponding Identifier
		WebElement patientId = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='10000X']")));
		assertTrue(patientId.isDisplayed());

	}

	@Test
	public void validateFindingPatientById() {
		driver.get("https://demo.openmrs.org/openmrs/referenceapplication/home.page");
		HomePageObject homepage = new HomePageObject(driver);
		homepage.clickOnFindPatientBtn();
		FindPatientPageObject findPaitent = new FindPatientPageObject(driver);
		findPaitent.sendTextToPatientSearch("10000X");
		// validate response by corresponding name
		WebElement patientName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Paul Walker']")));
		assertTrue(patientName.isDisplayed());

	}

	@Test
	public void validateFindingPatientByNonexistentData() {
		driver.get("https://demo.openmrs.org/openmrs/referenceapplication/home.page");
		HomePageObject homepage = new HomePageObject(driver);
		homepage.clickOnFindPatientBtn();
		FindPatientPageObject findPaitent = new FindPatientPageObject(driver);
		findPaitent.sendTextToPatientSearch("99k");
		// validating by presence of No matching data text
		WebElement txt = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='No matching records found']")));
		assertTrue(txt.isDisplayed());
	}

}
