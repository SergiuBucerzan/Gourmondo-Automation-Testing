package com.steps.frontend;

import java.util.List;

import com.steps.AbstractSteps;
import com.tools.models.frontend.ProductModel;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class ProductListingSteps extends AbstractSteps{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public double calculatePriceOfAddedProducts(List<ProductModel> addedProductList) {
		return getProductListingPage().calculatePriceOfAddedProducts(addedProductList);
	}
	
	public List<WebElementFacade> getProductsFromListingPage() {
		return getProductListingPage().getProductsFromListingPage();
	}
	
	@Step
	public void scrollToPageBottom() {
		abstractPage.scrollToPageBottom();
	}
	
	public List<WebElementFacade> getAvailableProducts(List<WebElementFacade> productsList) {
		return getProductListingPage().getAvailableProducts(productsList);
	}
	
	public WebElementFacade selectRandomProduct(List<WebElementFacade> availableProductsList) {
		return getProductListingPage().selectRandomProduct(availableProductsList);
	}
	
	@Step
	public void addToCart(WebElementFacade product) {
		getProductListingPage().addToCart(product);
	}
	
	public ProductModel getProductDetails(WebElementFacade product) {
		return getProductListingPage().getProductDetails(product);
	}
	
	@Step
	public void validatePopupSuccessMessage() {
		getProductListingPage().validatePopupSuccessMessage();
	}
	
	
	public boolean popupSuccessMessage() {
		return getProductListingPage().popupSuccessMessage();
	}

}
