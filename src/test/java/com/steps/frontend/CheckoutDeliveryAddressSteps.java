package com.steps.frontend;

import com.steps.AbstractSteps;
import com.tools.models.frontend.CustomerAddressModel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class CheckoutDeliveryAddressSteps extends AbstractSteps{
	
	private static final long serialVersionUID = 1L;
	
	
	@StepGroup
	public void fillInCustomerAddressForm(CustomerAddressModel addressModel) {
		selectTitle(addressModel.getTitle());
		inputFirstName(addressModel.getFirstName());
		inputLastName(addressModel.getLastName());
		inputStreetName(addressModel.getStreetName());
		inputStreetNumber(addressModel.getStreetNumber());
		inputZipCode(addressModel.getZipCode());
		inputTown(addressModel.getTown());
		inputPhoneNumber(addressModel.getPhoneNumber());
		clickSaveButton();
		clickContinueButton();
	}
	
	@Step
	public void selectTitle(String title) {
		getCheckoutDeliveryAddressPage().selectTitle(title);
	}
	
	@Step
	public void inputFirstName(String firstName) {
		getCheckoutDeliveryAddressPage().inputFirstName(firstName);
	}
	
	@Step
	public void inputLastName(String lastName) {
		getCheckoutDeliveryAddressPage().inputLastName(lastName);
	}
	
	@Step
	public void inputStreetName(String streetName) {
		getCheckoutDeliveryAddressPage().inputStreetName(streetName);
	}
	
	@Step
	public void inputStreetNumber(String streetNumber) {
		getCheckoutDeliveryAddressPage().inputStreetNumber(streetNumber);
	}
	
	@Step
	public void inputZipCode(String zipCode) {
		getCheckoutDeliveryAddressPage().inputZipCode(zipCode);
	}
	
	@Step
	public void inputTown(String town) {
		getCheckoutDeliveryAddressPage().inputTown(town);
	}
	
	@Step
	public void inputPhoneNumber(String phoneNumber) {
		getCheckoutDeliveryAddressPage().inputPhoneNumber(phoneNumber);
	}
	
	@Step
	public void selectCountry(String country) {
	}
	
	@Step
	public void clickSaveButton() {
		getCheckoutDeliveryAddressPage().clickSaveButton();
	}
	
	@Step
	public void clickContinueButton() {
		getCheckoutDeliveryAddressPage().clickContinueButton();
	}

}
