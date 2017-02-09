package com.pages.frontend;

import com.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class RessetPasswordPage extends AbstractPage {

	@FindBy(css = "input[id='change.password.password']")
	WebElementFacade newPassword;

	@FindBy(css = "input[id='change.password.checkPwd']")
	WebElementFacade confirmPassword;

	@FindBy(css = "div.submit-button button span")
	WebElementFacade saveButton;

	public void inputNewPassword(String password) {
		newPassword.sendKeys(password);
	}

	public void inputConfirmationPassword(String password) {
		confirmPassword.sendKeys(password);
	}

	public void save() {
		saveButton.click();
	}

}
