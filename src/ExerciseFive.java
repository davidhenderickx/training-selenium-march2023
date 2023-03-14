import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import helper.DriverManager;
import pageobjects.LoginPage;
import pageobjects.MenuPage;
import pageobjects.WelcomePage;

public class ExerciseFive {

	public static void main(String[] args) {
		
		DriverManager.setFirefoxDriver();
		DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net/");
		
		
		MenuPage menu = new MenuPage();
		LoginPage login = new LoginPage();
		WelcomePage welcome = new WelcomePage();
		
		PageFactory.initElements(DriverManager.getDriver(), menu);
		PageFactory.initElements(DriverManager.getDriver(), login);
		PageFactory.initElements(DriverManager.getDriver(), welcome);
		
		menu.logout();
		login.setLanguageTo("French");
		login.loginWith("admin", "superduper");
		
		if (welcome.getWelcomeMessage().contains("Welcome")) {
			System.out.println("PASSED: Welcome message does contain welcome");
		} else {
			System.out.println("FAILED: Welcome message doesn't contain welcome");
		}
		
		DriverManager.killDriver();
		
		
		

	}

}
