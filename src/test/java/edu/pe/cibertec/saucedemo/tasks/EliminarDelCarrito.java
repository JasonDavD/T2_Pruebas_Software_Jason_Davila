package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class EliminarDelCarrito {

    public static Performable elProducto(String productName) {
        return Task.where("{0} removes '" + productName + "' from the cart",
                Click.on(Target.the("Remove button for " + productName)
                        .locatedBy(CarritoPage.removeFromCartButton(productName))));
    }

    private EliminarDelCarrito() {}

}
