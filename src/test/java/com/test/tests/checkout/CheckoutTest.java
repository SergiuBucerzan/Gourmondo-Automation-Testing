package com.test.tests.checkout;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.SynchronousQueue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.frontend.CartSteps;
import com.steps.frontend.CategorySteps;
import com.steps.frontend.HeaderSteps;
import com.steps.frontend.HomePageSteps;
import com.steps.frontend.LoginSteps;
import com.steps.frontend.ProductListingSteps;
import com.test.BaseTest;
import com.tools.constants.ProjectResourcesConstants;
import com.tools.models.CartEntryModel;
import com.tools.models.CustomerAccountModel;
import com.tools.models.ProductModel;
import com.tools.mongo.MongoConnector;
import com.tools.mongo.reader.MongoReader;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith (SerenityRunner.class)
public class CheckoutTest extends BaseTest{
	
	final static Logger logger = Logger.getLogger(CheckoutTest.class);
	
	@Steps
	public HomePageSteps homePageSteps;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public HeaderSteps headerSteps;
	
	@Steps
	public CategorySteps categorySteps;
	
	@Steps
	public ProductListingSteps productListingSteps;
	
	@Steps
	public CartSteps cartSteps;
	 
	public CustomerAccountModel customerAccountModel = new CustomerAccountModel();
	
	public List<ProductModel> productModelList = new ArrayList<>();
	
	public ProductModel productModel = new ProductModel();
	
	public List<CartEntryModel> cartEntryModelList = new ArrayList<>();
	
	public List<WebElementFacade> productList;
	
	public List<WebElementFacade> availableProductsList;
	
	public double price = 0.0;
	
	public double cartCalculatedTotal = 0.0;
	
	public double cartValueAsDisplayed = 0.0;
	
	public int noOfProductsInCart= 0;
	
	@Before
	public void setUp() {
		
		Properties prop = new Properties();
		InputStream inputStream = null;
		
		try {
			inputStream = 	new FileInputStream(ProjectResourcesConstants.SERVER + "checkout" + File.separator + "checkout_frontend_test.properties");
			prop.load(inputStream);
			customerAccountModel.setEmailAddress(prop.getProperty("email"));
			customerAccountModel.setPassword(prop.getProperty("password"));
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if (inputStream !=null) {
				try {
					inputStream.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		MongoConnector.cleanDatabase(getClass().getSimpleName());
	}
	
	@Test
	public void performCheckout() {
		loginSteps.login(MongoReader.getGourmondoURL(), customerAccountModel);
		headerSteps.goToCart();
		cartSteps.deleteCart();
		
		// add available products to cart
		while(price < 25.0) {
			headerSteps.goToHomePage();
			
			//go to product listing page randomly
			homePageSteps.getRandomCategory();
			categorySteps.getRandomSubCategory();
			
			//add random products to cart
			productListingSteps.scrollToPageBottom();
			productList = productListingSteps.getProductsFromListingPage();
			availableProductsList = productListingSteps.getAvailableProducts(productList);
			
			if (availableProductsList.size() > 0) {
				 while (price < 25.0) {
					WebElementFacade product = productListingSteps.selectRandomProduct(availableProductsList);
					productModel = productListingSteps.getProductDetails(product);
					productListingSteps.addToCart(product);
					
					if (productListingSteps.popupSuccessMessage()) {
						productListingSteps.validatePopupSuccessMessage();
						productModelList.add(productModel);
						price = productListingSteps.calculatePriceOfAddedProducts(productModelList);
					}else 
						break;
				}
			}
		}
		
		//cart page
		headerSteps.goToCart();
		cartEntryModelList = cartSteps.getCartProducts();
		noOfProductsInCart = cartSteps.getTotalNumberOfProducts(cartEntryModelList);
		cartSteps.validateCartEntryTotal(cartEntryModelList);
		cartCalculatedTotal = cartSteps.calculateCartTotal(cartEntryModelList);
		cartValueAsDisplayed = cartSteps.getCartTotal();
		cartSteps.validateCartTotal(cartCalculatedTotal, cartValueAsDisplayed);
		cartSteps.validateTotalCartAndTotalValueOfAddedProducts(price, cartCalculatedTotal);
		cartSteps.validateNoOfAddedProductsWithNoOfCartProducts(productModelList.size(), noOfProductsInCart);
		
	}
	
	@After
	public void saveTestData() {
		
	}

}
