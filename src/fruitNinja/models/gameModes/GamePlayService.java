package fruitNinja.models.gameModes;

import fruitNinja.models.Difficulty;
import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.fruits.FruitFactory;
import fruitNinja.models.fruits.FruitType;
import fruitNinja.models.fruits.ordinary.OrdinaryFruitType;
import fruitNinja.models.fruits.special.SpecialFruit;
import fruitNinja.models.fruits.special.SpecialFruitType;
import fruitNinja.utils.Utils;

import java.util.ArrayList;
import java.util.TimerTask;

public class GamePlayService {

    private Utils utils;
    private FruitFactory fruitFactory;
    private int wave = 1;
    private GameStrategy gameStrategy;


    public GamePlayService()
    {
        utils = new Utils();
        fruitFactory = new FruitFactory();
    }

    public Difficulty getDifficultyByWaveNumber(int wave)
    {
        if (wave > 10) return Difficulty.HARD;
        else if (wave > 5) return Difficulty.MEDIUM;
        else return Difficulty.EASY;
    }


    public ArrayList<Fruit> generateFruitWave(Difficulty difficulty)
    {
        int n = utils.generateRandomIntBasedOnDifficulty(difficulty);
        ArrayList<Fruit> fruits = new ArrayList<>();

        for (int i = 0; i < n; i++)
            fruits.add(generateRandomFruit());

        return fruits;
    }

    public void throwFruits(ArrayList<Fruit> fruits, Difficulty difficulty)
    {

    }

    public void throwSpecialFruit(Fruit fruit)
    {

    }

    private Fruit generateRandomFruit()
    {
        String randomFruitName = utils.randomValueFromEnum(OrdinaryFruitType.class).toString();
        return fruitFactory.createFruit(randomFruitName, FruitType.ORDINARY);
    }

    public Fruit generateRandomSpecialFruit()
    {
        String randomFruitName =  utils.randomValueFromEnum(SpecialFruitType.class).toString();
        return fruitFactory.createFruit(randomFruitName, FruitType.SPECIAL);
    }

    public void showGameOver()
    {

    }

    public int getWave() {
        return wave;
    }

    public void setWave(int wave) {
        this.wave = wave;
    }
    public void incWave() {this.wave += 1;};
}
