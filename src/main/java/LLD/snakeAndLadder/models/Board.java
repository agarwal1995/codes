package LLD.snakeAndLadder.models;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author raag
 */
@Data
public class Board {

    int size;
    Map<Integer, Snake> snakes;
    Map<Integer, Ladder> ladders;
}
