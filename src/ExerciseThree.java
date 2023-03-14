import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class ExerciseThree {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dhenderickx\\Downloads\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dhenderickx\\Downloads\\geckodriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://satrngselcypr.z16.web.core.windows.net/");
		
		driver.findElement(By.id("logout")).click();
		
		WebElement e = driver.findElement(By.name("language"));
		Select cbxLanguages = new Select(e);
		cbxLanguages.selectByVisibleText("French");
		
		driver.findElement(By.id("username")).sendKeys("admin");
		
		WebElement fldPassword = driver.findElement(By.id("password"));
		fldPassword.clear();
		fldPassword.sendKeys("superduper");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		
		
		driver.findElement(By.tagName("label")).click();
		
		driver.quit();
		
		

	}

}
