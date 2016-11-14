package com.pages.hmc.user.customers;

import org.openqa.selenium.support.ui.Select;
import com.pages.AbstractPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HmcCustomersSearchPage extends AbstractPage {
	
	@FindBy(xpath = "//div/div/select")
	private WebElementFacade IDComparator;
	
	@FindBy(id = "Content/StringEditor[in Content/GenericCondition[Customer.uid]]_input")
	private WebElementFacade idValue;
	
	@FindBy(id = "Content/OrganizerSearch[Customer]_searchbutton")
	private WebElementFacade searchButton;
	
	
	public void selectIDComparator() {
		Select comparator = new Select(IDComparator);
		comparator.selectByIndex(0);
	}
	
	// ID = email address
	public void inputIDValue(String value) {
		idValue.waitUntilVisible();
		idValue.sendKeys(value);
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
}
