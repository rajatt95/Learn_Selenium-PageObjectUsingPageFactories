package com.learning.rough;

import com.learning.base.Page;
import com.learning.pages.actions.SignInPage;

public class SignInTest {

	public static void main(String[] args) {
		Page.initConfiguration();

		SignInPage signInPage = Page.topNav.goToSign();
		signInPage.doLogin("rajatvermaa80@gmail.com", "HelloExpedia@123");

		Page.quitBrowser();
	}
}
