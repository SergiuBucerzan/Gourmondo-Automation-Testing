package com.pages.frontend;

import com.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class RegistrationPage extends AbstractPage {
	
	@FindBy(css = "button[type='button']")
	private WebElementFacade gender;
	
	@FindBy(css = "input#registerClientForm-firstName")
	private WebElementFacade firstNameInput;
	
	@FindBy(css = "input#registerClientForm-lastName")
	private WebElementFacade lastNameInput;
	
	@FindBy(css = "input#registerClientForm-email")
	private WebElementFacade emailAddressInput;
	
	@FindBy(css = "input#registerClientForm-password")
	private WebElementFacade passwordInput;
	
	@FindBy(css = "input#registerClientForm-checkPwd")
	private WebElementFacade confirmPasswordInput;
	
	@FindBy(css = "label[for='registerClientForm-termsConditionsCheck']")
	private WebElementFacade termsAndConditionsCheckbox;
	
	@FindBy(css = "label[for='registerClientForm-newsletterSubscrCheck']")
	private WebElementFacade newsletterSubscriptionCheckbox;
	
	// verify css locator
	@FindBy(css = "button[type='submit']")
	private WebElementFacade registerAndContinueButton;

}
