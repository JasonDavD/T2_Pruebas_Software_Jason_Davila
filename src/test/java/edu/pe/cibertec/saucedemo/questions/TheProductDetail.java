package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.ProductDetailPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;
import net.serenitybdd.screenplay.playwright.questions.Visibility;

public class TheProductDetail {
    public static Question<String> name() {
        return Question.about("the product name")
                .answeredBy(actor -> Text.of(Target.the("Product name")
                        .locatedBy(ProductDetailPage.PRODUCT_NAME)).answeredBy(actor));
    }
    public static Question<String> price() {
        return Question.about("the product price")
                .answeredBy(actor -> Text.of(Target.the("Product price")
                        .locatedBy(ProductDetailPage.PRODUCT_PRICE)).answeredBy(actor));
    }

    public static Question<Boolean> addToCartButtonIsVisible() {
        return Visibility.of(Target.the("Add to cart button")
                .locatedBy(ProductDetailPage.ADD_TO_CART_BUTTON));
    }
}
