
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.PageFactory;

import helper.DriverManager;
import pageobjects.LoginPage;
import pageobjects.MenuPage;
import pageobjects.WelcomePage;

public class ExercicesEleven {
	
	private static MenuPage menu;
	private static LoginPage login;
	private static WelcomePage welcome;
	
	@BeforeAll
	public static void InitializePageObjects() {
		menu = new MenuPage();
		login = new LoginPage();
		welcome = new WelcomePage();
		PageFactory.initElements(DriverManager.getDriver(), menu);
		PageFactory.initElements(DriverManager.getDriver(), login);
		PageFactory.initElements(DriverManager.getDriver(), welcome);
		
		DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net/");
	}
	
	@BeforeEach
	public void logoutBeforeTheTest() {
		menu.logout();
	}
	
	@AfterEach
	public void logoutAfterTheTest() {
		menu.logout();
	}
	
	@AfterAll
	public static void ClosingTheBrowser() {
		DriverManager.getDriver().quit();
	}
	
	
	@Test
	public void LoggingInWithCorrectUsernameCorrectPassword() {
		login.loginWith("admin", "supervvduper");
		Assert.assertTrue("The welcome message is not displayed",welcome.isWelcomeMessageDisplayed());
	}
	
	@Ignore@Test
	public void LoggingInWithCorrectUsernameIncorrectPassword() {
		login.loginWith("admin", "wrong");
		Assert.assertFalse("The welcome message is displayed", welcome.isWelcomeMessageDisplayed());
		
	}
	
	@Ignore@Test
	public void LoggingInWithInCorrectUsername() {
		login.loginWith("wrong", "superduper");
		Assert.assertFalse("The welcome message is displayed", welcome.isWelcomeMessageDisplayed());
	}
	
	@Ignore@Test
	public void LoggingInWithEmptyUsernameAndPassword() {
		login.loginWith("", "");
		Assert.assertFalse("The welcome message is displayed", welcome.isWelcomeMessageDisplayed());
	}
	
	
	


}
