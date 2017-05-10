package com.pages.frontend;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.pages.AbstractPage;
import com.tools.models.frontend.ProductModel;
import com.tools.utils.StringUtils;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductListingPage extends AbstractPage{
	
	final static Logger logger = Logger.getLogger(ProductListingPage.class);
	
	@FindBy (css = "div#wrap")
	WebElementFacade productsContainer;
	
	@FindBy (css = "div#addToCartLayer div.legend")
	WebElementFacade successPopup;
	
	@FindBy (css = "div.cart_popup_error_msg")
	WebElementFacade errorPopup;
	
	public double calculatePriceOfAddedProducts(List<ProductModel> addedProductList) {
		BigDecimal totalPrice = new BigDecimal("0.0");
		
		for(ProductModel product : addedProductList) {
			totalPrice = totalPrice.add(new BigDecimal(product.getPrice()));
		}
			
		logger.info("added products price is: " + totalPrice.doubleValue());
		
		return totalPrice.doubleValue();
	}
	
	public List<WebElementFacade> getProductsFromListingPage() {
		List<WebElementFacade> productList = new ArrayList<>();
		waitForPageToLoad();
		waitForElementsByCssLocator("div.product-listing");
		productList = productsContainer.thenFindAll(By.cssSelector("div.product div.description-wrapper"));
		return productList;
	}
	
	public List<WebElementFacade> getAvailableProducts(List<WebElementFacade> productList) {
		List<WebElementFacade> availableProductsList = new ArrayList<>();
		for (WebElementFacade product : productList) {
			if(product.find(By.cssSelector("div.stock-and-delivery div.stock-status")).getAttribute("class").contentEquals("stock-status available")) {
				availableProductsList.add(product);
				logger.info("Product " + product.find(By.cssSelector("h4.truncate-text")).getText() + " is available");
			}
		}
		
		return availableProductsList;
	}
	
	public WebElementFacade selectRandomProduct(List<WebElementFacade> availableProductsList) {
		Random random = new Random();
		WebElementFacade product = availableProductsList.get(random.nextInt(availableProductsList.size()));
		
		return product;
	}
	
	public ProductModel addProductToCart() {
	    ProductModel productModel = new ProductModel();
	    List<WebElementFacade> productList;
	    List<WebElementFacade> availableProductsList;
		
		productList = getProductsFromListingPage();
		availableProductsList = getAvailableProducts(productList);
		
		if (availableProductsList.size() > 0) {
				WebElementFacade product = selectRandomProduct(availableProductsList);
				productModel = getProductDetails(product);
				product.find(By.cssSelector("div.add-to-cart-wrapper button")).click();
				logger.info("Product added is: " + product.find(By.cssSelector("div.title-wrapper h4")).getText());		
		}
		
		
		return productModel;
	}
	
//	public List<ProductModel> addProductListToCart() {
//		List<ProductModel> productModelList = new ArrayList<>();
//		ProductModel productModel = new ProductModel();
//		
//		productListingSteps.scrollToPageBottom();
//		productList = productListingSteps.getProductsFromListingPage();
//		availableProductsList = productListingSteps.getAvailableProducts(productList);
//		
//		if (availableProductsList.size() > 0) {
//			 while (price < 25.0) {
//				WebElementFacade product = productListingSteps.selectRandomProduct(availableProductsList);
//				productModel = productListingSteps.getProductDetails(product);
//				productListingSteps.addToCart(product);
//				
//				if (productListingSteps.popupSuccessMessage()) {
//					productListingSteps.validatePopupSuccessMessage();
//					productModelList.add(productModel);
//					price = productListingSteps.calculatePriceOfAddedProducts(productModelList);
//				}else 
//					break;
//			}
//		}
//		product.find(By.cssSelector("div.add-to-cart-wrapper button")).click();
//		logger.info("Product added is: " + product.find(By.cssSelector("div.title-wrapper h4")).getText());
//	}
//	
	public ProductModel getProductDetails(WebElementFacade product) {
		ProductModel productModel = new ProductModel();
		productModel.setName(product.find(By.cssSelector("div.title-wrapper h4")).getText());
		logger.info(product.find(By.cssSelector("div.price p")).getText());
		productModel.setPrice(StringUtils.cleanPrice(product.find(By.cssSelector("div.price p")).getText()));
		
		return productModel;
	}
	
	public boolean validatePopupSuccessMessage(String message) {
		boolean success = false;
		if (successPopup.isVisible()) {
			success = successPopup.getText().contentEquals(message);
			waitABit(5000);
		}
		return success;
	}
	
	public void validatePopupSuccess(String message) {
		if (successPopup.isVisible()) {
			Assert.assertTrue("product is not available", successPopup.getText().contentEquals(message));
			waitABit(5000);
		}
	}

}
