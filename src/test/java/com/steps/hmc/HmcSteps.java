package com.steps.hmc;

import com.steps.AbstractSteps;
import com.tools.constants.HybrisCredentials;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class HmcSteps extends AbstractSteps {

	private static final long serialVersionUID = 7048274313940344831L;
	
	
	@StepGroup
	public void performHmcLogin() {
		inputUsername(HybrisCredentials.USERNAME);
		inputPassword(HybrisCredentials.PASSWORD);
		clickLoginButton();
	}
	
	@Step
	public void inputUsername(String userName) {
		getHmcLoginPage().inputUserName(userName);
	}
	
	@Step
	public void inputPassword(String password) {
		getHmcLoginPage().inputPassword(password);
	}
	
	@Step
	public void clickLoginButton() {
		getHmcLoginPage().clickLoginButton();
	}
	
	

}
