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

        System.out.println("page: " + page);
        System.out.println("index: " + index);

        if (index >= 1) {
            page--;
            index--;
            allReadyShowQuestion = !allReadyShowQuestion;

            if (allReadyShowQuestion) {
                backButton.setDisable(false);
                changeText.setText(deck.getPergunta(page));
                numberText.setText(page + " / " + deck.size());
            } else {
                backButton.setDisable(false);
                changeText.setText(deck.getResposta(index));
                numberText.setText((page + 1) + " / " + deck.size());
            }
        } else if (index < 0) {
            backButton.setDisable(true);
        }
    }

    @FXML
    public void initialize() {

        System.out.println("page: " + page);
        System.out.println("index: " + index);

        tipText.setText("Number of Cards");
        numberText.setText(page + " / " + deck.size());

        changeText.setText(deck.getPergunta(page));
        changeText.setOpacity(1);

        allReadyShowQuestion = true;

        backButton.setDisable(true);
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        changeScene(event, "home.fxml");
    }

    @FXML
    void next(ActionEvent event) throws IOException {
        System.out.println("page: " + page);
        System.out.println("index: " + index);

        if (page == deck.size()) {
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
