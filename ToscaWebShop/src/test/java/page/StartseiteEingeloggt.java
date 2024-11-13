package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartseiteEingeloggt {

	WebDriver driver;
	
	public StartseiteEingeloggt(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='header-menu']//ul[@class='top-menu']//a[@href='/books']")
	WebElement linkBooks;
	
	
	public void clickLinkBooks() {
		linkBooks.click();
	}
	
}
