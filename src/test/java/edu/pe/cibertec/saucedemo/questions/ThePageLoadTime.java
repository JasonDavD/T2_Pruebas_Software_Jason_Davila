package edu.pe.cibertec.saucedemo.questions;

import net.serenitybdd.screenplay.Question;

public class ThePageLoadTime {

    public static final String MEMORY_KEY = "pageLoadTimeMillis";

    public static Question<Long> inMilliseconds() {
        return Question.about("the page load time in milliseconds")
                .answeredBy(actor -> actor.recall(MEMORY_KEY));
    }

    private ThePageLoadTime() {}

}
