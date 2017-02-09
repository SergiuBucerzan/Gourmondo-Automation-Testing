package com.pages.frontend;

import com.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PasswordCodePage extends AbstractPage{

	@FindBy (css="input[id='account.email']")
	WebElementFacade email;
	
	@FindBy (css="input[id='account.passwordCode']")
	WebElementFacade passwordCode;
	
	@FindBy (css="div.form-row button span")
	WebElementFacade nextButton;
	
	public void inputEmail (String customerEmail) {
		email.sendKeys(customerEmail);
	}
	
	public void inputCode (String customerCode) {
		passwordCode.sendKeys(customerCode);
	}
	
	public void goNext() {
		nextButton.click();
	}
	
	public String getPasswordCode(String passwordCode){
		String code = "";
		
		return code;
	}
}
