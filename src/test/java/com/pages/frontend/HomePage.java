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
	WebElementFacade searchBox;
	
	@FindBy (css = "button.search-button")
	WebElementFacade submitButton;
	
	@FindBy (css = "div#navbar")
	WebElementFacade categoryContainer;
	
	@FindBy(css="div.logout a:nth-child(1)")
	WebElementFacade logout;
	
	public void goToLogin() {
		login.click();
	}
	
	public void logout() {
		logout.click();
	}
	
	public void inputKeyword(String keyword) {
		searchBox.sendKeys(keyword);
	}
	
	public void search() {
		submitButton.click();
	}
	
	public void getRandomCategory() {
		categoryContainer.waitUntilVisible();
		List<WebElementFacade> listOfCategories = categoryContainer.thenFindAll(By.cssSelector("ul li.root-category"));
		Random random = new Random();
		if (listOfCategories.size() > 0) {
			WebElementFacade category = listOfCategories.get(random.nextInt(listOfCategories.size()));
			logger.info("Selected category is: " + category.getText());
			category.click();
		}else 
			logger.info("No category found.");
		
	}
	

}
