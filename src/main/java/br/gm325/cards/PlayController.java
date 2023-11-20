package br.gm325.cards;

import static br.gm325.cards.App.deck;
import static br.gm325.cards.App.loadFXML;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class PlayController {

    private Stage stage;
    private Parent root;
    private Scene scene;

    int page = 0;
    int index = 0;
    boolean fristRun = true;

    @FXML
    private Button backButton;

    @FXML
    private Button nextButton;

    @FXML
    private Text numberText;

    @FXML
    private Button returnButton;

    @FXML
    private TextArea answerTextArea;

    @FXML
    private TextArea questionTextArea;

    @FXML
    private Text tipText;

    @FXML
    void backButtonAction(ActionEvent event) {

    }

    @FXML
    void nextButtonAction(ActionEvent event) {
        if (fristRun) {
            numberText.setText("NUMBER PAGE");
            tipText.setText(page + "/" + deck.size());

            for (int i = 0; i < 10; i++) {
                deck.add("P" + i, "R" + i);
            }

            questionTextArea.setText(deck.getPergunta(index));

            fristRun = false;
        } else {
            if (page < deck.size()) {
                page++;
                tipText.setText(page + "/" + deck.size());
                index++;
                questionTextArea.setText(deck.getPergunta(index));
            }

        }

    }

    @FXML
    void returnButtonAction(ActionEvent event) throws IOException {
        Parent root = loadFXML("home");
        stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
