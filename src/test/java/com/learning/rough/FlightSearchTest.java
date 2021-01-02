package com.learning.rough;

import com.learning.base.Page;
import com.learning.pages.actions.HomePage;

public class FlightSearchTest {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * WebDriverManager.chromedriver().setup(); WebDriver driver = new
		 * ChromeDriver();
		 * 
		 * driver.get("https://www.expedia.co.in/");
		 */
		// To initialize Page Factory
		// HomePage home = PageFactory.initElements(driver, HomePage.class);

		Page.initConfiguration();
		HomePage home = new HomePage();
		home.goToFlights().bookFlight("Delhi (DEL-Indira Gandhi Intl.)", "Hyderabad (HYD-Rajiv Gandhi Intl.)");

		Page.quitBrowser();
	}

}
