package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObjectModel {

	public WebDriver driver;
	public WebDriverWait wait;

	public BasePageObjectModel(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);// used to initiate webElement by @FindBy
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
}
