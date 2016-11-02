package com.steps.frontend;

import java.util.List;

import com.steps.AbstractSteps;
import com.tools.models.ProductModel;

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
		scrollToPageBottom();
		return getProductListingPage().getProductsFromListingPage();
	}
	
	public List<WebElementFacade> getAvailableProducts(List<WebElementFacade> availableProducts) {
		return getProductListingPage().getAvailableProducts(availableProducts);
	}
	
	public WebElementFacade selectRandomProduct(List<WebElementFacade> productList) {
		return getProductListingPage().selectRandomProduct(productList);
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
	
	@Step
	public void scrollToPageBottom(){
		getProductListingPage().scrollToPageBottom();
	}


}
