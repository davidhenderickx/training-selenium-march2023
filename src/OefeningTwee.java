import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OefeningTwee {
	
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dhenderickx\\Downloads\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dhenderickx\\Downloads\\geckodriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		System.out.println("Navigating to Google");
		driver.get("https://www.google.be");
		String titleGoogle = driver.getTitle();
		System.out.println("The title = " + titleGoogle);
		
		System.out.println("Navigating to Bing");
		driver.get("https://www.bing.com");
		String titleBing = driver.getTitle();
		System.out.println("The title = " + titleBing);
		
		System.out.println("Going back");
		driver.navigate().back();
		if(driver.getTitle().equals(titleGoogle)) {
			System.out.println("PASSED: I'm back at google");
		} else {
			System.out.println("FAILED: I'm not at google");
		}
		
		driver.quit();
		
		
		
		

	}

}
