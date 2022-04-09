package testcases;

import org.testng.annotations.Test;

import config.TestData;
import pages.BookDetailsPage;
import pages.BookstoreMainPage;
import pages.LoginPage;
import pages.ProfilePage;
import testbase.TestBase;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ManageBookTest {

	private WebDriver dr;
	private LoginPage login;
	private ProfilePage profile;
	private BookstoreMainPage main;
	private BookDetailsPage det;

	@Test(description = "107-View book information")
	public void viewBookInfo_107() {
		main.clickSearchResult();
		Assert.assertTrue(det.isISBNDisplayed(), "ISBN missing");
		Assert.assertTrue(det.isTitleDisplayed(), "Title missing");
		Assert.assertTrue(det.isSubTitleDisplayed(), "Subtitle missing");
		Assert.assertTrue(det.isAuthorDisplayed(), "Author missing");
		Assert.assertTrue(det.isPublisherDisplayed(), "Publisher missing");
		Assert.assertTrue(det.isTotPagesDisplayed(), "Total Pages missing");
		Assert.assertTrue(det.isDescriptionDisplayed(), "Description missing");
		Assert.assertTrue(det.isWebsiteDisplayed(), "Website missing");
	}

	/* @Test(description = "108-Add book to user's collection")
	public void addBookToCollection_108() {
		main.goToLoginPg();
		login.enterUsername(TestData.username);
		login.enterPassword(TestData.password);
		login.clickLoginBtn();
		main.clickSearchResult();
		det.clickAddToCollBtn();
		dr.switchTo().alert().accept();
		det.clickProfile();
		Assert.assertTrue(profile.isProfilePgTitleDisplayed());
		Assert.assertTrue(profile.isBookDisplayedInTable());
		profile.clickDeleteAllBooksBtn();
		dr.switchTo().alert().accept();
		dr.switchTo().alert().accept();
	} */

	@BeforeMethod
	public void beforeMethod() throws IOException {
		dr = TestBase.getInstance();
		login = new LoginPage(dr);
		profile = new ProfilePage(dr);
		main = new BookstoreMainPage(dr);
		det = new BookDetailsPage(dr);
	}

	@AfterMethod
	public void afterMethod() {
		dr.quit();
	}
}
