package fruitNinja.views.pages;

import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.views.guiUtils.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Optional;

public class PauseDialogController {
    public  Button quitBtn;
    private Player player;

    Navigation navigation=new Navigation();

    public PauseDialogController() {
        this.player = PlayerSingleton.getInstance();
    }

    public void show(Window window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PauseDialog.fxml"));
        Scene scene = new Scene(root,700,600);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.initOwner(window);
        stage.setScene(scene);
        stage.show();

        }


    public void quitBtnClicked(ActionEvent actionEvent) {
        Navigation navigation1=navigation;
            Stage stage = (Stage)quitBtn.getScene().getWindow();
            navigation.showGameDonePage(stage);
    }

    public void restartBtnClicked(ActionEvent actionEvent) {
    }

    public void resumeBtnClicked(ActionEvent actionEvent) {
    }

}
