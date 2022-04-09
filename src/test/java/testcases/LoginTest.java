package testcases;

import org.testng.annotations.Test;

import config.TestData;
import junit.framework.Assert;
import pages.BookstoreMainPage;
import pages.LoginPage;
import pages.ProfilePage;
import testbase.TestBase;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class LoginTest {

	private WebDriver dr;
	private LoginPage login;
	private ProfilePage profile;
	private BookstoreMainPage main;

	@Test(description = "102-Login unsuccessful")
	public void loginUnsuccessful_102() {
		main.goToLoginPg();
		login.enterUsername("TestOne");
		login.enterPassword("111222xxx");
		login.clickLoginBtn();
		Assert.assertEquals(login.getInvalidLoginMsg(), "Invalid username or password!");
	}

	@Test(description = "103-Login successful")
	public void loginSuccessful_103() {
		main.goToLoginPg();
		//login.loginToApplication(TestData.username, TestData.password);
		login.enterUsername(TestData.username);
		login.enterPassword(TestData.password);
		login.clickLoginBtn();
		Assert.assertTrue(main.isBookStorePgTitleDisplayed());
		Assert.assertEquals(main.getBookStorePgTitle(), "Book Store");
		Assert.assertTrue(main.isUsersNameDisplayedMainPg());
		Assert.assertEquals(main.getUsersNameMainPg(), TestData.username);
	}

	@Test(description = "104-Log out successful")
	public void logoutSuccessful_104() {
		main.goToLoginPg();
		login.loginToApplication(TestData.username, TestData.password);
		profile.clickLogOutBtn();
		Assert.assertTrue(login.isLoginPgTitleDisplayed());
		Assert.assertEquals(login.getLoginPgTitle(), "Login");
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		dr = TestBase.getInstance();
		login = new LoginPage(dr);
		profile = new ProfilePage(dr);
		main = new BookstoreMainPage(dr);
	}

	@AfterMethod
	public void afterMethod() {
		dr.quit();
	}

}
