package com.steps.frontend;

import java.util.List;

import com.steps.AbstractSteps;
import com.tools.models.CartEntryModel;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class CartSteps extends AbstractSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@StepGroup
	public void deleteCart() {
		selectProductsFromCart();
		deleteSelectedItems();
	}
	
	@Step
	public void selectProductsFromCart() {
		getCartPAge().selectProductsFromCart();
	}

	@Step
	public void deleteSelectedItems() {
		getCartPAge().deleteSelectedItems();
	}

	@Step
	public void pay() {
		getCartPAge().pay();
	}

	public List<CartEntryModel> getCartProducts() {
		return getCartPAge().getCartProducts();

	}

	public double calculateCartTotal(List<CartEntryModel> productList) {
		return getCartPAge().calculateCartTotal(productList);
	}

	public double getCartTotal() {
		return getCartPAge().getCartTotal();
	}

	// VALIDATIONS

	@Step
	public void validateCartEntryTotal(List<CartEntryModel> productList) {
		getCartPAge().validateCartEntryTotal(productList);
	}

	@Step
	public void validateCartTotal(double cartCalculatedTotal, double cartTotal) {
		getCartPAge().validateCartTotal(cartCalculatedTotal, cartTotal);
	}

	@Step
	public void validateTotalCartAndTotalValueOfAddedProducts(double addedProductsTotal, double cartTotal) {
		getCartPAge().validateTotalCartAndTotalValueOfAddedProducts(addedProductsTotal, cartTotal);
	}

	@Step
	public void validateNoOfAddedProductsWithNoOfCartProducts(int addedProducts, int cartProducts) {
		getCartPAge().validateNoOfAddedProductsWithNoOfCartProducts(addedProducts, cartProducts);
	}

}
