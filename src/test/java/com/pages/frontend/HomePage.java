package com.pages.frontend;

import com.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends AbstractPage{

	@FindBy (id = "log-in")
	WebElementFacade login;
	
	@FindBy (id = "search")
	WebElementFacade serachBox;
	
	@FindBy (css = "button.search-button")
	WebElementFacade submitButton;
	
	public void login() {
		login.click();
	}
	
	public void inputKeyword(String keyword) {
		serachBox.sendKeys(keyword);
	}
	
	public void search() {
		submitButton.click();
	}
}
