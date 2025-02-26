package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePageObjectComponent.BaseComponent;

public class RegistrationPage extends BaseComponent{
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-firstname")
	WebElement fName;
	@FindBy(id = "input-lastname")
	WebElement lName;
	@FindBy(css = "input[name='email']")
	WebElement emailId;
	@FindBy(id = "input-telephone")
	WebElement telePhone;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passWord;
	@FindBy(id = "input-confirm")
	WebElement confirmPassWord;
	@FindBy(css = "input[name='agree']")
	WebElement privacyPolicy;
	@FindBy(css = ".btn-primary")
	WebElement continueButton;
	@FindBy(css = "div[id='content'] h1")
	WebElement accountCreatedText;

	public void setFirstName(String firstNameInput) {
		fName.sendKeys(firstNameInput);
	}

	public void setLastName(String lastNameInput) {
		lName.sendKeys(lastNameInput);
	}

	public void setEmail(String emailInput) {
		emailId.sendKeys(emailInput);
	}

	public void setTelephone(String telephoneInput) {
		telePhone.sendKeys(telephoneInput);
	}

	public void setPassword(String passWordInput) {
		passWord.sendKeys(passWordInput);
	}

	public void setConfirmPassword(String ConfirmPassInput) {
		confirmPassWord.sendKeys(ConfirmPassInput);
	}

	public void checkPrivacyBox() {
		privacyPolicy.click();
	}

	public void clickContnButn() {
		continueButton.click();
	}

	public String getAcctSuccessMsg() {
		try {
			return accountCreatedText.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
