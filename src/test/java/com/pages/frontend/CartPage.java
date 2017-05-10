package com.pages.frontend;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import com.pages.AbstractPage;
import com.tools.models.frontend.CartEntryModel;
import com.tools.mongo.reader.MongoReader;
import com.tools.utils.StringUtils;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CartPage extends AbstractPage {

	final static Logger logger = Logger.getLogger(CartPage.class);

	@FindBy(css = "div#cartItems")
	WebElementFacade cartItems;

	@FindBy(css = "button#checkoutButtonBottom")
	WebElementFacade payButton;

	@FindBy(css = "div#cart-page-subtotal p.value span span")
	WebElementFacade totalPrice;

	@FindBy(css = "button#remove-selected-items-button")
	WebElementFacade deleteSelectedItemsButton;
	
	@FindBy(css = "button#checkout-empty-cart-button")
	WebElementFacade deleteCart;

	public void selectProductsFromCart() {
		if (deleteSelectedItemsButton.isVisible()) {
			List<WebElementFacade> cartList = cartItems.thenFindAll(By.cssSelector("div.product-entry div.index-wrapper label"));
			for (WebElementFacade item : cartList) {
				item.click();
			}
		}
	}

	public void deleteSelectedItems() {
		if (deleteSelectedItemsButton.isVisible()) {
			deleteSelectedItemsButton.click();
			logger.info("Cart was deleted");
		}
	}
	
	public void deleteCartItems() {
		if (cartItems.isVisible()) {
			waitABit(2000);
			deleteCart.click();
			System.out.println("Item/s removed from cart");
		} else  {			
			System.out.println("Cart is empty!");			
		}
	}

	public void pay() {
		payButton.click();
	}

	public List<CartEntryModel> getCartProducts() {
		List<CartEntryModel> productList = new ArrayList<>();
		List<WebElementFacade> itemsList = cartItems.thenFindAll(By.cssSelector("li.product-entry"));
		
		for (WebElementFacade item : itemsList) {
			CartEntryModel product = new CartEntryModel();
			product.setName(item.find(By.cssSelector("div.product-details a")).getText());
			product.setPrice(StringUtils.cleanPrice(item.find(By.cssSelector("div.product-details span.product-price")).getText()));
			product.setTotalPrice(StringUtils.cleanPrice(item.find(By.cssSelector("div.amount-price")).getText()));
			product.setQuantity(item.find(By.cssSelector("div.quantity input[name='initialQuantity']")).getAttribute("value"));

			productList.add(product);
		}

		return productList;
	}
	
	public int getTotalNumberOfProducts(List<CartEntryModel> productList) {
		int no = 0;
		for(CartEntryModel product: productList) {
			no += Integer.valueOf(product.getQuantity());
		}
		
		return no;
	}

	public double calculateCartTotal(List<CartEntryModel> productList) {
		BigDecimal cartTotal = new BigDecimal("0.0");
		
		for (CartEntryModel product : productList) {
			System.out.println(product.getTotalPrice());
			BigDecimal productPrice = new BigDecimal(Double.valueOf(product.getTotalPrice()));
			cartTotal = cartTotal.add(productPrice);
		}

		return cartTotal.doubleValue();
	}

	public double getCartTotal() {
		double cartValue = Double.valueOf(StringUtils.cleanPrice(totalPrice.getText()));

		return cartValue;
	}

	// VALIDATIONS

	public void validateCartEntryTotal(List<CartEntryModel> productList) {
		for (CartEntryModel entry : productList) {			
//			BigDecimal productPrice = new BigDecimal(Double.valueOf(entry.getPrice()));
			double productPrice = Double.valueOf(entry.getPrice()) * Double.valueOf(entry.getQuantity());
			double entryPrice = Double.valueOf(entry.getTotalPrice());
			logger.info("cart entry validation: " + productPrice + "----------" + entryPrice);
			Assert.assertTrue("Product price does not match total product price", productPrice == entryPrice);
		}
	}

	public void validateCartTotal(double cartCalculatedTotal, double cartTotal) {
		logger.info("cart total validation: " + cartCalculatedTotal + "----------" + cartTotal);
		Assert.assertTrue("Total cart value does not match with calculated total value of entries",
				cartCalculatedTotal == cartTotal);
	}

	public void validateTotalCartAndTotalValueOfAddedProducts(double addedProductsTotal, double cartTotal) {
		logger.info("total cart and total added prod: " + cartTotal + "----------" + addedProductsTotal);
		Assert.assertTrue("Total cart value does not match with added products total value",
				addedProductsTotal == cartTotal);
	}

	public void validateNoOfAddedProductsWithNoOfCartProducts(int addedProducts, int cartProducts) {
		logger.info("no of products: " + addedProducts + "----------" + cartProducts);
		Assert.assertTrue("Number of added products does not match number of cart products",
				addedProducts == cartProducts);
	}

}
