package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.CandidatesPage;
import page.HomePage;
import page.SignInPage;

public class LoginTest extends BaseTest{

	@Test
	public void testValidLogin() throws InterruptedException, IOException
	{	
		SignInPage signInPage = new SignInPage(driver, wait);		
		signInPage.login(ENV);
		
		HomePage homePage = new HomePage(driver, wait);
		boolean validateLogin = homePage.verifyLogin();
		Assert.assertEquals(validateLogin, true);
	}
}
  