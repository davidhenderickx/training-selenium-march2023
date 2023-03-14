import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import pageobjects.LoginPage;
import pageobjects.MenuPage;
import pageobjects.WelcomePage;

public class ExerciseFive {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dhenderickx\\Downloads\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dhenderickx\\Downloads\\geckodriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://satrngselcypr.z16.web.core.windows.net/");
		
		
		MenuPage menu = new MenuPage();
		LoginPage login = new LoginPage();
		WelcomePage welcome = new WelcomePage();
		
		PageFactory.initElements(driver, menu);
		PageFactory.initElements(driver, login);
		PageFactory.initElements(driver, welcome);
		
		menu.logout();
		login.setLanguageTo("French");
		login.loginWith("admin", "superduper");
		
		if (welcome.getWelcomeMessage().contains("Welcome")) {
			System.out.println("PASSED: Welcome message does contain welcome");
		} else {
			System.out.println("FAILED: Welcome message doesn't contain welcome");
		}
		
		driver.quit();
		
		
		

	}

}
