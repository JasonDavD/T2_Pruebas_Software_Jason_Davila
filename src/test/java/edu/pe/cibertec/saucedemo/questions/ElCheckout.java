package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;
import net.serenitybdd.screenplay.playwright.questions.Visibility;

public class ElCheckout {

    public static Question<String> itemTotal() {
        return Question.about("the order summary item total")
                .answeredBy(actor -> Text.of(Target.the("Item total label")
                        .locatedBy(CheckoutPage.ITEM_TOTAL_LABEL)).answeredBy(actor));
    }

    public static Question<String> mensajeDeConfirmacion() {
        return Question.about("the confirmation message")
                .answeredBy(actor -> Text.of(Target.the("Confirmation header")
                        .locatedBy(CheckoutPage.CONFIRMATION_HEADER)).answeredBy(actor));
    }

    public static Question<Boolean> formularioEsVisible() {
        return Visibility.of(Target.the("Checkout first name field")
                .locatedBy(CheckoutPage.FIRST_NAME_FIELD));
    }

    private ElCheckout() {}

}
