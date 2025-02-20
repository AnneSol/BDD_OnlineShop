Feature: Produktbestellung

  Scenario: Produkt in den Warenkorb legen
    Given der Kunde ist auf der Produktseite von "Laptop"
    When er auf "In den Warenkorb" klickt
    Then ist das Produkt im Warenkorb sichtbar

  Scenario: Bestellung abschließen
    Given der Kunde hat ein Produkt im Warenkorb
    When er zur Kasse geht und seine Lieferadresse eingibt
    And er die Bestellung bestätigt
    Then sieht er eine Bestätigungsmeldung "Danke für Ihre Bestellung!"
