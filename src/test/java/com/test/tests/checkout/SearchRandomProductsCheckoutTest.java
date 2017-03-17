package com.test.tests.checkout;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
import com.tools.models.frontend.CartEntryModel;
import com.tools.models.frontend.CustomerAccountModel;
import com.tools.models.frontend.ProductModel;
import com.tools.mongo.MongoConnector;
import com.tools.mongo.reader.MongoReader;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith (SerenityRunner.class)
public class SearchRandomProductsCheckoutTest extends BaseTest{
	
	final static Logger logger = Logger.getLogger(SearchRandomProductsCheckoutTest.class);
	
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
			inputStream = 	new FileInputStream(ProjectResourcesConstants.SERVER + shop + File.separator + "checkout" + File.separator + getClass().getSimpleName() + ".properties");
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
		loginSteps.login(customerAccountModel);
		headerSteps.goToCart();
		cartSteps.deleteCart();
		
		while(price < 25.0) {
	
			//go to product listing page randomly
			headerSteps.goToHomePage();
			homePageSteps.getRandomCategory();
			categorySteps.getRandomSubCategory();
			
			//add random products to cart
		    while (price < 25.0) {
				productModel = productListingSteps.addProductToCart();
					
				if (productListingSteps.validatePopupSuccessMessage()) {
					productModelList.add(productModel);
					price = productListingSteps.calculatePriceOfAddedProducts(productModelList);
				}else 
					break;
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
		cartSteps.pay();
		
	}
	
	@After
	public void saveTestData() {
	}

}
