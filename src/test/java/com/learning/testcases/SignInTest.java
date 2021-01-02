package com.learning.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.learning.base.Constants;
import com.learning.base.Page;
import com.learning.pages.actions.SignInPage;
import com.learning.utilities.Utilities;

public class SignInTest {

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void signInTest(Hashtable<String, String> data) {

		if (data.get(Constants.excel_runMode).equalsIgnoreCase("N")) {
			throw new SkipException("Skipping the test as the Run mode is NO");
		}
		Page.initConfiguration();
		SignInPage signin = Page.topNav.goToSign();
		signin.doLogin(data.get(Constants.excel_username), data.get(Constants.excel_password));

	}

	@AfterMethod
	public void tearDown() {
		if (Page.driver != null) {
			Page.quitBrowser();
		}
	}

	/*
	 * @BeforeTest public void setup() { Page.initConfiguration(); }
	 * 
	 * @AfterTest public void tearDown() { Page.quitBrowser();
	 * 
	 * }
	 * 
	 * @Test(dataProviderClass = Utilities.class, dataProvider = "dp") public void
	 * signInTest(Hashtable<String, String> data) { SignInPage signInPage =
	 * Page.topNav.goToSign(); // signInPage.doLogin("rajatvermaa80@gmail.com",
	 * "HelloExpedia@123");
	 * 
	 * signInPage.doLogin(data.get(Constants.username),
	 * data.get(Constants.password)); }
	 */}
