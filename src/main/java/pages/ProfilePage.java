package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

	private WebDriver dr;

	// constructor
	public ProfilePage(WebDriver driver) {
		this.dr = driver; // initialize driver
		PageFactory.initElements(dr, this); // initialize whole page
	}

	// locators
	@FindBy(xpath = "//div[contains(text(),'Profile')]")
	private WebElement profileTitle;

	@FindBy(xpath = "//label[contains(text(),'User Name')]")
	private WebElement userNameLabel;

	@FindBy(xpath = "//label[@id='userName-value']")
	private WebElement usersName;

	@FindBy(xpath = "//button[@id='submit'][contains(text(),'Log out')]")
	private WebElement logOutBtn;

	// @FindBy(xpath =
	// "//li[@id='item-2']//span[@class='text'][contains(text(),'Book Store')]")
	@FindBy(xpath = "//div[@class='mt-2 buttonWrap row']//div[@class='text-left button']//button[@id='gotoStore']")
	private WebElement goToBookStoreBtn;

	@FindBy(css = "a[href*='profile?book']")
	private WebElement bookRowEntry;
	
	@FindBy(xpath = "//div[@class='text-right button di']//button[@id=\"submit\"][contains(text(),'Delete All Books')]")
	private WebElement deleteAllBooksBtn;
	

	// methods
	public String getProfilePgTitle() {
		return profileTitle.getText().trim();
	}

	public boolean isProfilePgTitleDisplayed() {
		boolean b = false;
		try {
			b = profileTitle.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public String getUsersName() {
		return usersName.getText().trim();
	}

	public boolean isUsersNameDisplayed() {
		boolean b = false;
		try {
			b = usersName.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean isBookDisplayedInTable() {
		boolean b = false;
		try {
			b = bookRowEntry.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public void clickLogOutBtn() {
		logOutBtn.click();
	}

	public void clickGoToBookstoreBtn() {
		goToBookStoreBtn.click();
	}
	
	public void clickDeleteAllBooksBtn() {
		deleteAllBooksBtn.click();
	}

}
