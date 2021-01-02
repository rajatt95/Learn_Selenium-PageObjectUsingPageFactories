package com.learning.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.learning.base.Constants;
import com.learning.base.Page;
import com.learning.pages.locators.TopNavigationLocators;

//HotelPage ISA Page
//HotelPage ISA Page

//Page HASA TopNavigation
//HotelPage HASA TopNavigation
//FlightsPage HASA TopNavigation
public class TopNavigation {

	public TopNavigationLocators topNavigationLocators;

	public TopNavigation() {
		this.topNavigationLocators = new TopNavigationLocators();

		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(Page.driver, Constants.implicitWait);
		PageFactory.initElements(factory, this.topNavigationLocators);
	}

	public SignInPage goToSign() {

		// topNavigationLocators.signIn.click();
		// topNavigationLocators.signIn_signInButton.click();
		Page.click(topNavigationLocators.signIn);
		Page.click(topNavigationLocators.signIn_signInButton);

		return new SignInPage();
	}

	public SignUpPage goToCreateAccount() {

		Page.click(topNavigationLocators.signIn);
		Page.click(topNavigationLocators.signIn_createButtonLink);

		return new SignUpPage();

	}

	public void goToSupport() {

	}
}
