package com.pages.frontend;

import java.util.List;
import java.util.Random;

import com.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CheckoutDeliveryAddressPage extends AbstractPage{
	
	@FindBy(css = "div#addBillingDefaultAddressForm-titleCode section.main")
	WebElementFacade title;
	
	@FindBy(css = "input[name='firstName']")
	WebElementFacade firstName;
	
	@FindBy(css = "input[name='lastName']")
	WebElementFacade lastName;
	
	@FindBy(css = "input[name='line1']")
	WebElementFacade streetName;
	
	@FindBy(css = "input[name='line2']")
	WebElementFacade streetNumber;
	
	@FindBy(css = "input[name='postcode']")
	WebElementFacade zipCode;
	
	@FindBy(css = "input[name='townCity']")
	WebElementFacade town;
	
	@FindBy(css = "input[name='phoneNr")
	WebElementFacade phoneNumber;
	
	@FindBy(css = "div#addBillingDefaultAddressForm-countryIso div.control-group div.values")
	WebElementFacade country;
	
	@FindBy(css = "div.form-row-button button[type='submit']")
	WebElementFacade saveButton;
	
	@FindBy(css = "form#submitAddressesForm div.row div.col-sm-6 button")
	WebElementFacade continueButton;
	
	
	public void selectTitle(String gender) {
		title.click();
		List<WebElementFacade> titleList = title.thenFindAll(By.cssSelector("div.dropdown-menu ul li a"));
		Random random = new Random();
		if (titleList.size() > 0) {			
			WebElementFacade genderSelected = titleList.get(random.nextInt(titleList.size()));
			logger.info("Selected gender is: " + genderSelected.getText());
			genderSelected.click();
		} else
			logger.info("No gender found!");
	}
	
	public void inputFirstName(String firstname) {
		firstName.sendKeys(firstname);
	}
	
	public void inputLastName(String lastname) {
		lastName.sendKeys(lastname);
	}
	
	public void inputStreetName(String streetname) {
		streetName.sendKeys(streetname);
	}
	
	public void inputStreetNumber(String streetnumber) {
		streetNumber.sendKeys(streetnumber);
	}
	
	public void inputZipCode(String zipcode) {
		zipCode.sendKeys(zipcode);
	}
	
	public void inputTown(String city) {
		town.sendKeys(city);
	}
	
	public void inputPhoneNumber(String phonenumber) {
		phoneNumber.sendKeys(phonenumber);
	}
	
	public void selectCountry() {
		
	}
	
	public void clickSaveButton() {
		saveButton.waitUntilPresent();
		saveButton.click();
	}
	
	public void clickContinueButton() {
		continueButton.waitUntilPresent();
		continueButton.click();
	}

	

}
