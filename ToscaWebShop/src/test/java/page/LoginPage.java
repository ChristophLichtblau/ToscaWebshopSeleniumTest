package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(id="Email")
	WebElement inputEmail;
	
	@FindBy(id="Password")
	WebElement inputPassword;
	
	@FindBy(xpath="//div[@class='buttons']//input[@type='submit']")
	WebElement btnLogin;
	
	
	
	public void enterEmail(String email) {
		inputEmail.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		inputPassword.sendKeys(password);
	}
	
	public void clickBtnLogin() {
		btnLogin.click();
	}
}
