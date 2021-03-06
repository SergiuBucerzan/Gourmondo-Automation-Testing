package com.steps.frontend;

import java.util.List;
import java.util.Random;

import com.steps.AbstractSteps;
import com.test.BaseTest;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
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
	public void goToLogin() {
		getHomePage().goToLogin();
	}
	
	@Step
	public void logout() {
		getHomePage().logout();
	}
	
	@Step
	public void inputKeyword(String keyword) {
		getHomePage().inputKeyword(keyword);
	}
	
	@Step
	public void search() {
		getHomePage().search();
	}
	
	@Step
	public void getRandomCategory() {
		getHomePage().getRandomCategory();
	}

}
