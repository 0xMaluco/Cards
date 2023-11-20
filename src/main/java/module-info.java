module br.gm325.cards {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.gm325.cards to javafx.fxml;
    exports br.gm325.cards;
}
