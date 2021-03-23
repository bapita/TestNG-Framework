package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utils.TestUtil;
import com.crm.qa.utils.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	// first, creating the constructor of the base class to read the properties file
	// from configss/configss.properties
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/crm/qa/configss/configss.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Creating initialization method to read the values written in properties file
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			// launch chrome
			System.setProperty("webdriver.chrome.driver",
					"/home/sukanya/eclipse-workspace/AutomationFramework/src/main/resources/chromedriver");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			// launch firefox
			System.setProperty("webdriver.gecko.driver",
					"/home/sukanya/eclipse-workspace/AutomationFramework/src/main/resources/geckodriver");
			driver = new FirefoxDriver();

		} else {
			// launch chrome
			System.setProperty("webdriver.chrome.driver",
					"/home/sukanya/eclipse-workspace/AutomationFramework/src/main/resources/chromedriver");
			driver = new ChromeDriver();
		}
		
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
