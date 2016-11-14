package com.test.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.steps.hmc.HmcSteps;
import com.test.BaseTest;
import com.tools.models.CustomerAccountModel;
import com.tools.mongo.reader.MongoReader;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)

public class HmcRegisterCustomerValidationTest extends BaseTest {
	
	@Steps
	public HmcSteps hmcSteps;
	
	public CustomerAccountModel customerModel;
	
	@Before
	public void setUp() throws Exception {
		customerModel = MongoReader.getCustomerRegistrationData();
	}
	
	@Test
	public void verifyCustomerRegistrationTest() {
		hmcSteps.performHmcLogin();
		hmcSteps.selectCustomer(customerModel);
	}

}
