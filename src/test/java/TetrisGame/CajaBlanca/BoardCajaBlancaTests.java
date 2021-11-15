package TetrisGame.CajaBlanca;

import TetrisGame.Mock.MockGenerateRandomNum;
import TetrisGame.View.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardCajaBlancaTests {
    Board board;

    @BeforeEach
    public void setUp() {
        if(board != null)
            board.deleteBoard();
        board = Board.getInstance(new MockGenerateRandomNum());
    }



    @Test
    public void testTouchGroundAndPiece() {
        List<List<Integer>> matrix = board.getMat();
        int[][] expectedPos = new int[][]{{0, 5}, {1, 5}, {1, 4}, {1, 3}};
        board.movePieceNRows(30);
        assertArrayEquals(board.getPiece().getPositions(), expectedPos);

        expectedPos = new int[][]{{0, 5}, {1, 5}, {1, 4}, {1, 3}};
        matrix.get(5).set(3, 1);
        board.movePieceNRows(30);
        assertArrayEquals(board.getPiece().getPositions(), expectedPos);

        assertEquals(4, board.getNPieces());
    }

    @Test
    public void testFixPosition() {
        //right limits
        int[][] expectedPos = new int[][]{{2, 9}, {3, 9}, {3, 8}, {3, 7}};
        int[][] test = new int[][]{{2, 20}, {3, 20}, {3, 19}, {3, 18}};
        board.fixPosition(test);
        assertArrayEquals(test, expectedPos);

        //left limits
        expectedPos = new int[][]{{2, 2}, {3, 2}, {3, 1}, {3, 0}};
        test = new int[][]{{2, -6}, {3, -6}, {3, -7}, {3, -8}};
        board.fixPosition(test);
        assertArrayEquals(test, expectedPos);

        //up limits
        expectedPos = new int[][]{{0, 2}, {1, 2}, {1, 1}, {1, 0}};
        test = new int[][]{{-2, 2}, {-1, 2}, {-1, 1}, {-1, 0}};
        board.fixPosition(test);
        assertArrayEquals(test, expectedPos);

        //down limits
        expectedPos = new int[][]{{18, 2}, {19, 2}, {19, 1}, {19, 0}};
        test = new int[][]{{21, 2}, {22, 2}, {22, 1}, {22, 0}};
        board.fixPosition(test);
        assertArrayEquals(test, expectedPos);
    }
}
