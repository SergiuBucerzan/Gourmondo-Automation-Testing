package com.pages.frontend;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

import com.pages.AbstractPage;
import com.test.BaseTest;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;






public class HomePage extends AbstractPage{
	
	final static Logger logger = Logger.getLogger(HomePage.class);

	@FindBy (id = "log-in")
	WebElementFacade login;
	
	@FindBy (id = "search")
	WebElementFacade serachBox;
	
	@FindBy (css = "button.search-button")
	WebElementFacade submitButton;
	
	@FindBy (id = "navbar")
	WebElementFacade categoryContainer;
	
	@FindBy (css = "div.categories-listing")
	WebElementFacade subcategoryContainer;
	
	@FindBy (css = "div#colorbox span.yes")
	WebElementFacade ageGate;
	
	public void login() {
		login.click();
	}
	
	public void inputKeyword(String keyword) {
		serachBox.sendKeys(keyword);
	}
	
	public void search() {
		submitButton.click();
	}
	
	public void getRandomCategory() {
		categoryContainer.waitUntilVisible();
		List<WebElementFacade> listOfCategories = categoryContainer.thenFindAll(By.cssSelector("ul li[class='root-category selected-category ']"));
		Random random = new Random();
		if (listOfCategories.size() > 0) {
			WebElementFacade category = listOfCategories.get(random.nextInt(listOfCategories.size()));
			logger.info("Selected category is: " + category.getText());
			category.click();
		}else 
			logger.info("No category found.");
		
	}
	
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
	
	public void confirmAge() {
		ageGate.waitUntilVisible();
		ageGate.click();
	}
}
