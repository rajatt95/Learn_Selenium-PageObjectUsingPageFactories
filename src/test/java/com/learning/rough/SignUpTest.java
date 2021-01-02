package com.learning.rough;

import com.learning.base.Page;
import com.learning.pages.actions.SignUpPage;

public class SignUpTest {

	public static void main(String[] args) {
		Page.initConfiguration();

		SignUpPage signUpPage = Page.topNav.goToCreateAccount();
		signUpPage.doSignUp("Rajat", "Verma", "rajatvermaa80@gmail.com", "HelloExpedia@123");

		Page.quitBrowser();
	}
}
