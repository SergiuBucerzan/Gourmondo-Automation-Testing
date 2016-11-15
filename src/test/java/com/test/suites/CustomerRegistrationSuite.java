package com.test.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.test.tests.CustomerRegistrationTest;
import com.test.tests.HmcRegisterCustomerValidationTest;

@SuiteClasses({
	CustomerRegistrationTest.class,
	HmcRegisterCustomerValidationTest.class,
})
@RunWith(Suite.class)
public class CustomerRegistrationSuite {

}
