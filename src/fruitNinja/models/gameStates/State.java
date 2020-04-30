package fruitNinja.models.gameStates;

public abstract class State {
    GameState gameState;
    public State(GameState gameState){
        this.gameState = gameState;
    }
    public abstract void clickPause();
    public abstract void clickPlay();
}
