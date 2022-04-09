package testbase;

/**
 * @author ines_
 * starts browsers
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	// singleton design pattern -> one browser instance for framework

	// declare variables here
	public static WebDriver driver;
	public static Properties prop;
	public static String browser;

	public static WebDriver getInstance() throws IOException {

		String file = "src/main/java/config/config.properties";
		FileInputStream input = new FileInputStream(file);

		prop = new Properties(); // initialize properties
		prop.load(input);
		browser = prop.getProperty("browser");

		// download drivers then copy .exe file to drivers folder
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe"); // Chrome browser
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe"); // Firefox browser
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe"); // Edge browser
			driver = new EdgeDriver();
		} /*
			 * else if (browser.equalsIgnoreCase("IE")) {
			 * System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			 * driver=new InternetExplorerDriver(); }
			 */
		else {
			Throwable thr = new Throwable();
			thr.initCause(null);
		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		// Implicit wait
		// Duration.ofSeconds(30);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}
}
