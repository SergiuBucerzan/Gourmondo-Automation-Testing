package com.pages.frontend;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;

import com.pages.AbstractPage;
import com.tools.models.RegistrationModel;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


public class RegistrationPage extends AbstractPage {
	
	@FindBy(css = "button[type='button']") 
	private WebElementFacade salutation;
	
	@FindBy(css = "input#registerClientForm-firstName")
	private WebElementFacade firstNameInput;
	
	@FindBy(css = "input#registerClientForm-lastName")
	private WebElementFacade lastNameInput;
	
	@FindBy(css = "input#registerClientForm-email")
	private WebElementFacade emailAddressInput;
	
	@FindBy(css = "div#registerClientForm-select-birthday-day")
	private WebElementFacade birthdayDay;
	
	@FindBy(css = "div#registerClientForm-select-birthday-month")
	private WebElementFacade birthdayMonth;
	
	@FindBy(css = "div#registerClientForm-select-birthday-year")
	private WebElementFacade birthdayYear;
	
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
	
	
	
	
	public void selectSalutation(String gender) {
		salutation.sendKeys(gender);
	}
	
	public void inputFirstName(String firstName) {
		firstNameInput.sendKeys(firstName);
	}
	
	public void inputLastName(String lastName) {
		lastNameInput.sendKeys(lastName);
	}
	
	public void inputEmaiAddress(String firstName) {
		emailAddressInput.sendKeys(firstName);
	}
	
	public void selectBirthdayDay(String day) {
		birthdayDay.sendKeys(day);
	}
	
	public void selectBirthdayMonth(String month) {
		birthdayMonth.sendKeys(month);
	}
	
	public void selectBirthdayYear(String year) {
		birthdayYear.sendKeys(year);
	}
	
	public void inputPassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void inputConfirmationPassword(String password) {
		confirmPasswordInput.sendKeys(password);
	}
	
	public void clickTermsAndConditionsCheckbox() {
		termsAndConditionsCheckbox.click();
	}
	
	public void clickNewsletterSubscription() {
		newsletterSubscriptionCheckbox.click();
	}
	
	public void clickRegisterButton() {
		registerAndContinueButton.click();
	}

}
