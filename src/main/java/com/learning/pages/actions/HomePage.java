package com.learning.pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.learning.base.Constants;
import com.learning.base.Page;
import com.learning.pages.locators.HomePageLocators;

public class HomePage extends Page {

	public HomePageLocators homePageLocators;

	public HomePage() {
		this.homePageLocators = new HomePageLocators();

		// This is how we implement implicit wait in Page FActory approach
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, Constants.implicitWait);
		PageFactory.initElements(factory, this.homePageLocators);
		// PageFactory.initElements(driver, this.homePageLocators);
	}

	public HomePage goToFlights() {

		click(homePageLocators.flightsTab);
		// homePageLocators.flightsTab.click();
		return this;
	}

	public HomePage goToCars() {
		// homePageLocators.carsTab.click();
		click(homePageLocators.carsTab);
		return this;

	}

	public HomePage goToPackages() {
		click(homePageLocators.packagesTab);
		return this;
	}

	public HomePage goToThingsToDo() {
		click(homePageLocators.thingsToDoTab);
		return this;
	}

	public void bookFlight(String from, String to) throws InterruptedException {

		homePageLocators.fromCity.sendKeys(from);
		new Actions(driver).sendKeys(Keys.ENTER).perform();

		homePageLocators.toCity.sendKeys(to);
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		fillDatesInRequiredFormat();
		/*
		 * homePageLocators.departingFlight.click();
		 * homePageLocators.returningFlight.sendKeys(from);
		 * 
		 */
		homePageLocators.done.click();
		homePageLocators.searchFlight.click();

	}

	private void fillDatesInRequiredFormat() throws InterruptedException {
		String departingDate = getDateAfterDays(10);
		String returningDate = getDateAfterDays(13);

		WebElement departDate = driver.findElement(By.xpath("//button[contains(@aria-label,'" + departingDate + "')]"));
		WebElement returnDate = driver.findElement(By.xpath("//button[contains(@aria-label,'" + returningDate + "')]"));

		Thread.sleep(2000);
		new Actions(driver).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		departDate.click();
		Thread.sleep(2000);
		/* homePageLocators.departingFlight.click(); */
		returnDate.click();
	}

	public int findTabCount() {
		return homePageLocators.tabsCount.size();
	}

}
