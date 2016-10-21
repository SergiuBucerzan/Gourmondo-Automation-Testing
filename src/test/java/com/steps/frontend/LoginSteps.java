package com.steps.frontend;

import com.steps.AbstractSteps;

import net.thucydides.core.annotations.Step;

public class LoginSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;
	
	@Step
	public void clickCreateAccount() {
		getLoginPage().clickCreateAccountButton();
	}

}
