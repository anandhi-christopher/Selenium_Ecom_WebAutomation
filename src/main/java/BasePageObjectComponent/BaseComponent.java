package BasePageObjectComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseComponent {
	public WebDriver driver;

	public BaseComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement account;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement loginbtn;
	
	public void clickloginPage() {
		loginbtn.click();
	}

	public void clickAccount() {
		account.click();
	}
	}
