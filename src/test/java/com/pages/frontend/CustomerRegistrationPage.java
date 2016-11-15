package com.pages.frontend;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;

import com.pages.AbstractPage;
import com.tools.models.frontend.CustomerAccountModel;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


public class CustomerRegistrationPage extends AbstractPage {
	
	@FindBy(css = "div.btn-group")
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
	@FindBy(css = "div.register-form-wrapper div.submit-button button")
	private WebElementFacade registerAndContinueButton;
	
	
	
	
	public void selectSalutation(String gender) {
		salutation.click();
		List<WebElementFacade> salutationList = salutation.thenFindAll(By.cssSelector("div.dropdown-menu ul li a"));
		for (WebElementFacade item : salutationList) {
			if (item.getText().trim().contentEquals(gender)) {
				item.click();				
				break;
			}				
		}
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
	
	public void selectDay(String day) {
		birthdayDay.click();
		List<WebElementFacade> dayList = birthdayDay.thenFindAll(By.cssSelector("ul li"));
		for (WebElementFacade item : dayList) {
			if (item.getAttribute("id").contentEquals(day)) {
				item.click();
			}				
		}
	}
	
	public void selectMonth(String month) {
		birthdayMonth.click();
		List<WebElementFacade> monthList = birthdayMonth.thenFindAll(By.cssSelector("ul li"));
		for (WebElementFacade item : monthList) {
			if (item.getAttribute("id").contentEquals(month)) {
				item.click();
			}				
		}
	}
	
	public void selectYear(String year) {
		birthdayYear.click();
		List<WebElementFacade> yearList = birthdayYear.thenFindAll(By.cssSelector("ul li"));
		for (WebElementFacade item : yearList) {
			if (item.getAttribute("id").contentEquals(year)) {
				item.click();
			}				
		}
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
