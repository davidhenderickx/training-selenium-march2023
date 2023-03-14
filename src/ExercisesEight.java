import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.DriverManager;
import pageobjects.AdminPage;
import pageobjects.LoginPage;
import pageobjects.MenuPage;
import pageobjects.WelcomePage;

public class ExercisesEight {

	public static void main(String[] args) {
		
		DriverManager.setFirefoxDriver();
		DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net/");
			
		MenuPage menu = new MenuPage();
		LoginPage login = new LoginPage();
		WelcomePage welcome = new WelcomePage();
		AdminPage admin = new AdminPage();
		
		PageFactory.initElements(DriverManager.getDriver(), menu);
		PageFactory.initElements(DriverManager.getDriver(), login);
		PageFactory.initElements(DriverManager.getDriver(), welcome);
		PageFactory.initElements(DriverManager.getDriver(), admin);
		
		//Login in with Admin
		menu.logout();
		login.setLanguageTo("French");
		login.loginWith("admin", "superduper");
		
		//Opening the admin view
		String currentWindow = DriverManager.getDriver().getWindowHandle();
		menu.admin();
		Set<String> allWindows = DriverManager.getDriver().getWindowHandles();
		String newWindow = null;
		for(String window : allWindows) {
			if (!currentWindow.equals(window)) {
				newWindow = window;
				break;
			}
		}
	
		
		DriverManager.getDriver().switchTo().window(newWindow);
		
		
		
		//Resetting the users
		admin.clickResetUsers();
		if(admin.getResetUsersAlertText().equals("Users reset.")) {
			System.out.println("PASSED: Text in alert is correct");
		} else {
			System.out.println("FAILED: Text in alert is not correct");
		}
		admin.closeResetUsersAlert();
		
		//Creating a new user
		admin.createNewUser("David", "test");
		
		//Closing the admin view
		DriverManager.getDriver().close();
		
		//Switching back to the original view
		DriverManager.getDriver().switchTo().window(currentWindow);
		
		//Logging the admin out
		menu.logout();
		
		//Logging in with the new credentials
		login.loginWith("David", "test");
		
		//Validating the welcomeMessage
		if (welcome.getWelcomeMessage().contains("Welcome")) {
			System.out.println("PASSED: Welcome message does contain welcome");
		} else {
			System.out.println("FAILED: Welcome message doesn't contain welcome");
		}
		
		
		
		

	}

}
