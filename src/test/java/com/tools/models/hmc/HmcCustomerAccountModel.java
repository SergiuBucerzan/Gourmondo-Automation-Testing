package com.tools.models.hmc;

public class HmcCustomerAccountModel {
	
	private String emailAddress;
	private String firstName;
	private String lastName;
	private String birthDate;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthdate(String birthDate) {
		this.birthDate = birthDate;
	}

}
