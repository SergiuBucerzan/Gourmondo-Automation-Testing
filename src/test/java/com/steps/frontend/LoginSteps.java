package com.steps.frontend;

import com.steps.AbstractSteps;

import net.thucydides.core.annotations.Step;

public class LoginSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;
	
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
