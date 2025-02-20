package orderService;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<String> cart = new ArrayList<>();
    private String confirmationMessage = "";

    public void addToCart(String product) {
        cart.add(product);
    }

    public boolean isProductInCart(String product) {
        return cart.contains(product);
    }

    public void placeOrder(String address) {
        if (cart.isEmpty()) {
            confirmationMessage = "Warenkorb ist leer! Bestellung nicht möglich.";
        } else if (address == null || address.isEmpty()) {
            confirmationMessage = "Bitte geben Sie eine Lieferadresse ein.";
        } else {
            confirmationMessage = "Danke für Ihre Bestellung!";
        }
    }

    public String getConfirmationMessage() {
        return confirmationMessage;
    }
}
