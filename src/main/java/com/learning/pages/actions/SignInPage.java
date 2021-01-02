package com.learning.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.learning.base.Constants;
import com.learning.base.Page;
import com.learning.pages.locators.SignInPageLocators;

public class SignInPage extends Page {

	public SignInPageLocators signInPageLocators;

	public SignInPage() {
		this.signInPageLocators = new SignInPageLocators();

		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, Constants.implicitWait);
		PageFactory.initElements(factory, this.signInPageLocators);

	}

	public void doLogin(String username, String password) {

		type(signInPageLocators.emailTextBox, username);
		type(signInPageLocators.passwordTextBox, password);
		click(signInPageLocators.signInButton);

		/*
		 * signInPageLocators.emailTextBox.sendKeys(username);
		 * signInPageLocators.passwordTextBox.sendKeys(password);
		 */
		// signInPageLocators.signInButton.click();
	}
}
