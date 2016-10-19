package com.pages.frontend;

import com.pages.AbstractPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends AbstractPage {

	@FindBy(css = "input#j_username")
	private WebElementFacade emailInput; 
	
	@FindBy(css = "input#j_password")
	private WebElementFacade passwordInput;
	
	// verify css locator
	@FindBy(css = "button[type='submit']")
	private WebElementFacade loginButton;
	
	@FindBy(css = "a.password-forgotten")
	private WebElementFacade forgotPasswordLink;
	
	@FindBy(css = "div.btn")
	private WebElementFacade createAccountButton;
	
	
	
}
