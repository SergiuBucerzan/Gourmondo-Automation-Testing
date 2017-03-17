package com.pages.frontend;

import org.junit.Assert;

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
	
	@FindBy(css = "a.password-forgotten-link")
	private WebElementFacade forgotPasswordLink;
	
	@FindBy(css = "div.btn")
	private WebElementFacade createAccountButton;
	
	@FindBy(css = "div[class='alert negative'] div")
	private WebElementFacade loginErrorMessage;
	
	
	public void inputEmail(String email) {
		emailInput.sendKeys(email);
	}
	
	public void inputPassword(String password) {
		passwordInput.sendKeys(password);
	}
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clickForgotPasswordLink() {
		forgotPasswordLink.click();
	}
	
	public void clickCreateAccountButton() {
		createAccountButton.click();
	}
	
	public String getLoginPageErrorMessage() {
		return loginErrorMessage.getText();
	}
	
	public void validateUnsuccessfulLogin(String shownErrorMessage, String errorMessage) {
		Assert.assertTrue("Error message doe not match", shownErrorMessage.contentEquals(errorMessage));
	}
}
