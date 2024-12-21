package testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import pageObjectModel.FindPatientPageObject;
import pageObjectModel.HomePageObject;

public class TC03_Pagination extends BaseTestCase{

	@Test
	public void validatePagination() {
		HomePageObject homepage=new HomePageObject(driver);
		homepage.clickOnFindPatientBtn();
		FindPatientPageObject findPaitent=new FindPatientPageObject(driver);
		findPaitent.sendTextToPatientSearch("100"); //returns more than 30 records
		
		WebElement records =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Showing 1 to 15 of 50 entries']")));
		assertTrue(records.isDisplayed());
		
	}

}
