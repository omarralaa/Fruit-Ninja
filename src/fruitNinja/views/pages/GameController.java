package fruitNinja.views.pages;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class GameController {
    @FXML
    private Button pauseButton;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label timerLabel;
    @FXML
    private Label livesLabel;


    public void pauseButtonClicked(ActionEvent actionEvent) throws IOException {
        PauseDialogController pauseDialog = new PauseDialogController();
        pauseDialog.show(scoreLabel.getScene().getWindow());
    }
}
