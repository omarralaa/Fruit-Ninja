package fruitNinja.models.gameModes;

import java.util.Timer;

public class ZenStrategy implements GameStrategy {
    @Override
    public void initGame() {

    }

    @Override
    public void bombBehaviour() {

    }

    @Override
    public boolean gameEndCondition() {
        return false;
    }

    /*
    private Timer timer;
    private GamePlayService gamePlayService;

    public ZenStrategy()
    {
        timer = new Timer();
        gamePlayService = new GamePlayService();
    }

    private void setTimer()
    {
        //timer.schedule(() -> gamePlayService.showGameOver(), 2*60*1000);
    }

    @Override
    public void bombBehaviour() {
        
    }

     */
}
