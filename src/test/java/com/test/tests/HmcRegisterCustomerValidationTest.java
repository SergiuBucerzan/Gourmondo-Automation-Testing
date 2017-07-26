package com.test.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.steps.hmc.HmcSteps;
import com.test.BaseTest;
import com.tools.models.frontend.CustomerAccountModel;
import com.tools.models.hmc.HmcCustomerAccountModel;
import com.tools.mongo.reader.MongoReader;
import com.tools.validations.HmcValidations;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)

public class HmcRegisterCustomerValidationTest extends BaseTest {
	
	@Steps
	public HmcSteps hmcSteps;
	
	@Steps
	public HmcValidations hmcValidations;
	
	public CustomerAccountModel customerModel;
	public CustomerAccountModel initialData = MongoReader.getCustomerRegistrationData();
	public HmcCustomerAccountModel finalData;
	
	@Before
	public void setUp() throws Exception {
		customerModel = MongoReader.getCustomerRegistrationData();
	}
	
	@Test
	public void verifyCustomerRegistrationTest() {
		hmcSteps.performHmcLogin();
		hmcSteps.selectCustomer(customerModel, "User", "Customers");
		finalData = hmcSteps.getCustomerAccountData();
		hmcValidations.validateHmcCustomerRegistrationData(initialData, finalData);
	}

}
