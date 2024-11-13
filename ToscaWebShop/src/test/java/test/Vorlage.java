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



@RunWith(Parameterized.class)
public class Vorlage {

	WebDriver driver;

	String testname;
	String browsername;

	
	public Vorlage(String testname, String browsername) {
		this.testname = testname;
		this.browsername = browsername;
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
		

		// Act
	

		// Assert
		
	}
	
	

	@Parameters(name = "{0}")
	public static Collection<Object[]> provideTestData() throws Exception{
		Collection<Object[]> collection;
		
		// Es können mehrere Testdaten erstellt werden.. -> einfach ,{Testdaden} unter die aktuellen Testdaten einfügen
		Object[][] daten = {
				{ "Name des Tests", "firefox/chrome/edge -> 1 Brwoser auswählen und nur den NBamen hier stehen lassen" }
			
		};
		
		List<Object[]> listObjects = Arrays.asList(daten);
		collection = new ArrayList<Object[]> (listObjects);
		
		return collection;
	}
}
