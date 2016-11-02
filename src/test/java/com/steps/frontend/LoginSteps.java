package com.steps.frontend;

import com.steps.AbstractSteps;
import com.tools.models.CustomerAccountModel;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class LoginSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;
	
	@StepGroup
	public void login(String url, CustomerAccountModel customerAccountModel) {
		goToUrl(url);
		goToLogin();
		inputEmail(customerAccountModel.getEmailAddress());
		inputPassword(customerAccountModel.getPassword());
		clickLoginButton();
	}
	
	@Step
	public void goToLogin() {
		getHomePage().login();
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

}
