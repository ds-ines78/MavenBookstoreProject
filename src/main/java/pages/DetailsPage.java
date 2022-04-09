package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DetailsPage {

	private WebDriver dr;

	// constructor
	public DetailsPage(WebDriver driver) {
		this.dr = driver; // initialize driver
		PageFactory.initElements(dr, this); // initialize whole page
	}

}
