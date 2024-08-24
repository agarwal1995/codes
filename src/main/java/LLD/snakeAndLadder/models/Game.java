package LLD.snakeAndLadder.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author raag
 */
@Data
@AllArgsConstructor
public class Game {

    Board board;
    List<Player> players;
}
