package com.test.tests.checkout;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import com.tools.models.CustomerAccountModel;
import com.tools.mongo.MongoConnector;
import com.tools.mongo.reader.MongoReader;

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
		headerSteps.goToHomePage();	
		homePageSteps.getRandomCategory();
		categorySteps.getRandomSubCategory();
	}
	
	@After
	public void saveTestData() {
		
	}

}
