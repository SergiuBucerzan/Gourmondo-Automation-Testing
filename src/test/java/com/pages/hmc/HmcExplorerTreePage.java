package com.pages.hmc;

import com.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HmcExplorerTreePage extends AbstractPage {
	
	@FindBy(id = "Tree/GenericExplorerMenuTreeNode[user]_label")
	private WebElementFacade user;
	
	@FindBy(css = "Tree/GenericExplorerMenuTreeNode[order]_label")
	private WebElementFacade order;
	
	
	public void selectUser() {
		user.waitUntilVisible();
		user.click();
	}
	
	public void selectOrder() {
		order.waitUntilVisible();
		order.click();
	}

}
