package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePageObjectComponent.BaseComponent;

public class AccountPage extends BaseComponent {
	public WebDriver driver;

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement myAccount;
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Logout']")
	WebElement logOut;

	public Boolean getMyaccountText() {
		try {
			return myAccount.isDisplayed();
		} catch (Exception e) {
			return false;

		}
	}
	public void clickLogout() {
		logOut.click();
	}

}
