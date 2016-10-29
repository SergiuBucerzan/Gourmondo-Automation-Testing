package com.steps;

import com.pages.frontend.HomePage;
import com.pages.frontend.LoginPage;
import com.pages.frontend.RegistrationPage;
import com.pages.frontend.ProductListingPage;
import com.pages.frontend.SearchResultsPage;
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
	
	public RegistrationPage getRegistrationPage() {
		return getPages().currentPageAt(RegistrationPage.class);
	}
	
	
	public ProductListingPage getProductListingPage() {
		return getPages().currentPageAt(ProductListingPage.class);
	}
}
