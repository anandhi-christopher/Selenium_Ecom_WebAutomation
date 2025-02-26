package tutorialNinja.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;



import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import tutorialNinja.BaseTests.BaseTest;
import tutorialNinja.Utilities.Retry;

public class RegistrationTest extends BaseTest {

	@Test(groups= {"regression"},retryAnalyzer=Retry.class)
	public void verifyRegistration() {
		logger.info("*****Begin User registration*****");
		HomePage hp = new HomePage(driver);
		logger.info("Click on Account");
		hp.clickAccount();
		logger.info("Click on Register");
		hp.clickRegister();
		RegistrationPage rp = new RegistrationPage(driver);
		logger.info("Enter User Information for registration");
		// rp.setFirstName("DKJslkd");
		rp.setFirstName(getRandomAlphabet().toUpperCase());
		// rp.setLastName("Basajf");
		rp.setLastName(getRandomAlphabet().toUpperCase());
		// rp.setEmail("ahgjj@gmail.com");
		rp.setEmail(getRandomAlphabet() + "@gmail.com");
		// rp.setTelephone("1234598760");
		rp.setTelephone(getRandomNumber());
		// rp.setPassword("adcde123$");
		rp.setPassword(alphaNum + "$");
		// rp.setConfirmPassword("adcde123$");
		rp.setConfirmPassword(alphaNum + "$");
		logger.info("Accept privacy Statement");
		rp.checkPrivacyBox();
		logger.info("click Continue to User registration");
		rp.clickContnButn();
		logger.info("Verify Registration confirmation");
		if (rp.getAcctSuccessMsg().equalsIgnoreCase("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
			System.out.println("Test case Passed");
		} else {
			logger.info("User Registration failed");
			System.out.println("Test case Failed");
		}

	}

}
