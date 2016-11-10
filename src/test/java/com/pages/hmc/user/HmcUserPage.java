package com.pages.hmc.user;

import com.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HmcUserPage extends AbstractPage {

	@FindBy(id = "Tree/GenericLeafNode[Customer]_tr")
	private WebElementFacade customers;

	public void selectCustomers() {
		customers.waitUntilVisible();
		customers.click();
	}
}
