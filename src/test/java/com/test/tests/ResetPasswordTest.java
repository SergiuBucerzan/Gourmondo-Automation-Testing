package com.test.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.frontend.ForgotPasswordSteps;
import com.steps.frontend.HomePageSteps;
import com.steps.frontend.LoginSteps;
import com.steps.frontend.MyAccountSteps;
import com.steps.frontend.ResetPasswordSteps;
import com.test.BaseTest;
import com.tools.constants.GmailConstants;
import com.tools.constants.ProjectResourcesConstants;
import com.tools.gmail.GmailConnector;
import com.tools.models.extern.EmailModel;
import com.tools.models.frontend.CustomerAccountModel;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith (SerenityRunner.class)
public class ResetPasswordTest extends BaseTest {
	
	@Steps
	public ForgotPasswordSteps forgotPasswordSteps;
	
	@Steps
	public ResetPasswordSteps resetPasswordSteps;
	
	@Steps
	public MyAccountSteps myAccountSteps;
	
	@Steps
	public HomePageSteps homePageSteps;
	
	@Steps
	public LoginSteps loginSteps;
	
	public CustomerAccountModel customerModel = new CustomerAccountModel();
	
	String email, password, newPassword, begin, end, emailSubject, forgotPasswordEmailFrom = "";
	String myAccountMessage = "";
	String loginPageErrorMessage = "";
			
	@Before
	public void setUp() {
		Properties properties = new Properties();
		Properties properties2 = new Properties();
		InputStream inputStream = null;
		InputStream inputStream2 = null;
		
		try {
			inputStream = 	new FileInputStream(ProjectResourcesConstants.SERVER  + BaseTest.getShop() + File.separator + "forgot_password" + File.separator + getClass().getSimpleName() + ".properties");
			inputStream2 = 	new FileInputStream(ProjectResourcesConstants.GOURMONDO_LOCALE  + BaseTest.getLanguage() + File.separator + "language.properties");
			properties.load(inputStream);
			properties2.load(inputStream2);
			begin = properties.getProperty("begin");
			end = properties.getProperty("end");
			emailSubject = properties.getProperty("subject");
			forgotPasswordEmailFrom = properties.getProperty("forgotPasswordEmailFrom");
			email = properties.getProperty("email");
			password = properties.getProperty("password");
			newPassword = properties.getProperty("newPassword");
			myAccountMessage = properties2.getProperty("welcomeMessage");
			loginPageErrorMessage = properties2.getProperty("loginPageErrorMessage");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (inputStream !=null) {
				try {
					inputStream.close();
					inputStream2.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		customerModel.setEmailAddress(email);
		customerModel.setPassword(password);
		
		EmailModel emailModel = new EmailModel();
		emailModel.setImapGmailCom(GmailConstants.IMAP_GMAIL);
		emailModel.setImaps(GmailConstants.IMAPS);
		emailModel.setMailStoreProtocol(GmailConstants.MAIL_STORE_PROTOCOL);
		emailModel.setPassword(password);
		emailModel.setEmailAddress(email);
		
		gmailConnector = new GmailConnector(emailModel);
	}
	
	@Test
	public void resetPasswordTest() {
		loginSteps.login(customerModel);
		homePageSteps.logout();
		homePageSteps.goToLogin();
		loginSteps.clickForgotPasswordLink();
		forgotPasswordSteps.sendEmail(email);
		String text = gmailConnector.searchEmail(forgotPasswordEmailFrom, emailSubject);
		String link = gmailConnector.getLinkFromEmail(text, begin, end);
		forgotPasswordSteps.goToUrl(link);
		resetPasswordSteps.resetPassword(newPassword);
		loginSteps.inputEmail(email);
		loginSteps.inputPassword(password);
		loginSteps.clickLoginButton();
		String shownErrorMessage = loginSteps.getLoginPageErrorMessage();
		loginSteps.validateUnsuccessfulLogin(shownErrorMessage, loginPageErrorMessage);
		//validate old password doesn;t work
		loginSteps.inputPassword(newPassword);
		loginSteps.clickLoginButton();
		String myAccountUrl = myAccountSteps.getPageUrl();
		myAccountSteps.validateMyAccountPage(myAccountUrl, myAccountMessage);
		
	}
	
	

}
