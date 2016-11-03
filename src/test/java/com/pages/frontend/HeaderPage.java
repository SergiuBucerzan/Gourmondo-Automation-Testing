package com.pages.frontend;

import com.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.By;

public class HeaderPage extends AbstractPage{

	public void goToHomePage() {
		getDriver().findElement(By.cssSelector("div.logo a")).click();;
	}
	
	public void goToCart() {
		getDriver().findElement(By.cssSelector("div.miniCart a")).click();;
	}
}
