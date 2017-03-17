package com.steps.frontend;

import com.steps.AbstractSteps;
import com.test.BaseTest;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class ForgotPasswordSteps extends AbstractSteps{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@StepGroup
	public void sendEmail(String customerEmail) {
		inputEmail(customerEmail);
		send();
		
	}
	
	@Step
	public void inputEmail (String customerEmail) {
		getForgotPasswordPage().inputEmail(customerEmail);
	}
	
	@Step
	public void send() {
		getForgotPasswordPage().send();
	}
	
}
