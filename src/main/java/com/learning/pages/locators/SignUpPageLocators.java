package com.learning.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPageLocators {

	@FindBy(id = "create-account-firstname")
	public WebElement firstNameTextBox;

	@FindBy(xpath = "//input[contains(@id,'create-account-lastname')]")
	public WebElement surnameTextBox;

	@FindBy(xpath = "//input[contains(@id,'create-account-emailId')]")
	public WebElement emailTextBox;

	@FindBy(xpath = "//input[contains(@id,'create-account-password')]")
	public WebElement passwordTextBox;

	@FindBy(id = "create-account-confirm-password")
	public WebElement confirmPasswordTextBox;

}
