package com.learning.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.learning.base.Page;
import com.learning.errorcollectors.ErrorCollector;
import com.learning.pages.actions.HomePage;
import com.learning.utilities.Utilities;

public class HomePageTabsTest {

	@BeforeTest
	public void setup() {
		Page.initConfiguration();
	}

	@AfterTest
	public void tearDown() {
		Page.quitBrowser();

	}

	@Test
	public void homePageTabsTest() {

		HomePage home = new HomePage();
		System.out.println("Hard Assertion");
		Assert.assertEquals(home.findTabCount(), 5);

		// TestListenerAdapter - Working as a Listener for Soft Assertions

		System.out.println("Soft Assertion");
		ErrorCollector.verifyEquals(home.findTabCount(), 9);
		home.goToFlights();
		home.goToCars();
		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		home.goToPackages();
		home.goToThingsToDo();
	}
}
