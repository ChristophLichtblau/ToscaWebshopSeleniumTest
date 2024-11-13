package test;
import static org.junit.Assert.*;

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
import page.RegisterCompletedPage;
import page.RegisterPage;






@RunWith(Parameterized.class)
public class TestRegistration {

	WebDriver driver;

	String testname;
	String browsername;
	String gender;
	String firstname;
	String lastname;
	String email;
	String password;
	
	public TestRegistration(String testname, String browsername, String gender, String firstname, String lastname, String email, String password) {
		this.testname = testname;
		this.browsername = browsername;
		this.gender = gender;
		this.firstname = firstname;
		this.lastname = lastname;
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
		
		

		// Act
		homePage.clickLinkRegister();
		
		RegisterPage registerPage = new RegisterPage(driver);
		if (gender.equals("male")) {
			registerPage.selectGenderMale();
		} else if (gender.endsWith("female")) {
			registerPage.selectGenderFemale();
		}

		registerPage.enterFirstName(firstname);
		registerPage.enterLastName(lastname);
		registerPage.enterEmail(email);
		registerPage.enterPassword(password);
		registerPage.confirmPassword(password);
		registerPage.clickBtnRegister();

		// Assert
		assertEquals(registerPage.emailAlreadyExist(),"The specified email already exists");
	}
	
	

	@Parameters(name = "{0}")
	public static Collection<Object[]> provideTestData() throws Exception{
		Collection<Object[]> collection;
		
		Object[][] daten = {
				{ "Test Register Firefox 1", "firefox", "male", "J", "D", "JonnyDoesTestMailAdresse@test1.com",
				"Test123" },
			{ "Test Register Firefox 2", "firefox", "female", "J", "D", "JonnyDoesTestMailAdresse@test2.de",
				"test123!" },
			{ "Test Register Edge 1", "chrome", "female", "J", "D", "JonnyDoesTestMailAdresse@test3.net",
				"test!_" },
			{ "Test Register Edge 2", "chrome", "male", "J", "D", "JonnyDoesTestMailAdresse@test3.net",
				"test!_" },
			{ "Test Register Chrome 1", "edge", "male", "J", "D", "JonnyDoesTestMailAdresse@test5.com",
				"123456" },
			{ "Test Register Chrome 2", "edge", "female", "J", "D", "JonnyDoesTestMailAdresse@test6.de",
				"!“§$%&" }
		};
		
		List<Object[]> listObjects = Arrays.asList(daten);
		collection = new ArrayList<Object[]> (listObjects);
		
		return collection;
	}
}
