package com.steps.frontend;

import com.steps.AbstractSteps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class ResetPasswordSteps extends AbstractSteps{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@StepGroup
	public void resetPassword(String password) {
		inputNewPassword(password);
		inputConfirmationPassword(password);
		save();
	}
	
	@Step
	public void inputNewPassword(String password) {
		getResetPasswordPage().inputNewPassword(password);
	}

	@Step
	public void inputConfirmationPassword(String password) {
		getResetPasswordPage().inputConfirmationPassword(password);
	}

	@Step
	public void save() {
		getResetPasswordPage().save();
	}

}
