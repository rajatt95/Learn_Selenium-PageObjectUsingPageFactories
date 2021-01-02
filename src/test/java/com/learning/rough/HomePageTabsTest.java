package com.learning.rough;

import org.testng.Assert;

import com.learning.base.Page;
import com.learning.pages.actions.HomePage;

public class HomePageTabsTest {

	public static void main(String[] args) throws InterruptedException {

		Page.initConfiguration();
		HomePage home = new HomePage();

		Assert.assertEquals(home.findTabCount(), 5);
		home.goToFlights();
		home.goToCars();
		home.goToPackages();
		home.goToThingsToDo();
		Page.quitBrowser();
	}
}
