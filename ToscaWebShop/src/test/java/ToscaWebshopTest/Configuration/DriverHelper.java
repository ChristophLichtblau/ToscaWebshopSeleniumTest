package ToscaWebshopTest.Configuration;

import org.openqa.selenium.WebDriver;

public class DriverHelper {
	
	public static void throwExceptionWhenNull(String browser) {
		
		if(browser == null) {
			throw new RuntimeException("Es wurde kein WebDriver angegeben!");
		}
		
	}

	public static WebDriver getDriver(String browser) {
		throwExceptionWhenNull(browser);
		AvailableBrowser currentBrowser = AvailableBrowser.valueOf(browser.toUpperCase());
		WebDriver driver = currentBrowser.createDriver();
		return driver;
	}
	
	
	
}
