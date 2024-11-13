package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="gender-male")
	WebElement selectMale;
	
	@FindBy(id="gender-female")
	WebElement selectFemale;
	
	@FindBy(id="FirstName")
	WebElement textFirstName;
	
	@FindBy(id="LastName")
	WebElement textLastName;
	
	@FindBy(id="Email")
	WebElement textEmail;
	
	@FindBy(id="Password")
	WebElement textPassword;
	
	@FindBy(id="ConfirmPassword")
	WebElement textConfirmPassword;
	
	@FindBy(id="register-button")
	WebElement btnRegister;
	
	@FindBy(xpath="//div[@class='validation-summary-errors']//ul//li")
	WebElement textEmailExist;
	
	
	
	
	public void selectGenderMale() {
		selectMale.click();
	}
	public void selectGenderFemale() {
		selectFemale.click();
	}
	public void enterFirstName(String firstName) {
		textFirstName.sendKeys(firstName);
	}
	public void enterLastName(String lastName) {
		textLastName.sendKeys(lastName);
	}
	public void enterEmail(String email) {
		textEmail.sendKeys(email);
	}
	public void enterPassword(String password) {
		textPassword.sendKeys(password);
	}
	public void confirmPassword(String password) {
		textConfirmPassword.sendKeys(password);
	}
	public void clickBtnRegister() {
		btnRegister.click();
	}
	public String emailAlreadyExist() {
		return textEmailExist.getText();
		// The specified email already exists
	}
}
