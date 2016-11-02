package com.test.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.frontend.HomePageSteps;
import com.steps.frontend.LoginSteps;
import com.steps.frontend.CustomerRegistrationSteps;
import com.test.BaseTest;
import com.tools.constants.MongoConstants;
import com.tools.factory.RegistrationFormModelFactory;
import com.tools.models.RegistrationFormModel;
import com.tools.mongo.MongoConnector;
import com.tools.mongo.reader.MongoReader;
import com.tools.mongo.writer.MongoWriter;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith (SerenityRunner.class)
public class CustomerRegistrationTest extends BaseTest{
	
	@Steps
	public HomePageSteps homePage;
	
	@Steps
	public LoginSteps login;
	
	@Steps
	public CustomerRegistrationSteps customerRegistrationSteps;
	
	@Steps
	public RegistrationFormModel registrationFormModel;
	
	@Before
	public void setUp() {
		RegistrationFormModelFactory registrationModelFactory = new RegistrationFormModelFactory();
		registrationFormModel = registrationModelFactory.getRegistrationModel(); 		
		MongoConnector.cleanDatabase(MongoConstants.CUSTOMER_DB);
	}
	
	@Test
	public void registerNewCustomerTest() {
		homePage.goToUrl(MongoReader.getGourmondoURL());
		homePage.clickLogin();
		login.clickCreateAccount();
		customerRegistrationSteps.fillCustomerRegistrationForm(registrationFormModel);
		
	}
	
	@After
    public void saveCustomerRegistrationModel(){	    
    	MongoWriter.saveCustomerRegistrationForm(registrationFormModel, MongoConstants.CUSTOMER_DB);	    	
    }
}