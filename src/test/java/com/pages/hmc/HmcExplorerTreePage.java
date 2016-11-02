package com.pages.hmc;

import com.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HmcExplorerTreePage extends AbstractPage {
	
	@FindBy(css = "table.explorer tbody tr:nth-child(6)")
	private WebElementFacade user;
	
	@FindBy(css = "table.explorer tbody tr:nth-child(7)")
	private WebElementFacade order;
	
	
	public void selectUser() {
		user.click();
	}
	
	public void selectOrder() {
		order.click();
	}

}
