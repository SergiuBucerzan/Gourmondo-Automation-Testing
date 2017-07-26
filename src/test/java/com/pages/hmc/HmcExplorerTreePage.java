package com.pages.hmc;

import java.util.List;

import org.openqa.selenium.By;

import com.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HmcExplorerTreePage extends AbstractPage {
	

	@FindBy(css = "table.content_table")
	private WebElementFacade hmcCategoryTree;
	
	
	public void selectHmcCategory(String category) {
		List<WebElementFacade> categoryList = hmcCategoryTree.thenFindAll(By.cssSelector("tr[id*='Tree/GenericExplorerMenuTreeNode[']"));
		for (WebElementFacade categoryItem : categoryList) {
			if (categoryItem.find(By.cssSelector("td:nth-child(2)")).getText().contentEquals(category)) {
				categoryItem.click();
				break;
			}
		}
		
	}
	
	public void selectHmcSubCategory(String subcategory) {
		List<WebElementFacade> subcategoryList = hmcCategoryTree.thenFindAll(By.cssSelector("tr[id*='Tree/GenericLeafNode[']"));
		for (WebElementFacade subcategoryItem : subcategoryList) {
			if (subcategoryItem.find(By.cssSelector("td:nth-child(2)")).getText().contentEquals(subcategory)) {
				subcategoryItem.click();
				break;
			}
		}
		
	}

}
