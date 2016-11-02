package com.tools.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tools.constants.EmailConstants;
import com.tools.factory.RegistrationFormModelFactory;
import com.tools.utils.FieldGenerator;
import com.tools.utils.FieldGenerator.TypeOfString;

public class RegistrationFormModel extends RegistrationFormModelFactory{

	private String salutation = "";
	private String firstName = "";
	private String lastName = "";	
	private String emailAddress = "";
	private String day;
	private String month = "";
	private String year = "";
	private String password = "";
	private String passwordConfirmation = "";
	private String customerId = "";
	
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
	//random data generation for input fields
	
	public void setSalutation() {
		Random random = new Random();
		List<String> salutationList = new ArrayList<>();
		salutationList.add("Mr.");
		salutationList.add("Mrs.");
		salutation = salutationList.get(random.nextInt(salutationList.size()));	
	}
	
	public void setFirstName() {
		firstName = FieldGenerator.generateStringValue(6, TypeOfString.ALPHA_CAPS);
	}
	
	public void setLastName() {
		lastName = FieldGenerator.generateStringValue(6, TypeOfString.ALPHA_CAPS);
	}
	
	public void setEmailAddress() {
		emailAddress = FieldGenerator.generateStringValue(6, TypeOfString.EMAIL) + "@" + EmailConstants.MAILINATOR;
	}
	
	public void setPassword() {
		password = FieldGenerator.generateStringValue(8, TypeOfString.ALPHANUMERIC);
	}
}
