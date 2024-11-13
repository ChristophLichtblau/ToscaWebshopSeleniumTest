package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterCompletedPage {

	WebDriver driver;
	
	public RegisterCompletedPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='result']")
	WebElement assertTextRegisterComplete;
	
	@FindBy(xpath="//div[contains(@class, 'buttons')]//input[@value='Continue']")
	WebElement btnContinue;
	
	
	
	public String compareTextRegistrationCompleted() {
		return assertTextRegisterComplete.getText();
	}
	public void clickBtnContinue() {
		btnContinue.click();
	}
	
	
}

