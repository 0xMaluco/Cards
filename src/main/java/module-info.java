module br.gm325.cards {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires java.base;

    opens br.gm325.cards to javafx.fxml;
    exports br.gm325.cards;
}
