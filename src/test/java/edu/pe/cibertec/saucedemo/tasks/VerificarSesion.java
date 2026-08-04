package edu.pe.cibertec.saucedemo.tasks;

import com.microsoft.playwright.Page;
import edu.pe.cibertec.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VerificarSesion {

    private static final String LOGGED_IN_TITLE = "Products";

    public static Performable sigueActiva() {
        return Task.where("{0} verifies the session is still active",
                actor -> {
                    Page page = BrowseTheWebWithPlaywright.as(actor).getCurrentPage();
                    assertThat(page.locator(InventoryPage.MENU_BUTTON)).isVisible();
                    assertThat(page.locator(InventoryPage.PAGE_TITLE)).containsText(LOGGED_IN_TITLE);
                });
    }

    private VerificarSesion() {}

}
