package com.steps;

import com.pages.frontend.CartPage;
import com.pages.frontend.HomePage;
import com.pages.frontend.LoginPage;
import com.pages.frontend.ProductListingPage;
import com.pages.frontend.CustomerRegistrationPage;
import com.pages.frontend.SearchResultsPage;
import com.tools.factory.RegistrationFormModelFactory;
import com.tools.models.RegistrationFormModel;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AbstractSteps extends ScenarioSteps{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Step
	public void goToUrl(String url) {
		getDriver().get(url);
		getDriver().manage().window().maximize();
	}
	
	public HomePage getHomePage() {
		return getPages().currentPageAt(HomePage.class);
	}
	
	public SearchResultsPage getSearchResultsPage() {
		return getPages().currentPageAt(SearchResultsPage.class);
	}
	
	public LoginPage getLoginPage() {
		return getPages().currentPageAt(LoginPage.class);
	}
	
	public CustomerRegistrationPage getRegistrationPage() {
		return getPages().currentPageAt(CustomerRegistrationPage.class);
	}
	
	
	public ProductListingPage getProductListingPage() {
		return getPages().currentPageAt(ProductListingPage.class);
	}
	
	public CartPage getCartPAge() {
		return getPages().currentPageAt(CartPage.class);
	}
}
