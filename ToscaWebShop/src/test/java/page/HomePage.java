package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className ="ico-register")
	WebElement linkRegister;
	
	@FindBy(className="ico-login")
	WebElement linkLogin;
	
	
	
	
	public void clickLinkRegister() {
		linkRegister.click();
	}
	
	public void clickLinkLogin() {
		linkLogin.click();
	}
	
	
}
