package com.steps.hmc;

import com.steps.AbstractSteps;
import com.tools.constants.HybrisCredentials;
import com.tools.models.CustomerAccountModel;
import com.tools.mongo.reader.MongoReader;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class HmcSteps extends AbstractSteps {

	private static final long serialVersionUID = 7048274313940344831L;
	
	
	@StepGroup
	public void performHmcLogin() {
		goToUrl(MongoReader.getGourmondoURL() + HybrisCredentials.HMC);
		inputUsername(HybrisCredentials.USERNAME);
		inputPassword(HybrisCredentials.PASSWORD);
		clickLoginButton();
	}
	
	@StepGroup
	public void selectCustomer(CustomerAccountModel customerModel) {
		selectUser();
		selectCustomers();
		selectIDComparator();
		inputIDValue(customerModel.getEmailAddress());
		clickSearchButton();
		selectCustomer();
	}
	
	@Step
	public void inputUsername(String userName) {
		getHmcLoginPage().inputUserName(userName);
	}
	
	@Step
	public void inputPassword(String password) {
		getHmcLoginPage().inputPassword(password);
	}
	
	@Step
	public void clickLoginButton() {
		getHmcLoginPage().clickLoginButton();
	}
	
	@Step
	public void selectUser() {
		getHmcExplorerTreePage().selectUser();
	}
	
	@Step
	public void selectCustomers() {
		getHmcUserPage().selectCustomers();
	}
	
	@Step
	public void selectIDComparator() {
		getHmcCustomersSearchPage().selectIDComparator();
	}
	
	@Step
	public void inputIDValue(String emailAddress) {
		getHmcCustomersSearchPage().inputIDValue(emailAddress);
	}
	
	@Step
	public void clickSearchButton() {
		getHmcCustomersSearchPage().clickSearchButton();
	}
	
	@Step
	public void selectCustomer() {
		getHmcCustomersResultsPage().selectCustomer();
	}
	
	@Step
	public void selectOrder() {
		getHmcExplorerTreePage().selectOrder();
	}
}
