import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.PageFactory;

import helper.DriverManager;
import pageobjects.LoginPage;
import pageobjects.MenuPage;
import pageobjects.WelcomePage;

public class BaseTest {
	
	protected static MenuPage menu;
	protected static LoginPage login;
	protected static WelcomePage welcome;
	
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

}
