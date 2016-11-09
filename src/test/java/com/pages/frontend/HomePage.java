package com.pages.frontend;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

import com.pages.AbstractPage;

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
	
	public void goToLogin() {
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
	

}
