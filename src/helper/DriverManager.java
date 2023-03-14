package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	
	private static WebDriver driver;
	
	
	public static WebDriver getDriver() {
		if (driver == null) {
			setChromeDriver();
		} 
		return driver;
	}

	public static void setChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dhenderickx\\Downloads\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}
	
	public static void setFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dhenderickx\\Downloads\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	public static void killDriver() {
		if (driver == null) {
			System.out.println("There is no active driver. Nothing to kill");
		} else {
			System.out.println("Killing the driver");
			driver.quit();
			driver = null;
		}
	}
}
