package com.steps.frontend;

import com.steps.AbstractSteps;
import com.test.BaseTest;
import com.tools.models.frontend.CustomerAccountModel;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class LoginSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;
	
	@StepGroup
	public void  login(CustomerAccountModel customerAccountModel) {
		goToUrl(BaseTest.getUrl());
		goToLogin();
		inputEmail(customerAccountModel.getEmailAddress());
		inputPassword(customerAccountModel.getPassword());
		clickLoginButton();
	}
	
	@Step
	public void goToLogin() {
		getHomePage().goToLogin();
	}
	
	@Step
	public void inputEmail(String email) {
		getLoginPage().inputEmail(email);
	}
	
	@Step
	public void inputPassword(String password) {
		getLoginPage().inputPassword(password);
	}
	
	@Step
	public void clickLoginButton() {
		getLoginPage().clickLoginButton();
	}
	
	@Step
	public void clickCreateAccount() {
		getLoginPage().clickCreateAccountButton();
	}
	
	@Step
	public void clickForgotPasswordLink() {
		getLoginPage().clickForgotPasswordLink();
	}
	
	@Step
	public void validateUnsuccessfulLogin(String shownErrorMessage, String errorMessage) {
		getLoginPage().validateUnsuccessfulLogin(shownErrorMessage, errorMessage);
	}
	
	public String getLoginPageErrorMessage() {
		return getLoginPage().getLoginPageErrorMessage();
	}

}
