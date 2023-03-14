import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExercisesOne {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dhenderickx\\Downloads\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dhenderickx\\Downloads\\chromedriver.exe");
		
		//WebDriver driver = new FirefoxDriver();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.google.be");
		
		System.out.println("Adding text to the console");
		
		String text = "Hello";
		System.out.println(text + "world");
		
		System.out.println(driver.getTitle());
		
		String titleOfThePage = driver.getTitle();
		System.out.println(titleOfThePage);
		System.out.println("The title of the page is: " + titleOfThePage);
		System.out.println("The title of the page is: " + driver.getTitle());
		
		
		
		
		
		

	}

}
