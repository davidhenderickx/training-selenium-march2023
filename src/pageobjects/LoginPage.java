package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	@FindBy(how = How.ID, using = "username")
	private WebElement fldUsername;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement fldPassword;
	
	@FindBy(how = How.NAME, using = "language")
	private WebElement cbxLanguage;
	
	@FindBy(how = How.TAG_NAME, using = "label")
	private WebElement btnLogin;
	
	
	public void loginWith(String username, String password) {
		System.out.println("Logging into the application with " + username + "/" + password);
		fldUsername.clear();
		fldUsername.sendKeys(username);
		fldPassword.clear();
		fldPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public void setLanguageTo(String language) {
		System.out.println("Setting the language to " + language);
		Select dropdown = new Select(cbxLanguage);
		dropdown.selectByVisibleText(language);
	}
	

}
