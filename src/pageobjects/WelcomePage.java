package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WelcomePage {
	
	@FindBy(how = How.XPATH, using = "//div[@id='welcome']/h1")
	private WebElement txtWelcome;
	
	
	public String getWelcomeMessage() {
		System.out.println("Getting the welcome message");
		return txtWelcome.getText();
	}
	

}
