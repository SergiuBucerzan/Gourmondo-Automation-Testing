package com.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class AbstractPage extends PageObject {

	final static Logger logger = Logger.getLogger(AbstractPage.class);
	
	public WebElement waitForElementByCssLocator(String cssLocator) {
		return (new WebDriverWait(getDriver(), 20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssLocator)));
	}
	
	public List<WebElement> waitForElementsByCssLocator(String cssLocator) {
		return (new WebDriverWait(getDriver(), 20))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssLocator)));
	}

	public void scrollToPageBottom() {
		((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,document.body.scrollHeight)");
		waitABit(5000);
	}

	public void waitForPageToLoad() {
		int retry = 0;

		String response = "";
		do {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// System.out.println("wait 1");
			response = String.valueOf(((JavascriptExecutor) getDriver()).executeScript("return document.readyState"));
			logger.info("response: " + response);
			retry++;
		} while (retry <= 4 && response.equals("complete") != true);
	}  
}
