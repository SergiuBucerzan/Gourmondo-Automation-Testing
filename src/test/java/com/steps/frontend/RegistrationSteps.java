package com.steps.frontend;

import com.pages.frontend.HomePage;
import com.steps.AbstractSteps;
import com.tools.models.RegistrationModel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class RegistrationSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;
	
	@StepGroup
	public void fillCustomerRegistrationForm(RegistrationModel registrationModel) {
		selectSalutation(registrationModel.getSalutation());
		inputFirstName(registrationModel.getFirstName());
		inputLastName(registrationModel.getLastName());
		inputEmailAddress(registrationModel.getEmailAddress());
		//birthday
		inputPassword(registrationModel.getPassword());
		inputConfirmationPassword(registrationModel.getPassword());
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
	public void setBirthday(String birthday) {
	}

	@Step
	public void inputPassword(String password) {
		getRegistrationPage().inputPassword(password);
	}
	
	@Step
	public void inputConfirmationPassword(String password) {
		getRegistrationPage().inputPassword(password);
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
