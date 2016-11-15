package com.steps.frontend;

import com.pages.frontend.HomePage;
import com.steps.AbstractSteps;
import com.tools.models.frontend.CustomerAccountModel;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class CustomerRegistrationSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;
	
	@StepGroup
	public void fillCustomerRegistrationForm(CustomerAccountModel registrationFormModel) {
		selectSalutation(registrationFormModel.getSalutation());
		inputFirstName(registrationFormModel.getFirstName());
		inputLastName(registrationFormModel.getLastName());
		inputEmailAddress(registrationFormModel.getEmailAddress());
		selectDay(registrationFormModel.getDay());
		selectMonth(registrationFormModel.getMonth());
		selectYear(registrationFormModel.getYear());
		inputPassword(registrationFormModel.getPassword());
		inputConfirmationPassword(registrationFormModel.getPassword());
		clickTermsAndConditionsCheckbox();
		clickRegisterAndContinueButton();
	}
	
	@Step
	public void selectSalutation(String gender) {
		getRegistrationPage().selectSalutation(gender);
	}
	
	@Step
	public void inputFirstName(String firstName) {
		getRegistrationPage().inputFirstName(firstName);
	}
	
	@Step
	public void inputLastName(String lastName) {
		getRegistrationPage().inputLastName(lastName);
	}
	
	@Step
	public void inputEmailAddress(String emailAddress) {
		getRegistrationPage().inputEmaiAddress(emailAddress);
	}
	
	//	birthday
	@Step
	public void selectDay(String day) {
		getRegistrationPage().selectDay(day);
	}
	
	@Step
	public void selectMonth(String month) {
		getRegistrationPage().selectMonth(month);
	}
	
	@Step
	public void selectYear(String year) {
		getRegistrationPage().selectYear(year);
	}

	@Step
	public void inputPassword(String password) {
		getRegistrationPage().inputPassword(password);
	}
	
	@Step
	public void inputConfirmationPassword(String password) {
		getRegistrationPage().inputConfirmationPassword(password);
	}
	
	@Step
	public void clickTermsAndConditionsCheckbox() {
		getRegistrationPage().clickTermsAndConditionsCheckbox();
	}
	
	@Step
	public void clickNewsletterSubscriptionCheckbox() {
		getRegistrationPage().clickNewsletterSubscription();
	}
	
	@Step
	public void clickRegisterAndContinueButton() {
		getRegistrationPage().clickRegisterButton();
	}
	
	
}
