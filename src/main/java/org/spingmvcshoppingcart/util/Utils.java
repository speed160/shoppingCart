package org.spingmvcshoppingcart.util;

import javax.servlet.http.HttpServletRequest;

import org.spingmvcshoppingcart.model.CartInfo;

public class Utils {

	// Product in cart, stored in Session
	public static CartInfo getCartInSession(HttpServletRequest request) {
		// Get cart from session
		CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");
		// if null, create it
		if (cartInfo == null) {
			cartInfo = new CartInfo();

			// And store to Session
			request.getSession().setAttribute("myCart", cartInfo);
		}

		return cartInfo;
	}

	public static void removeCartInSession(HttpServletRequest request) {
		request.getSession().removeAttribute("myCart");
	}

	public static void storeLastOrderedCartInSession(HttpServletRequest request, CartInfo cartInfo) {
		request.getSession().setAttribute("lastOrderedCart", cartInfo);
	}

	public static CartInfo getLastOrderedCartInSession(HttpServletRequest request) {
		return (CartInfo) request.getSession().getAttribute("lastOrderedCart");

	}

}
