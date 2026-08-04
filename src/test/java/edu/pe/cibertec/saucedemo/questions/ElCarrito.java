package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;

import java.util.List;

public class ElCarrito {

    public static Question<String> contador() {
        return Question.about("the cart counter")
                .answeredBy(actor -> Text.of(Target.the("Shopping cart badge")
                        .locatedBy(CarritoPage.CART_BADGE)).answeredBy(actor));
    }

    public static Question<List<String>> productos() {
        return Question.about("the products in the cart")
                .answeredBy(actor -> Text.ofEach(Target.the("Cart item names")
                        .locatedBy(CarritoPage.CART_ITEM_NAMES)).answeredBy(actor));
    }

    private ElCarrito() {}

}
