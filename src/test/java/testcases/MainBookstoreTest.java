package testcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.BookstoreMainPage;
import pages.LoginPage;
import pages.ProfilePage;
import testbase.TestBase;
import testutility.TestUtility;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class MainBookstoreTest {

	private WebDriver dr;
	private LoginPage login;
	private ProfilePage prof;
	private BookstoreMainPage bk;

	@Test(description = "105-View Book Store page")
	public void viewBookstorePageElements_105() {

		// login.loginToApplication(TestData.username, TestData.password);
		// prof.clickGoToBookstoreBtn();
		dr.get("https://demoqa.com/books");
		TestUtility.attachImagesToReport();

		// check Book Store pg is displayed
		Assert.assertTrue(bk.isBookStorePgTitleDisplayed());
		Assert.assertEquals(bk.getBookStorePgTitle(), "Book Store");

		// check table headers are displayed
		List<String> actual = bk.getTableHeaderItemsText();

		List<String> expect = new ArrayList<String>();
		expect.add("Image");
		expect.add("Title");
		expect.add("Author");
		expect.add("Publisher");
		TestUtility.attachImagesToReport();
		Reporter.log(actual + "--->" + expect);
		Assert.assertEquals(actual, expect);

		// Assert.assertTrue(bk.getTableHeaderCount() == 4);
		int act = bk.getTableHeaderCount();
		int exp = 4;
		TestUtility.attachImagesToReport();
		Reporter.log(act + "--->" + exp);
		Assert.assertEquals(act, exp);

		// check navigation buttons are displayed
		Assert.assertTrue(bk.isPreviousBtnDisplayed());
		Assert.assertTrue(bk.isNextBtnDisplayed());

	}

	@Test(description = "106-Execute search on Book Store page")
	public void searchFeature_106() {
		dr.get("https://demoqa.com/books");
		TestUtility.attachImagesToReport();

		// check Book Store pg is displayed
		Assert.assertTrue(bk.isBookStorePgTitleDisplayed());
		Assert.assertEquals(bk.getBookStorePgTitle(), "Book Store");
		
		// execute search
		String srch = "Git Pocket Guide";
		String rslt = "Git Pocket Guide";
		bk.enterSearchCrit(srch);
		bk.performSearch();
		Assert.assertTrue(bk.isSearchResultDisplayed());
		if( bk.getSearchResultTitle() == rslt) {
			Reporter.log(srch + "--->" + rslt);
		}
		
				
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		dr = TestBase.getInstance();
		login = new LoginPage(dr);
		prof = new ProfilePage(dr);
		bk = new BookstoreMainPage(dr);

	}

	@AfterMethod
	public void afterMethod() {
		dr.quit();
	}

}
