package com.learning.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.learning.base.Constants;
import com.learning.base.Page;
import com.learning.pages.locators.SignUpPageLocators;

public class SignUpPage extends Page {

	public SignUpPageLocators signUpPageLocators;

	public SignUpPage() {
		this.signUpPageLocators = new SignUpPageLocators();

		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, Constants.implicitWait);
		PageFactory.initElements(factory, this.signUpPageLocators);

	}

	public void doSignUp(String firstName, String surname, String username, String password) {

		signUpPageLocators.firstNameTextBox.sendKeys(firstName);
		signUpPageLocators.surnameTextBox.sendKeys(surname);
		signUpPageLocators.emailTextBox.sendKeys(username);
		signUpPageLocators.passwordTextBox.sendKeys(password);
		signUpPageLocators.confirmPasswordTextBox.sendKeys(password);

	}
}
