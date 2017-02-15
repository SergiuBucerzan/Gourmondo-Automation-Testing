package com.pages.frontend;

import com.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ForgotPasswordPage extends AbstractPage{
	
	@FindBy (css="input[id='account.email']")
	WebElementFacade email;
	
	@FindBy (css="div#email button span")
	WebElementFacade resetButton;
	
	@FindBy (css="div.navigation button span")
	WebElementFacade toTheShop;
	
	public void inputEmail (String customerEmail) {
		email.sendKeys(customerEmail);
	}
	
	public void goNext() {
		resetButton.click();
	}

}
