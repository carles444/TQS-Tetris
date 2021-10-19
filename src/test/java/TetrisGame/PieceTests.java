package TetrisGame;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PieceTests {
    Piece piece;

    @BeforeEach
    public void setUp() {
        piece = new BlueRicky(new int[]{0, 0});
    }
    @Test
    public void testColMove() {
        int[][] expectedPos = new int[][]{{0, 1}, {1, 1}, {1, 2}, {1, 3}};
        assertArrayEquals(piece.moveCol(1), expectedPos);

        expectedPos = new int[][]{{0, 3}, {1, 3}, {1, 4}, {1, 5}};
        assertArrayEquals(piece.moveCol(2), expectedPos);

        expectedPos = new int[][]{{0, 2}, {1, 2}, {1, 3}, {1, 4}};
        assertArrayEquals(piece.moveCol(-1), expectedPos);

        expectedPos = new int[][]{{0, 0}, {1, 0}, {1, 1}, {1, 2}};
        assertArrayEquals(piece.moveCol(-2), expectedPos);

        expectedPos = new int[][]{{0, 0}, {1, 0}, {1, 1}, {1, 2}};
        assertArrayEquals(piece.moveCol(0), expectedPos);

    }
}
