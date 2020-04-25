package fruitNinja.views.pages;

import fruitNinja.models.audios.AudioController;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.utils.Utils;
import fruitNinja.views.guiUtils.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GameChooseController implements Initializable {
    public Button classicButton;

    private Navigation navigation = new Navigation();
    private AudioController audioController;

    public void arcadeMode(ActionEvent actionEvent) {
        audioController.stop();
        navigateToGame(StrategyType.ARCADE);
    }

    public void zenMode(ActionEvent actionEvent) {
        audioController.stop();
        navigateToGame(StrategyType.ZEN);
    }

    public void classicMode(ActionEvent actionEvent) {
        audioController.stop();
        navigateToGame(StrategyType.CLASSIC);
    }

    public void exit(ActionEvent actionEvent) {
        audioController.stop();
        navigation.showMainDashboardPage((Stage) classicButton.getScene().getWindow());
    }
    private void navigateToGame(StrategyType strategyType)
    {
        audioController.stop();
        Stage stage = (Stage)classicButton.getScene().getWindow();
        navigation.showGamePage(stage, strategyType);
    }
    public void settAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioController = new AudioController();
        audioController.start("start");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            settAudio();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}