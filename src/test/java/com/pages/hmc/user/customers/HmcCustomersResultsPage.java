package com.pages.hmc.user.customers;

import com.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HmcCustomersResultsPage extends AbstractPage {
	
	@FindBy(css = "td.olecIcon")
	private WebElementFacade customer;
	
	
	public void selectCustomer() {
		customer.waitUntilVisible();
		customer.click();
	}

}
