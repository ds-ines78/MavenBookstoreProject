package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookDetailsPage {

	private WebDriver dr;

	// constructor
	public BookDetailsPage(WebDriver driver) {
		this.dr = driver; // initialize driver
		PageFactory.initElements(dr, this); // initialize whole page
	}

	// locators
	@FindBy(id = "ISBN-label")
	private WebElement isbnLabel;

	@FindBy(id = "title-label")
	private WebElement titleLabel;

	@FindBy(id = "subtitle-label")
	private WebElement subTitleLabel;

	@FindBy(id = "author-label")
	private WebElement authorLabel;

	@FindBy(id = "publisher-label")
	private WebElement publisherLabel;

	@FindBy(id = "pages-label")
	private WebElement totalPagesLabel;

	@FindBy(id = "description-label")
	private WebElement descriptionLabel;

	@FindBy(id = "website-label")
	private WebElement websiteLabel;

	@FindBy(xpath = "//button[@id='login'][contains(text(),'Login')]")
	private WebElement detailsLoginBtn;

	@FindBy(xpath = "//button[@id='addNewRecordButton'][contains(text(),'Back To Book Store')]")
	private WebElement backToBookStoreBtn;

	@FindBy(xpath = "//div[@class='text-right fullButton']//button[@id='addNewRecordButton'][contains(text(),'Add To Your Collection')]")
	private WebElement addToCollectionBtn;
	
	@FindBy(xpath = "//span[@class='text'][contains(text(),'Profile')]")
	private WebElement profileSideMenu;
	

	// methods
	public void clickDetailsLoginBtn() {
		detailsLoginBtn.click();
	}

	public void clickBackToBookStoreBtn() {
		backToBookStoreBtn.click();
	}
	
	public void clickProfile() {
		profileSideMenu.click();
	}

	public boolean isISBNDisplayed() {
		boolean b = false;
		try {
			b = isbnLabel.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean isTitleDisplayed() {
		boolean b = false;
		try {
			b = titleLabel.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean isSubTitleDisplayed() {
		boolean b = false;
		try {
			b = subTitleLabel.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean isAuthorDisplayed() {
		boolean b = false;
		try {
			b = authorLabel.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean isPublisherDisplayed() {
		boolean b = false;
		try {
			b = publisherLabel.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean isTotPagesDisplayed() {
		boolean b = false;
		try {
			b = totalPagesLabel.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean isDescriptionDisplayed() {
		boolean b = false;
		try {
			b = descriptionLabel.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean isWebsiteDisplayed() {
		boolean b = false;
		try {
			b = websiteLabel.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public void clickAddToCollBtn() {
		addToCollectionBtn.submit();
	}

}
