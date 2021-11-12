package TetrisGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


public class GameTests {
    Game game;
    Board board;

    public static boolean equalPositions(int[][] pos1, int[][] pos2) {
        for(int i = 0; i < Piece.pieceDim; i++) {
            if(pos1[i][0] != pos2[i][0] || pos1[i][1] != pos2[i][1])
                return false;
        }
        return true;
    }

    @BeforeEach
    public void setUp() {
        game = new Game();
        board = Board.getInstance();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, game.getScore());
        assertNotNull(game.getBoard());
        assertEquals(true, game.isRunning());
    }

    @Test
    public void testStartStop() throws InterruptedException {
        int[][] positions = board.getPiece().clonePositions();
        Thread.sleep(1000);
        assertEquals(false, equalPositions(positions, board.getPiece().getPositions()));
        assertEquals(true, game.isRunning());

        game.stop();
        positions = board.getPiece().clonePositions();
        Thread.sleep(1000);
        assertEquals(true, equalPositions(positions, board.getPiece().getPositions()));
        assertEquals(false, game.isRunning());

        positions = board.getPiece().clonePositions();
        game.start();
        Thread.sleep(1000);
        assertEquals(false, equalPositions(positions, board.getPiece().getPositions()));
        assertEquals(true, game.isRunning());


    }
}
