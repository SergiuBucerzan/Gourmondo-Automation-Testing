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

import com.pages.frontend.CheckoutDeliveryAddressPage;
import com.steps.frontend.CartSteps;
import com.steps.frontend.CategorySteps;
import com.steps.frontend.CheckoutDeliveryAddressSteps;
import com.steps.frontend.CustomerRegistrationSteps;
import com.steps.frontend.HeaderSteps;
import com.steps.frontend.HomePageSteps;
import com.steps.frontend.LoginSteps;
import com.steps.frontend.ProductListingSteps;
import com.test.BaseTest;
import com.tools.constants.ProjectResourcesConstants;
import com.tools.models.frontend.CartEntryModel;
import com.tools.models.frontend.CustomerAccountModel;
import com.tools.models.frontend.CustomerAddressModel;
import com.tools.models.frontend.ProductModel;
import com.tools.mongo.MongoConnector;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith (SerenityRunner.class)
public class RegularCheckoutTest extends BaseTest{
	
	final static Logger logger = Logger.getLogger(RegularCheckoutTest.class);
	
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
	
	@Steps
	public CheckoutDeliveryAddressSteps checkoutDeliveryAddressSteps;
	
	@Steps
	public CustomerRegistrationSteps customerRegistrationSteps;
	 
	public CustomerAccountModel customerAccountModel = new CustomerAccountModel();
	
	public CustomerAddressModel customerAddressModel = new CustomerAddressModel();
	
	public List<ProductModel> productModelList = new ArrayList<>();
	
	public ProductModel productModel = new ProductModel();
	
	public List<CartEntryModel> cartEntryModelList = new ArrayList<>();
	
//	public List<WebElementFacade> productList;
	
//	public List<WebElementFacade> availableProductsList;
	
	public List<String> products = new ArrayList<>();
	
	public double price = 0.0;
	
	public String message = "";
	
	public double cartCalculatedTotal = 0.0;
	
	public double cartValueAsDisplayed = 0.0;
	
	public int noOfProductsInCart= 0;
	
	@Before
	public void setUp() {
		
		Properties prop = new Properties();
		InputStream inputStream = null;
		
		try {
			inputStream = new FileInputStream(ProjectResourcesConstants.SERVER  + BaseTest.getShop() + File.separator + "checkout" + File.separator + getClass().getSimpleName() + ".properties");
			prop.load(inputStream);
			customerAccountModel.setEmailAddress(prop.getProperty("email"));
			customerAccountModel.setPassword(prop.getProperty("password"));
			products.add(prop.getProperty("product1"));
//			products.add(prop.getProperty("product2"));
			message = prop.getProperty("successMessage");
			customerAddressModel.setFirstName(prop.getProperty("firstName"));
			customerAddressModel.setLastName(prop.getProperty("lastName"));
			customerAddressModel.setStreetName(prop.getProperty("streetName"));
			customerAddressModel.setStreetNumber(prop.getProperty("streetNumber"));
			customerAddressModel.setZipCode(prop.getProperty("zipCode"));
			customerAddressModel.setTown(prop.getProperty("town"));
			customerAddressModel.setPhoneNumber(prop.getProperty("phoneNumber"));
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
		
		
	    //go to product listing page randomly
		headerSteps.goToHomePage();
		
		for(String product: products) {
			homePageSteps.searchKeyword(product);
			productModel = productListingSteps.addProductToCart();
			productListingSteps.validatePopupSuccess(message);
			productModelList.add(productModel);
		}
		
		price = productListingSteps.calculatePriceOfAddedProducts(productModelList);

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
		checkoutDeliveryAddressSteps.fillInCustomerAddressForm(customerAddressModel);
	}

	@After
	public void saveTestData() {
	}

}
