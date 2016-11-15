package com.pages.frontend;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pages.AbstractPage;
import com.test.BaseTest;
import com.tools.models.frontend.ProductModel;
import com.tools.mongo.reader.MongoReader;
import com.tools.utils.StringUtils;


public class SearchResultsPage extends AbstractPage {
	final static Logger logger = Logger.getLogger(BaseTest.class);
	String serchResultsContainer = "div.product-listing";
	
	public List<ProductModel> getProductList() {
		List<ProductModel> productResults = new ArrayList<>();
		
		waitForPageToLoad();
		WebElement productListContainer = waitForElementByCssLocator(serchResultsContainer);
		List<WebElement> productList = productListContainer.findElements(By.cssSelector("div.description-wrapper div.product"));
		
		for (WebElement result : productList) {
			ProductModel product = new ProductModel();
			String price = StringUtils.cleanPrice(result.findElement(By.cssSelector("div.price")).getText());
			String name = result.findElement(By.cssSelector("span[itemprop='name']")).getText();
			
			product.setName(name);
			product.setPrice(price);
			productResults.add(product);
		}
		
		return productResults;
	}
	
	public void validateSearchResultsProducts(List<ProductModel> productSearchList) {
		
		for(ProductModel item : productSearchList) {
			logger.info("name: " + item.getName());
      		Assert.assertTrue("No name found!", (!item.getName().isEmpty()));
      		logger.info("price: " + item.getPrice());
      		Assert.assertTrue("No price found!", (!item.getPrice().isEmpty()));
		}
		
	}

}
