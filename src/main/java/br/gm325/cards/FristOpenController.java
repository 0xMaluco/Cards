package br.gm325.cards;

import static br.gm325.cards.App.deck;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FristOpenController {

    int inicialDeckSize = (int) deck.size();
    int finalDeckSize;
    Dialog dialog = new Dialog();

    @FXML
    private Button addFristCardButton;

    @FXML
    private Button importDeckButton;

    @FXML
    void addFristCardAction(ActionEvent event) {

        dialog.setTitle("Add Card");
        dialog.setHeaderText("Add a card to your deck");

        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        dialog.getDialogPane().setContent(createAddCardDialog());

        dialog.show();

    }

    private Node createAddCardDialog() {
        GridPane gridPane = new GridPane();

        TextField questionTextField = new TextField();
        TextField answerTextField = new TextField();
        Button addButton = new Button("Add");

        addButton.setOnAction((ActionEvent event) -> {
            deck.add(questionTextField.getText(), answerTextField.getText());
            System.out.println(deck.size());
            dialog.close();

        });

        gridPane.add(new Label("Question: "), 0, 0);
        gridPane.add(new Label("Answer: "), 0, 1);
        gridPane.add(questionTextField, 1, 0);
        gridPane.add(answerTextField, 1, 1);
        gridPane.add(addButton, 1, 2);
        return gridPane;
    }

    @FXML
    void importDeckAction(ActionEvent event) {

    }

}
