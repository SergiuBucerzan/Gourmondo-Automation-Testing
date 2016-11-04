package com.pages.frontend;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

import com.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;

public class CategoryPage extends AbstractPage {

	final static Logger logger = Logger.getLogger(CategoryPage.class);
	
	@FindBy (css = "div.categories-listing")
	WebElementFacade subcategoryContainer;
	
	public void getRandomSubCategory() {
		subcategoryContainer.waitUntilVisible();
		List<WebElementFacade> listOfSubCategories = subcategoryContainer.thenFindAll(By.cssSelector("div.title-wrapper a"));
		Random random = new Random();
		if (listOfSubCategories.size() > 0) {
			WebElementFacade subcategory = listOfSubCategories.get(random.nextInt(listOfSubCategories.size()));
			logger.info("Selected subcategory is: " + subcategory.getText());
			subcategory.click();
		}else 
			logger.info("No subcategory found.");
		
	}
}
