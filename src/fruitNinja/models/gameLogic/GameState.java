package fruitNinja.models.gameLogic;

import java.util.Timer;

public class GameState {

    private int wave;
    private int life = 3;
    private Timer timer; // TO BE IMPLEMENTED

    public int getWave() {
        return wave;
    }

    public void setWave(int wave) {
        this.wave = wave;
    }
    public void incWave() {this.wave += 1;};

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}