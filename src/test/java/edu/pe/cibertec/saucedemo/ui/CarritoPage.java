package edu.pe.cibertec.saucedemo.ui;

import java.util.Locale;

public class CarritoPage {

    public static final String CART_BADGE = "[data-test='shopping-cart-badge']";
    public static final String CART_LINK = "[data-test='shopping-cart-link']";
    public static final String CART_ITEM_NAMES = "[data-test='inventory-item-name']";
    public static final String CONTINUE_SHOPPING_BUTTON = "[data-test='continue-shopping']";

    public static String addToCartButton(String productName) {
        return "[data-test='add-to-cart-" + slugOf(productName) + "']";
    }

    public static String removeFromCartButton(String productName) {
        return "[data-test='remove-" + slugOf(productName) + "']";
    }

    private static String slugOf(String productName) {
        return productName.toLowerCase(Locale.ROOT).replace(" ", "-");
    }

    private CarritoPage() {}

}
