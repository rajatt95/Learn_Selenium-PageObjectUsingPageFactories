package com.learning.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePageLocators {

	// Tabs - Start
	@FindBy(xpath = "//span[contains(text(),'Flights')]")
	public WebElement flightsTab;

	// @FindAll - will take the working locator
	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Cadhsjadhjashdrs')]"),
			@FindBy(xpath = "(//span[contains(@class,'uitk-tab-text')])[3]") })
	public WebElement carsTab;

	// @FindBys -
	// //ul[contains(@id,'uitk-tabs-button-container')]//span[contains(text(),'Packages')]

	// @FindBy(xpath = "//span[contains(text(),'Packages')]")
//If it does not find the 1st element, then, it won't further to look for 2nd
	@FindBys({ @FindBy(xpath = "//ul[contains(@id,'uitk-tabs-button-container')]"),
			@FindBy(xpath = "//span[contains(text(),'Packages')]") })
	public WebElement packagesTab;

	@FindBy(xpath = "//span[contains(text(),'Things to do')]")
	public WebElement thingsToDoTab;
	// Tabs - End

	// Flight Booking - Start
	@FindBy(xpath = "//*[@id=\"location-field-leg1-origin-menu\"]/div[1]/button")
	public WebElement fromCity;

	@FindBy(xpath = "//*[@id=\"location-field-leg1-destination-menu\"]/div[1]/button[1]")
	public WebElement toCity;

	@FindBy(xpath = "(//button[contains(@id,'d1-btn')])")
	public WebElement departingFlight;

	@FindBy(xpath = "(//button[contains(@id,'d2-btn')])")
	public WebElement returningFlight;

	@FindBy(xpath = "//span[contains(text(),'Done')]")
	public WebElement done;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	public WebElement searchFlight;

	// Flight Booking - End

	@FindBy(xpath = "//a[contains(@role,'tab')]")
	public List<WebElement> tabsCount;

}
