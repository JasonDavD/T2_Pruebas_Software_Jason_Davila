package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;

public class ThePageTitle {
    public static Question<String> displayed() {
        return Question.about("the page title")
                .answeredBy(actor -> Text.of(Target.the("Page title")
                        .locatedBy(InventoryPage.PAGE_TITLE)).answeredBy(actor));
    }
}
