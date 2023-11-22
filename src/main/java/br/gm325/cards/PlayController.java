package br.gm325.cards;

import static br.gm325.cards.App.deck;
import static br.gm325.cards.FristOpenController.changeScene;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlayController {

    boolean allReadyShowQuestion = false;
    int page = 0;
    int index = 0;
    static boolean fristRun = true;

    @FXML
    private Button backButton;

    @FXML
    private Text changeText;

    @FXML
    private Button exitButton;

    @FXML
    private Button nextButton;

    @FXML
    private Text numberText;

    @FXML
    private Text tipText;

    @FXML
    void back(ActionEvent event) {
        if (index >= 0) {
        } else {
            index--;
            backButton.setDisable(true);
        }
    }

    @FXML
    public void initialize() {
        tipText.setText("Number of Cards");
        numberText.setText(page + " / " + deck.size());

        changeText.setText(deck.getPergunta(page));
        changeText.setOpacity(1);

        allReadyShowQuestion = true;

        backButton.setDisable(false);
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        changeScene(event, "home.fxml");
    }

    @FXML
    void next(ActionEvent event) throws IOException {

        if (page + 1 == deck.size()) {
            changeScene(event, "finish.fxml");
        }

        if (allReadyShowQuestion) {
            backButton.setDisable(false);
            changeText.setText(deck.getResposta(index));
            numberText.setText((page + 1) + " / " + deck.size());
            index++;
            page++;
            allReadyShowQuestion = false;
        } else {
            backButton.setDisable(false);
            changeText.setText(deck.getPergunta(page));
            numberText.setText(page + " / " + deck.size());
            allReadyShowQuestion = true;
        }
    }

}
