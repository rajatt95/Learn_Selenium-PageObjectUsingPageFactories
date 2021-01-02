package com.learning.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPageLocators {

	@FindBy(xpath = "//input[contains(@id,'signin-loginid')]")
	public WebElement emailTextBox;

	
	@FindBy(xpath = "(//input[contains(@id,'signin-password')])[2]")
	public WebElement passwordTextBox;

	
	@FindBy(xpath = "//button[contains(@id,'submitButton')]")
	public WebElement signInButton;

	
	
	
	
}
