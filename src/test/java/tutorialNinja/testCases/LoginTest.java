package tutorialNinja.testCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.LoginPage;
import tutorialNinja.BaseTests.BaseTest;
import tutorialNinja.Utilities.Retry;

public class LoginTest extends BaseTest  {

	@Test(groups = { "regression"}, retryAnalyzer=Retry.class)
	public void verifyLogin() {
		logger.info("***Begin User Account Login verify Account and Logout***");
		LoginPage lp = new LoginPage(driver);
		logger.info("Clicked on Myaccount");
		lp.clickAccount();
		logger.info("Clicked on MyLogin");
		lp.clickloginPage();
		logger.info("Entered user email");
		lp.setEmail(prop.getProperty("email"));
		logger.info("Entered user password");
		lp.setPassword(prop.getProperty("passwordval"));
		logger.info("Clicked login");
		lp.clickLogin();

		AccountPage ap = new AccountPage(driver);
		logger.info("Verify Account Login");
		if (ap.getMyaccountText() == true) {
			System.out.println("Account Login success");
			
		}

		else {

			System.out.println("Account login Failed");
		}
		
		logger.info("Clicked Logout");
		ap.clickLogout();
		logger.info("***Account logout successful***");
		
	}
}
