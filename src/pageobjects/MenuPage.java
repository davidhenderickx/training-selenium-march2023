package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MenuPage {
	
	@FindBy(how = How.ID, using = "logout")
	private WebElement btnLogout;
	
	public void logout() {
		System.out.println("Clicking on the logout button");
		btnLogout.click();
	}

}
