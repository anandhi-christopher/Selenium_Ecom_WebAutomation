package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePageObjectComponent.BaseComponent;

public class LoginPage extends BaseComponent {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	

	@FindBy(name = "email")
	WebElement emailid;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement login;

	
	public void setEmail(String email) {
		emailid.sendKeys(email);
	}

	public void setPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickLogin() {
		login.click();
		
	}

}
