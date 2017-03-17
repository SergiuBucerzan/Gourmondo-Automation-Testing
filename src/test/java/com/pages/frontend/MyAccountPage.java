package com.pages.frontend;

import org.junit.Assert;

import com.pages.AbstractPage;
import com.test.BaseTest;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class MyAccountPage extends AbstractPage {
	
	@FindBy (css="div.welcome-header h1:nth-child(1)")
	WebElementFacade welcomeMessage;

	public void validateMyAccountPage(String link, String myAccountMessage) {
		Assert.assertTrue("Unsuccessful login.", link.contentEquals("https://test-de.gourmondo.evozon.com:9002/my-account"));
		Assert.assertTrue("Unsuccessful login.", welcomeMessage.getText().contentEquals(myAccountMessage));
	}
}
