package com.learning.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopNavigationLocators {

	@FindBy(xpath = "//button//div[contains(text(),'Sign in')]")
	public WebElement signIn;


	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	public WebElement signIn_signInButton;


	@FindBy(xpath = "//a[contains(text(),'Create a free account')]")
	public WebElement signIn_createButtonLink;

	
	
}
