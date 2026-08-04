package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.ElCarrito;
import edu.pe.cibertec.saucedemo.tasks.AbrirElCarrito;
import edu.pe.cibertec.saucedemo.tasks.AgregarAlCarrito;
import edu.pe.cibertec.saucedemo.tasks.EliminarDelCarrito;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class CarritoStepDefinitions {

    @And("she adds the product {string} to the cart")
    public void sheAddsTheProductToTheCart(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.elProducto(productName)
        );
    }

    @And("she removes the product {string} from the cart")
    public void sheRemovesTheProductFromTheCart(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarDelCarrito.elProducto(productName)
        );
    }

    @Then("the cart icon should display {string}")
    public void theCartIconShouldDisplay(String itemCount) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElCarrito.contador(), equalTo(itemCount))
        );
    }

    @And("the cart should contain {string} and {string}")
    public void theCartShouldContain(String firstProduct, String secondProduct) {
        OnStage.theActorInTheSpotlight().attemptsTo(AbrirElCarrito.page());
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElCarrito.productos(), containsInAnyOrder(firstProduct, secondProduct))
        );
    }

    @And("the cart should only contain {string}")
    public void theCartShouldOnlyContain(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(AbrirElCarrito.page());
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElCarrito.productos(), contains(productName))
        );
    }

}
