package LLD.snakeAndLadder.service;

import LLD.snakeAndLadder.models.Board;

/**
 * @author raag
 */
public interface ISnakeLadderFacade {

    public void movePlayer(Board board, int position);
}
