package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver driver;
	static String browser;
	static String url;

	public static void readConfig() {

		try {
			FileInputStream input = new FileInputStream("src\\main\\java\\util\\config.properties");
			Properties properties = new Properties();
			properties.load(input);
			browser = properties.getProperty("browser");
			url = properties.getProperty("url");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static WebDriver browserInit() {
		readConfig();

		// Chrome Browser:
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		// Firefox Browser:
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

}
