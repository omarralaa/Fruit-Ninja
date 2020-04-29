package fruitNinja.controllers;

import fruitNinja.data.repositories.ScoreRepository;
import fruitNinja.models.gameLogic.GamePlayActions;
import fruitNinja.models.gameModes.ModeContext;
import fruitNinja.models.gameModes.StrategyFactory;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.gameModes.Stratgies.GameStrategy;
import fruitNinja.models.gameStates.Game;
import fruitNinja.models.guiUpdate.*;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.models.users.Score;
import fruitNinja.views.pages.GameView;
import fruitNinja.views.pages.PauseDialogController;
import javafx.stage.Stage;
import java.io.IOException;


public class GameController {

    private ScoreRepository scoreRepository = new ScoreRepository();
    private StrategyFactory strategyFactory = new StrategyFactory();
    private StrategyType strategyType;
    private Game gameState = new Game();

    private GameView gameView;

    public GameController(GameView gameView, StrategyType strategyType)
    {
        this.gameView = gameView;
        this.strategyType = strategyType;
        setEventHandlers();
        setSubscribers();
        startGame(strategyType);
    }

    private void pause(){
        gameState.clickPause();
        GamePlayActions.isPaused = true;

        scoreRepository.addScore(gameView.getScoreLabel().getText(),
                PlayerSingleton.getInstance().getUsername(),strategyType);

        Score score = new Score(strategyType, gameView.getScoreLabel().getText());
        PlayerSingleton.getInstance().setCurrentScore(Integer.parseInt(gameView.getScoreLabel().getText()));

        PauseDialogController pauseDialog;
        pauseDialog = new PauseDialogController(gameState,strategyType,score);

        try {
            pauseDialog.show(gameView.getScoreLabel().getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startGame(StrategyType strategyType)
    {
        GameStrategy strategy = strategyFactory.createStrategy(strategyType);
        ModeContext modeContext = new ModeContext(strategy);
        modeContext.startGame(gameView.getCanvas());
    }

    private void setSubscribers()
    {
        ControlsUpdater controlsUpdater = new ControlsUpdater();
        controlsUpdater.eventManager.subscribe("sliceOrdinary", new UpdateScoreListener(gameView.getScoreLabel()));
        controlsUpdater.eventManager.subscribe("updateTimer", new UpdateTimerListener(gameView.getTimerLabel()));
        controlsUpdater.eventManager.subscribe("sliceFatal", new SliceBombListener((Stage) gameView.getScoreLabel().getScene().getWindow(),this.strategyType));
        controlsUpdater.eventManager.subscribe("sliceDangerous", new DangerousBombListener(gameView.getScoreLabel()));
        controlsUpdater.eventManager.subscribe("sliceCombo", new ComboLabelListener(gameView.getComboLabel()));
        controlsUpdater.eventManager.subscribe("fruitFellUnsliced", new LivesLabelListener(gameView.getLivesLabel()));
        ControlsUpdaterSingleton.setSingleton(controlsUpdater);
    }

    private void setEventHandlers()
    {
        gameView.addPauseButtonListener(event -> pause());
    }
}