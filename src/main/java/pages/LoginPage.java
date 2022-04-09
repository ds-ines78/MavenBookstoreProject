package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver dr;

	// constructor
	public LoginPage(WebDriver driver) {
		this.dr = driver; // initialize driver
		PageFactory.initElements(dr, this); // initialize whole page
	}

	// locators
	@FindBy(xpath = "//div[contains(text(),'Login')]")
	private WebElement loginPgTitle;

	@FindBy(xpath = "//h2[contains(text(),'Welcome')]")
	private WebElement welcome;

	@FindBy(id = "userName-label")
	private WebElement userNameLabel;

	@FindBy(id = "password-label")
	private WebElement passwordLabel;

	@FindBy(xpath = "//input[@id='userName']")
	private WebElement usernameField;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@id='login']")
	private WebElement loginBtn;

	@FindBy(xpath = "//button[@id='newUser']")
	private WebElement newUserBtn;

	@FindBy(xpath = "//p[@id=\"name\"][starts-with(text(),'Invalid')]")
	private WebElement invalidLoginMsg;

	// methods
	public void enterUsername(String str) {
		usernameField.sendKeys(str);
	}

	public void enterPassword(String str) {
		passwordField.sendKeys(str);
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}

	public void clickNewUserBtn() {
		newUserBtn.click();
	}

	public void loginToApplication(String user, String pass) {
		usernameField.sendKeys(user);
		passwordField.sendKeys(pass);
		loginBtn.click();
	}
	
	// check for invalid login message
	public String getInvalidLoginMsg() {
		return invalidLoginMsg.getText().trim();
	}

	public boolean isInvalidLoginMsgDisplayed() {
		boolean b = false;

		try {
			b = invalidLoginMsg.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return b;
	}
	
	public String getLoginPgTitle() {
		return loginPgTitle.getText().trim();
	}
	
	public boolean isLoginPgTitleDisplayed() {
		boolean b = false;
		try {
			b = loginPgTitle.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

}
