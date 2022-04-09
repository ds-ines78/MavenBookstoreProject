package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	private WebDriver dr;

	// constructor
	public RegistrationPage(WebDriver driver) {
		this.dr = driver; // initialize driver
		PageFactory.initElements(dr, this); // initialize whole page
	}

	// locators
	@FindBy(xpath = "//div[contains(text(),'Register')]")
	private WebElement registerPgTitle;

	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement firstNameField;

	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement lastNameField;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameField;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;

	//@FindBy(xpath = "//textarea[@id='g-recaptcha-response']")
	@FindBy(xpath = "//*[@id='recaptcha-anchor']/div[@class='recaptcha-checkbox-border']")
	private WebElement captcha;

	@FindBy(css = "id#register")
	private WebElement registerBtn;

	@FindBy(css = "id#gotologin")
	private WebElement backToLoginBtn;

	// methods
	public void createFirstName(String str) {
		firstNameField.sendKeys(str);
	}

	public void createLastName(String str) {
		lastNameField.sendKeys(str);
	}
	
	public void createUserName(String str) {
		userNameField.sendKeys(str);
	}

	public void createPassword(String str) {
		passwordField.sendKeys(str);
	}

	public void clickRegisterBtn() {
		registerBtn.click();
	}
	
	public void clickCaptcha() {
		captcha.click();
	}

	public void clickBackToLoginBtn() {
		backToLoginBtn.click();
	}

	public void createNewUser(String first, String last, String username, String password) {

	}

}
