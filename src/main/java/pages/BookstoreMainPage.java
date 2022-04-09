package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookstoreMainPage {

	private WebDriver dr;

	// constructor
	public BookstoreMainPage(WebDriver driver) {
		this.dr = driver; // initialize driver
		PageFactory.initElements(dr, this); // initialize whole page
	}

	// locators
	@FindBy(xpath = "//div[contains(text(),'Book Store')][@class='main-header']")
	private WebElement bookStorePgTitle;

	@FindBy(xpath = "//input[@id='searchBox']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//button[@id='login'][contains(text(),'Login')]")
	private WebElement bookStoreLoginBtn;
	
	@FindBy(xpath = "//label[@id='userName-label'][contains(text(),'User Name')]")
	private WebElement mainUserNameLabel;
	
	@FindBy(xpath = "//label[@id='userName-value']")
	private WebElement mainUsersName;

	@FindBy(xpath = "//div[@class='rt-tr'][@role='row']")
	private List<WebElement> tableHeader;

	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previousBtn;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement nextBtn;

	@FindBy(linkText = "Git Pocket Guide") // title should match search criteria entered
	private WebElement searchResultTitle;
	
	

	// methods
	public String getBookStorePgTitle() {
		return bookStorePgTitle.getText().trim();
	}

	public boolean isBookStorePgTitleDisplayed() {
		boolean b = false;
		try {
			b = bookStorePgTitle.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public String getUsersNameMainPg() {
		return mainUsersName.getText().trim();
	}

	public boolean isUsersNameDisplayedMainPg() {
		boolean b = false;
		try {
			b = mainUsersName.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public void goToLoginPg() {
		bookStoreLoginBtn.click();
	}

	public int getTableHeaderCount() {
		return tableHeader.size();
	}

	public List<String> getTableHeaderItemsText() {
		List<String> temp = new ArrayList<String>();
		for (WebElement s : tableHeader) {
			temp.add(s.getText());
		}
		return temp;
	}

	public boolean isPreviousBtnDisplayed() {
		boolean b = false;
		try {
			b = previousBtn.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean isNextBtnDisplayed() {
		boolean b = false;
		try {
			b = nextBtn.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public void enterSearchCrit(String str) {
		searchBox.clear();
		searchBox.sendKeys(str);
	}

	public void performSearch() {
		searchBox.sendKeys(Keys.RETURN);
	}

	public boolean isSearchResultDisplayed() {
		boolean b = false;
		try {
			b = searchResultTitle.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public String getSearchResultTitle()
	{
		return searchResultTitle.getText().trim();
	}
	
	public void clickSearchResult() {
		searchResultTitle.click();
	}

}
