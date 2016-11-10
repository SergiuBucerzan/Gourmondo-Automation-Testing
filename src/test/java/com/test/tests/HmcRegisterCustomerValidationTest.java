package com.test.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.steps.hmc.HmcSteps;
import com.test.BaseTest;
import com.tools.constants.HybrisCredentials;
import com.tools.mongo.reader.MongoReader;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)

public class HmcRegisterCustomerValidationTest extends BaseTest {
	
	@Steps
	public HmcSteps hmcSteps;
	
//	@Before
//	public void setUp() throws Exception {
//		
//	}
	
	@Test
	public void verifyCustomerRegistrationTest() {
		hmcSteps.goToUrl(MongoReader.getGourmondoURL() + HybrisCredentials.HMC);
		hmcSteps.performHmcLogin();
	}

}
