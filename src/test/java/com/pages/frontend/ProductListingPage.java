package com.pages.frontend;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.pages.AbstractPage;
import com.tools.models.ProductModel;
import com.tools.mongo.reader.MongoReader;
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
	
	public double calculatePriceOfAddedProducts(List<ProductModel> addedProductList) {
		BigDecimal totalPrice = new BigDecimal("0.0");
		
		for(ProductModel product : addedProductList) {
			totalPrice = totalPrice.add(new BigDecimal(product.getPrice()));
		}
			
		return totalPrice.doubleValue();
	}
	
	public List<WebElementFacade> getProductsFromListingPage() {
		List<WebElementFacade> productList = new ArrayList<>();
		waitForPageToLoad();
		waitForElementsByCssLocator("div#wrap div.description-wrapper div.product");
		productList = productsContainer.thenFindAll(By.cssSelector("div.description-wrapper div.product"));
			
		return productList;
	}
	
	public List<WebElementFacade> getAvailableProducts(List<WebElementFacade> availableProducts) {
		List<WebElementFacade> productList = new ArrayList<>();
		for (WebElementFacade product : availableProducts) {
			if(product.find(By.cssSelector("div.stock-and-delivery p")).getAttribute("class").contentEquals("stock-status available")) {
				productList.add(product);
				logger.info("Product " + product.find(By.cssSelector("div.title-wrapper h4")).getText() + " is available");
			}
		}
		
		return productList;
	}
	
	public WebElementFacade selectRandomProduct(List<WebElementFacade> productList) {
		Random random = new Random();
		WebElementFacade product = productList.get(random.nextInt(productList.size()));
		
		return product;
	}
	
	public void addToCart(WebElementFacade product) {
		product.find(By.cssSelector("div.add-to-cart-wrapper button")).click();
	}
	
	public ProductModel getProductDetails(WebElementFacade product) {
		ProductModel productModel = new ProductModel();
		productModel.setName(product.find(By.cssSelector("div.title-wrapper h4")).getText());
		productModel.setPrice(StringUtils.cleanPrice(product.find(By.cssSelector("div.price p")).getText()));
		
		return productModel;
	}
	
	public void validatePopupSuccessMessage() {
		Assert.assertTrue("Pop up displayed.", successPopup.isVisible());
		Assert.assertTrue("Product appear to be available but has no stock.", successPopup.getText().contentEquals("Added to cart"));
		waitABit(5000);
	}

}
