package com.tools.factory;

import java.util.GregorianCalendar;
import com.tools.models.RegistrationFormModel;
import com.tools.utils.FieldGenerator;

public class RegistrationFormModelFactory {
	
	public RegistrationFormModel getRegistrationModel() {
		
		GregorianCalendar gc = FieldGenerator.getRandomDate();
		String day = gc.get(GregorianCalendar.DAY_OF_MONTH) + "";
		String month = gc.get(GregorianCalendar.MONTH) + "";
		String year = gc.get(GregorianCalendar.YEAR) + "";
		RegistrationFormModel registrationModel = new RegistrationFormModel();
		registrationModel.setSalutation();
		registrationModel.setFirstName();
		registrationModel.setLastName();
		registrationModel.setEmailAddress();
		registrationModel.setDay(day);
		registrationModel.setMonth(month);
		registrationModel.setYear(year);
		registrationModel.setPassword();
		
		
		return registrationModel;
		
	}

}
