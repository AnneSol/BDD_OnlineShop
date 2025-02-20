package orderService.steps;

import orderService.OrderService;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class OrderSteps {
    private OrderService orderService = new OrderService();

    @Given("der Kunde ist auf der Produktseite von {string}")
    public void kundeIstAufProduktseite(String produkt) {
        System.out.println("Kunde befindet sich auf der Produktseite: " + produkt);
    }

    @When("er auf {string} klickt")
    public void erKlicktAuf(String button) {
        if (button.equals("In den Warenkorb")) {
            orderService.addToCart("Laptop");
        }
    }

    @Then("ist das Produkt im Warenkorb sichtbar")
    public void produktImWarenkorb() {
        assertTrue(orderService.isProductInCart("Laptop"));
    }

    @Given("der Kunde hat ein Produkt im Warenkorb")
    public void kundeHatProduktImWarenkorb() {
        orderService.addToCart("Laptop");
    }

    @When("er zur Kasse geht und seine Lieferadresse eingibt")
    public void kundeGibtAdresseEin() {
        // Hier könnte man eine Lieferadresse setzen
    }

    @When("er die Bestellung bestätigt")
    public void kundeBestätigtBestellung() {
        orderService.placeOrder("Beispielstraße 123, 12345 Berlin");
    }

    @Then("sieht er eine Bestätigungsmeldung {string}")
    public void bestellbestätigung(String nachricht) {
        assertEquals(nachricht, orderService.getConfirmationMessage());
    }
}