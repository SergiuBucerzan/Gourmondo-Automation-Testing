package com.pages.frontend;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pages.AbstractPage;
import com.tools.utils.StringsUtils;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


public class CustomerRegistrationPage extends AbstractPage {
	
	@FindBy(css = "form#registerClientForm div[class*='btn-group bootstrap-select  form-control control-value select-picker-wrapper']")
	private WebElementFacade salutation;	
	
	@FindBy(css = "input#registerClientForm-firstName")
	private WebElementFacade firstNameInput;
	
	@FindBy(css = "input#registerClientForm-lastName")
	private WebElementFacade lastNameInput;
	
	@FindBy(css = "input#registerClientForm-email")
	private WebElementFacade emailAddressInput;
	
	@FindBy(css = "form#registerClientForm div[class='form-group-composed form-group-1-to-3'] div[class*='form-group js-form-input-validation ']:nth-child(2)")
	private WebElementFacade birthdayDay;
	
	@FindBy(css = "form#registerClientForm div[class='form-group-composed form-group-1-to-3'] div[class*='form-group js-form-input-validation ']:nth-child(3)")
	private WebElementFacade birthdayMonth;
	
	@FindBy(css = "form#registerClientForm div[class='form-group-composed form-group-1-to-3'] div[class*='form-group js-form-input-validation ']:nth-child(4)")
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
		List<WebElementFacade> salutationList = salutation.thenFindAll(By.cssSelector("div.dropdown-menu ul li"));
		for (WebElementFacade item : salutationList) {
			if (item.getTextValue().trim().contentEquals(gender)) {
				item.click();
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
		List<WebElementFacade> dayList = birthdayDay.thenFindAll(By.cssSelector("ul li a span"));
		for (WebElementFacade item : dayList) {
			String no = StringsUtils.cleanZeroLeadingStrings(item.getText());
			System.out.println(item.getText() + " --- " + day);
			if (no.contentEquals(day)) {
				item.click();
				break;
			}				
		}
		
	}
	
	public void selectMonth(String month) {
		birthdayMonth.click();
		List<WebElementFacade> monthList = birthdayMonth.thenFindAll(By.cssSelector("ul li a span"));
		for (WebElementFacade item : monthList) {
			String no = StringsUtils.cleanZeroLeadingStrings(item.getText());
			System.out.println(item.getText() + " --- " + month);
			if (no.contentEquals(month)) {
				item.click();
				break;
			}				
		}
	}
	
	public void selectYear(String year) {
		birthdayYear.click();
		List<WebElementFacade> yearList = birthdayYear.thenFindAll(By.cssSelector("ul li a span"));
		for (WebElementFacade item : yearList) {
			String no = StringsUtils.cleanZeroLeadingStrings(item.getText());
			System.out.println(item.getText() + " --- " + year);
			if (no.contentEquals(year)) {
				item.click();
				break;
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
