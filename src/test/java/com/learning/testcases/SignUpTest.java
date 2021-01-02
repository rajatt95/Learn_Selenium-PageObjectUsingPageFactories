package com.learning.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.learning.base.Page;
import com.learning.pages.actions.SignUpPage;

public class SignUpTest {

	@BeforeTest
	public void setup() {
		Page.initConfiguration();
	}

	@AfterTest
	public void tearDown() {
		Page.quitBrowser();

	}

	@Test
	public void signUpTest() {
		SignUpPage signUpPage = Page.topNav.goToCreateAccount();
		signUpPage.doSignUp("Rajat", "Verma", "rajatvermaa80@gmail.com", "HelloExpedia@123");
	}
}
