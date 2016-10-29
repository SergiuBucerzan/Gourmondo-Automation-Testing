package com.test.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.frontend.HomePageSteps;
import com.steps.frontend.LoginSteps;
import com.steps.frontend.RegistrationSteps;
import com.steps.frontend.SearchResultsSteps;
import com.test.BaseTest;
import com.tools.mongo.reader.MongoReader;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith (SerenityRunner.class)
public class RegistrationTest extends BaseTest{
	
	@Steps
	public HomePageSteps homePage;
	
	@Steps
	public LoginSteps login;
	
	@Steps
	public RegistrationSteps registration;
	
	@Test
	public void runTest() {
		homePage.goToUrl(MongoReader.getGourmondoURL());
		homePage.clickLogin();
		login.clickCreateAccount();
		
	}
}
