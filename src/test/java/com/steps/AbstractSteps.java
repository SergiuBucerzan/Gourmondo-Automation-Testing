package com.steps;

import com.pages.AbstractPage;
import com.pages.frontend.CartPage;
import com.pages.frontend.CategoryPage;
import com.pages.frontend.CustomerRegistrationPage;
import com.pages.frontend.HeaderPage;
import com.pages.frontend.HomePage;
import com.pages.frontend.LoginPage;
import com.pages.frontend.MyAccountPage;
import com.pages.frontend.ProductListingPage;
import com.pages.frontend.SearchResultsPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AbstractSteps extends ScenarioSteps{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected AbstractPage abstractPage;
	
	public void goToUrl(String url) {
		getDriver().get(url);
		getDriver().manage().window().maximize();
	}
	
	@Step
	public void scrollToPageBottom(){
		getAbstractPage().scrollToPageBottom();
	}
	
	public void refresh() {
		getAbstractPage().refresh();
	}
	
	public AbstractPage getAbstractPage() {
		return getPages().currentPageAt(AbstractPage.class);
	}
	
	public HeaderPage getHeaderPage() {
		return getPages().currentPageAt(HeaderPage.class);
	}
	
	public CategoryPage getCategoryPage() {
		return getPages().currentPageAt(CategoryPage.class);
	}
	
	public CartPage getCartPage() {
		return getPages().currentPageAt(CartPage.class);
	}
	
	public MyAccountPage getMyAccountPage() {
		return getPages().currentPageAt(MyAccountPage.class);
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
