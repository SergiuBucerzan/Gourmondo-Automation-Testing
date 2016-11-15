package com.steps.frontend;

import java.util.List;

import com.steps.AbstractSteps;
import com.tools.models.frontend.ProductModel;

import net.thucydides.core.annotations.Step;

public class SearchResultsSteps extends AbstractSteps{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Step
	public List<ProductModel> getProductList() {
		return getSearchResultsPage().getProductList();
	}
	
	@Step
	public void validateSearchResultsProducts(List<ProductModel> productSearchList) {
		getSearchResultsPage().validateSearchResultsProducts(productSearchList);
	}

}
