package LLD.snakeAndLadder.service;

import java.util.Random;

/**
 * @author raag
 */

public class NormalDice implements Dice {

    @Override
    public int rollDice() {
        return new Random().nextInt(6)+1;
    }
}
