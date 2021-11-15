package TetrisGame.CajaNegra;

import TetrisGame.Mock.MockGenerateRandomNum;
import TetrisGame.View.Board;
import TetrisGame.Controller.Game;
import TetrisGame.View.Pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


import static org.junit.jupiter.api.Assertions.*;


public class GameTests {
    Game game;
    Board board;

    public static boolean equalPositions(int[][] pos1, int[][] pos2) {
        for (int i = 0; i < Piece.pieceDim; i++) {
            if (pos1[i][0] != pos2[i][0] || pos1[i][1] != pos2[i][1])
                return false;
        }
        return true;
    }

    @BeforeEach
    public void setUp() {
        board = Board.getInstance(new MockGenerateRandomNum());
        game = new Game();
        game.enableTesting();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, game.getScore());
        assertNotNull(game.getBoard());
        assertEquals(false, game.isRunning());
    }

    @Test
    public void testStartStop() throws InterruptedException {
        int[][] positions = board.getPiece().clonePositions();
        game.start();
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

    @Test
    public void testEndGame() {
        board.getMat().get(0).set(5, 1);
        board.movePieceNRows(30);
        assertEquals(true, game.gameEnd());
    }
}
