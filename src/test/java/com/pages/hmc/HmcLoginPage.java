package com.pages.hmc;

import com.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HmcLoginPage extends AbstractPage {
	
	@FindBy(id = "Main_user")
	private WebElementFacade userName;
	
	@FindBy(id = "Main_password")
	private WebElementFacade password;
	
	@FindBy(id = "Main_a")
	private WebElementFacade loginButton;
	
	
	public void inputUserName(String name) {
		userName.sendKeys(name);
	}
	
	public void inputPassword(String pword) {
		password.sendKeys(pword);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}

}
