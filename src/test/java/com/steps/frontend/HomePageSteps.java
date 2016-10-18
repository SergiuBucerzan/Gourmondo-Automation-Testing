package com.steps.frontend;

import com.steps.AbstractSteps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class HomePageSteps extends AbstractSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@StepGroup
	public void searchKeyword(String keyword) {
		inputKeyword(keyword);
		search();
	}
	
	@Step
	public void inputKeyword(String keyword) {
		getHomePage().inputKeyword(keyword);
	}
	
	@Step
	public void search() {
		getHomePage().search();
	}
	
	

}
