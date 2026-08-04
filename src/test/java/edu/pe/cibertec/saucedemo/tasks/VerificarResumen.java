package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.questions.ElCheckout;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class VerificarResumen {

    public static Performable conItemTotal(String itemTotal) {
        return Task.where("{0} verifies the order summary shows item total '" + itemTotal + "'",
                actor -> actor.should(
                        seeThat(ElCheckout.itemTotal(), containsString(itemTotal))
                )
        );
    }

    private VerificarResumen() {}

}
