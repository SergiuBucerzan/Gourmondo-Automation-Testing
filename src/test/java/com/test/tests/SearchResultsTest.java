package com.test.tests;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.AbstractSteps;
import com.steps.frontend.HomePageSteps;
import com.steps.frontend.SearchResultsSteps;
import com.test.BaseTest;
import com.tools.constants.MongoConstants;
import com.tools.models.ProductModel;
import com.tools.mongo.reader.MongoReader;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith (SerenityRunner.class)
public class SearchResultsTest extends BaseTest {
	
	final static Logger logger = Logger.getLogger(BaseTest.class);
	
	@Steps
	public SearchResultsSteps serchResults;
	
	@Steps
	public HomePageSteps homePage;
	
	@Steps
	public AbstractSteps abstractSteps;
	
	public String keyword= "";
	
	@Before
	public void setup() {
		keyword= "champagne";
	}

	@Test
	public void searchTest() {
		homePage.goToUrl(MongoReader.getGourmondoURL());
		homePage.searchKeyword(keyword);
		List <ProductModel> productSearchList = serchResults.getProductList();
		serchResults.validateSearchResultsProducts(productSearchList);
	}
}
