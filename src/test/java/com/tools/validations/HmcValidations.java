package com.tools.validations;

import org.junit.Assert;
import com.tools.models.frontend.CustomerAccountModel;
import com.tools.models.hmc.HmcCustomerAccountModel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class HmcValidations {
	
	@StepGroup
	public void validateHmcCustomerRegistrationData(CustomerAccountModel initialData, HmcCustomerAccountModel finalData) {
		verifyEmail("Email Address ", initialData.getEmailAddress(), finalData.getEmailAddress());
		verifyBirthDate("Birthdate ", initialData.getMonth() + "/" + initialData.getDay() + "/" + initialData.getYear(), finalData.getBirthDate());
		verifyFirstName("First name ", initialData.getFirstName(), finalData.getFirstName());
		verifyLastName("Last name ", initialData.getLastName(), finalData.getLastName());
		System.out.println("Hmc validation successful!");
	}
	
	@Step
	public void verifyEmail(String message, String initialEmail, String finalEmail) {
		Assert.assertTrue(message + " values are incorrect:  Expected - " + finalEmail + "  Actual - " + initialEmail, finalEmail.contains(initialEmail));
		System.out.println(finalEmail + " = " + initialEmail);
		System.out.println(message + "is correct!");
	}
	
	@Step
	public void verifyBirthDate(String message, String initialBirthDate, String finalBirthDate) {
		Assert.assertTrue(message + " values are incorrect:  Expected - " + finalBirthDate + "  Actual - " + initialBirthDate, finalBirthDate.contains(initialBirthDate));
		System.out.println(finalBirthDate + " = " + initialBirthDate);
		System.out.println(message + "is correct!");
	}
	
	@Step
	public void verifyFirstName(String message, String initialFirstName, String finalFirstName) {
		Assert.assertTrue(message + " values are incorrect:  Expected - " + initialFirstName + "  Actual - " + finalFirstName, initialFirstName.contentEquals(finalFirstName));
		System.out.println(initialFirstName + " = " + finalFirstName);
		System.out.println(message + "is correct!");
	}
	
	@Step
	public void verifyLastName(String message, String initialLastName, String finalLastName) {
		Assert.assertTrue(message + " values are incorrect:  Expected - " + initialLastName + "  Actual - " + finalLastName, initialLastName.contentEquals(finalLastName));
		System.out.println(initialLastName + " = " + finalLastName);
		System.out.println(message + "is correct!");
	}
}
