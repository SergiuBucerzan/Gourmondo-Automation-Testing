package com.pages.hmc.user.customers;

import com.pages.AbstractPage;
import com.tools.models.hmc.HmcCustomerAccountModel;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HmcCustomersEditorPage extends AbstractPage{

	@FindBy(id = "Content/EditorTab[Customer.tab.common]_a")
	private WebElementFacade generalTab;
	
	@FindBy(id = "Content/EditorTab[Customer.addresses]_a")
	private WebElementFacade addressesTab;
	
	@FindBy(id = "Content/EditorTab[Customer.administration]_a")
	private WebElementFacade administrationTab;
	
	@FindBy(id = "Content/StringEditor[in Content/Attribute[Customer.uid]]_input")
	private WebElementFacade emailAddress;
	
	@FindBy(id = "Content/DateTimeEditor[in Content/Attribute[Customer.birthDate]]_date")
	private WebElementFacade birthDate;
	
	@FindBy(id = "Content/StringEditor[in Content/Attribute[Customer.firstName]]_input")
	private WebElementFacade firstName;
	
	@FindBy(id = "Content/StringEditor[in Content/Attribute[Customer.lastName]]_input")
	private WebElementFacade lastName;
	
	public HmcCustomerAccountModel getCustomerAccountData () {
		
		HmcCustomerAccountModel customerAccount = new HmcCustomerAccountModel();
		customerAccount.setEmailAddress(emailAddress.getAttribute("value"));
		customerAccount.setBirthdate(birthDate.getAttribute("value"));
		customerAccount.setFirstname(firstName.getAttribute("value"));
		customerAccount.setLastName(lastName.getAttribute("value"));
		
		return customerAccount;
	}
	
	public void selectGeneralTab() {
		generalTab.waitUntilVisible();
		generalTab.click();
	}
	
	public void selectAddressesTab() {
		addressesTab.waitUntilVisible();
		addressesTab.click();
	}
	
	public void selectAdministrationTab() {
		administrationTab.waitUntilVisible();
		administrationTab.click();
	}
	

	
}
