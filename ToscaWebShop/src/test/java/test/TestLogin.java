package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import page.HomePage;
import page.LoginPage;
import page.StartseiteEingeloggt;



@RunWith(Parameterized.class)
public class TestLogin {

	WebDriver driver;

	String testname;
	String browsername;
	String email;
	String password;

	
	public TestLogin(String testname, String browsername, String email, String password) {
		this.testname = testname;
		this.browsername = browsername;
		this.email = email;
		this.password = password;
		
	}
	
	
	@Before
	public void setUp() throws Exception{
		System.out.println("Initialisiere Webdriver!");
		driver = ToscaWebshopTest.Configuration.DriverHelper.getDriver(browsername);
		driver.manage().window().maximize();
		driver.get(ToscaWebshopTest.Configuration.Config.getBaseURL());
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Schließe Driver!");
		driver.close();
	}
	

	@Test
	public void testLogin() {

		System.out.println("Test " + testname + " startet!");

		// Arrange
		HomePage homePage = new HomePage(driver);
		homePage.clickLinkLogin();

		// Act
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickBtnLogin();

		StartseiteEingeloggt startseiteEingeloggt = new StartseiteEingeloggt(driver);
		startseiteEingeloggt.clickLinkBooks();
		// Assert
		
	}
	
	

	@Parameters(name = "{0}")
	public static Collection<Object[]> provideTestData() throws Exception{
		Collection<Object[]> collection;
		
		// Es können mehrere Testdaten erstellt werden.. -> einfach ,{Testdaden} unter die aktuellen Testdaten einfügen
		Object[][] daten = {
				{ "Test Login Firefox 1", "firefox", "JonnyDoesTestMailAdresse@test1.com",
					"Test123" }
			
		};
		
		List<Object[]> listObjects = Arrays.asList(daten);
		collection = new ArrayList<Object[]> (listObjects);
		
		return collection;
	}
}
