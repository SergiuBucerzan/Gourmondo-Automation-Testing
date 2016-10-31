package com.steps.frontend;

import java.util.List;

import com.steps.AbstractSteps;
import com.tools.models.CartEntryModel;

public class CartSteps extends AbstractSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void selectProductsFromCart() {
		getCartPAge().selectProductsFromCart();
	}

	public void deleteSelectedItems() {
		getCartPAge().deleteSelectedItems();
	}

	public void goToHomePage() {
		getCartPAge().goToHomePage();
	}

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

	public void validateCartEntryTotal(List<CartEntryModel> productList) {
		getCartPAge().validateCartEntryTotal(productList);
	}

	public void validateCartTotal(double cartCalculatedTotal, double cartTotal) {
		getCartPAge().validateCartTotal(cartCalculatedTotal, cartTotal);
	}

	public void validateTotalCartAndTotalValueOfAddedProducts(double addedProductsTotal, double cartTotal) {
		getCartPAge().validateTotalCartAndTotalValueOfAddedProducts(addedProductsTotal, cartTotal);
	}

	public void validateNoOfAddedProductsWithNoOfCartProducts(int addedProducts, int cartProducts) {
		getCartPAge().validateNoOfAddedProductsWithNoOfCartProducts(addedProducts, cartProducts);
	}

}
