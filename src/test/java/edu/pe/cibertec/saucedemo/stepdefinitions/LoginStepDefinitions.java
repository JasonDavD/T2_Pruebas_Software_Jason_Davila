package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.TheErrorMessage;
import edu.pe.cibertec.saucedemo.questions.ThePageLoadTime;
import edu.pe.cibertec.saucedemo.questions.ThePageTitle;
import edu.pe.cibertec.saucedemo.tasks.AbrirElCarrito;
import edu.pe.cibertec.saucedemo.tasks.LoginAs;
import edu.pe.cibertec.saucedemo.tasks.OpenTheLoginPage;
import edu.pe.cibertec.saucedemo.tasks.ReturnToInventory;
import edu.pe.cibertec.saucedemo.tasks.VerificarSesion;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class LoginStepDefinitions {

    @Given("{word} is on the SauceDemo login page")
    public void openLoginPage(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.whoCan(BrowseTheWebWithPlaywright.usingTheDefaultConfiguration());
        actor.attemptsTo(OpenTheLoginPage.page());
    }

    @When("she logs in with username {string} and password {string}")
    public void loginWith(String username, String password) {
        Actor actor = OnStage.theActorInTheSpotlight();
        long startedAt = System.currentTimeMillis();
        actor.attemptsTo(LoginAs.user(username).withPassword(password));
        actor.remember(ThePageLoadTime.MEMORY_KEY, System.currentTimeMillis() - startedAt);
    }

    @Then("she should be redirect to the inventory page")
    public void shouldBeRedirectedToInventoryPage() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ThePageTitle.displayed(), equalTo("Products"))
        );
    }

    @Then("she should see the page title {string}")
    public void shouldSeeThePageTitle(String pageTitle) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ThePageTitle.displayed(), equalTo(pageTitle))
        );
    }

    @Then("she should see the error message {string}")
    public void shouldSeeTheErrorMessage(String errorMessage) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheErrorMessage.displayed(), equalTo(errorMessage))
        );
    }

    @Then("she should remain on the login page")
    public void shouldRemainOnTheLoginPage() {

    }

    @Then("the page load time should be greater than {int} milliseconds")
    public void thePageLoadTimeShouldBeGreaterThan(int milliseconds) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ThePageLoadTime.inMilliseconds(), greaterThan((long) milliseconds))
        );
    }

    @And("she navigates to the cart page")
    public void sheNavigatesToTheCartPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(AbrirElCarrito.page());
    }

    @And("she navigates back to the inventory page")
    public void sheNavigatesBackToTheInventoryPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(ReturnToInventory.page());
    }

    @Then("she should still be logged in")
    public void sheShouldStillBeLoggedIn() {
        OnStage.theActorInTheSpotlight().attemptsTo(VerificarSesion.sigueActiva());
    }

}
