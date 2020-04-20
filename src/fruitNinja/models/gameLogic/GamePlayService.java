package fruitNinja.models.gameLogic;

import fruitNinja.models.Difficulty;
import fruitNinja.models.bombs.Bomb;
import fruitNinja.models.bombs.BombFactory;
import fruitNinja.models.bombs.BombType;
import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.fruits.FruitFactory;
import fruitNinja.models.fruits.FruitType;
import fruitNinja.models.fruits.ordinary.OrdinaryFruitType;
import fruitNinja.models.fruits.special.SpecialFruitType;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.gameObjects.GameObjectType;
import fruitNinja.models.gameObjects.Sprite;
import fruitNinja.models.wave.WaveBuilder;
import fruitNinja.models.wave.WaveBuilderFactory;
import fruitNinja.models.wave.WaveDirector;
import fruitNinja.utils.RandomObjectGenerator;
import fruitNinja.utils.Utils;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;


public class GamePlayService {

    private Utils utils;

    private RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();

    public GamePlayService()
    {
        utils = new Utils();

    }

    /*
    public ArrayList<Sprite> generateWave(Difficulty difficulty) {
        int nFruits = utils.generateRandomFruitNumBasedOnDifficulty(difficulty);
        int nBombs=utils.generateRandomBombNumBasedOnDifficulty(difficulty);
        ArrayList<Sprite> sprites = new ArrayList<>();
        for (int i = 0; i < nFruits; i++)
            sprites.add(randomObjectGenerator.generateRandomFruit());
        for(int i=0;i<nBombs;i++)
            sprites.add(randomObjectGenerator.generateRandomBomb());
        Collections.shuffle(sprites);
        return sprites;
    }
    */

    public ArrayList<Sprite> generateWave(StrategyType strategyType, Difficulty difficulty) {
        WaveBuilderFactory waveBuilderFactory =  new WaveBuilderFactory();
        WaveBuilder waveBuilder = waveBuilderFactory.createWaveBuilder(strategyType);
        WaveDirector waveDirector = new WaveDirector(waveBuilder, difficulty);
        waveDirector.constructWave();
        return waveDirector.getWave().getWaveObjects();
    }
}