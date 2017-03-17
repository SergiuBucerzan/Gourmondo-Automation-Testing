package com.steps.frontend;

import com.steps.AbstractSteps;

import net.thucydides.core.annotations.Step;

public class MyAccountSteps extends AbstractSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Step
	public void validateMyAccountPage(String link, String myAccountMessage) {
		getMyAccountPage().validateMyAccountPage(link, myAccountMessage);
	}
}
