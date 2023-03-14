import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import helper.CustomListener;
import helper.DriverManager;
import pageobjects.AdminPage;
import pageobjects.LoginPage;
import pageobjects.MenuPage;
import pageobjects.WelcomePage;

public class ExercisesNine {

	public static void main(String[] args) {
		
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(DriverManager.getDriver());
		eDriver.register(new CustomListener());
		
		eDriver.get("https://satrngselcypr.z16.web.core.windows.net/");
		
		MenuPage menu = new MenuPage();
		LoginPage login = new LoginPage();
		WelcomePage welcome = new WelcomePage();
		AdminPage admin = new AdminPage();
		
		PageFactory.initElements(eDriver, menu);
		PageFactory.initElements(eDriver, login);
		PageFactory.initElements(eDriver, welcome);
		PageFactory.initElements(eDriver, admin);
		
		//Login in with Admin
		menu.logout();
		login.setLanguageTo("French");
		login.loginWith("admin", "superduper");
		
		menu.clickButtonNotExists();
		
	
		

	}

}
