package pageobjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.DriverManager;

public class AdminPage {
	
	@FindBy(how = How.XPATH, using = "//td[@onclick='resetUsers(true)']/label")
	private WebElement btnResetUsers;
	
	@FindBy(how = How.ID, using = "new_username")
	private WebElement fldNewUsername;
	
	@FindBy(how = How.ID, using = "new_password")
	private WebElement fldNewPassword;
	
	@FindBy(how = How.XPATH, using = "//td[@onclick='createUser()']/span")
	private WebElement btnCreateUser;
	
	
	
	public void clickResetUsers() {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(btnResetUsers));
		
		System.out.println("Clickin on the reset users button");
		btnResetUsers.click();

	}
	
	public String getResetUsersAlertText() {
		System.out.println("Returning the alert text");
		Alert popup = DriverManager.getDriver().switchTo().alert();
		return popup.getText();
	}
	
	public void closeResetUsersAlert() {
		System.out.println("Closing the reset users alert");
		Alert popup = DriverManager.getDriver().switchTo().alert();
		popup.accept();
		
	}
	
	public void createNewUser(String username, String password) {
		fldNewUsername.sendKeys(username);
		fldNewPassword.sendKeys(password);
		btnCreateUser.click();
	}
	

}
