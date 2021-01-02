package com.learning.base;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.learning.pages.actions.TopNavigation;
import com.learning.utilities.ExcelReader;
import com.learning.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {

	/*
	 * WebDriver, ExcelReader Logs Waits ExtentReport
	 */

	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String reportingPath = System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\";

	// devpinoyLogger = Standard name
	public static Logger log = Logger.getLogger("devpinoyLogger");

	public static String browser;

	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\com\\learning\\excel\\testdata.xlsx");

	public static WebDriverWait wait;

	// static - you won't get parallel execution
	public static WebDriver driver;

	// Page HASA TopNavigation
	// HotelPage HASA TopNavigation
	// FlightsPage HASA TopNavigation
	public static TopNavigation topNav;

	public static void initConfiguration() {

		initiateDriver();
		navigateToTestSiteURL();
		topNav = new TopNavigation();
	}

	private static void navigateToTestSiteURL() {
		driver.get(Constants.testSiteURL);
		driver.manage().window().maximize();

		// This is Page FActory approach
		/*
		 * driver.manage().timeouts().implicitlyWait(Constants.implicitWait,TimeUnit.
		 * SECONDS); wait = new WebDriverWait(driver, Constants.ExplicitWait);
		 */
	}

	private static void initiateDriver() {
		String browser = Constants.browser;
		if (browser.equalsIgnoreCase("firefox")) {
			initiateFireFoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			initiateChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			initiateEdgeDriver();
		}

		log.debug("Launching browser: " + browser);
	}

	private static void initiateEdgeDriver() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	private static void initiateFireFoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	private static void initiateChromeDriver() {
		WebDriverManager.chromedriver().setup();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");
		driver = new ChromeDriver(options);

		// driver = new ChromeDriver();
	}

	public static void quitBrowser() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Success");
		driver.quit();
		// driver.close();

	}

	public static void click(WebElement element) {
		System.out.println("element in click(): " + element);
		element.click();
		log.debug("Clicking on an Element : " + element);
		// test.log(LogStatus.INFO, "Clicking on : " + element);
		test.log(LogStatus.INFO, "Clicking on : " + element);
	}

	public static void type(WebElement element, String value) {
		System.out.println("type(): value -  " + value);
		element.sendKeys(value);
		log.debug("Typing in an Element : " + element + " entered value as : " + value);
		test.log(LogStatus.INFO, "Typing in : " + element + " entered value as " + value);

	}

	protected String getDateAfterDays(int daysCount) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, daysCount); // Adding daysCount
		String output = sdf.format(c.getTime());
		System.out.println(output);
		return output;

	}
}
