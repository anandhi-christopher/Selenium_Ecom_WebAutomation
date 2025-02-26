package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePageObjectComponent.BaseComponent;

public class HomePage extends BaseComponent {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//a[text()='Register'])")
	WebElement register;

	public void clickRegister() {
		register.click();

	}

	
}
