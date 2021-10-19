package TetrisGame;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PieceTests {
    Piece piece;

    @BeforeEach
    void setUp() {
        piece = new BlueRicky(new int[]{0, 0});
    }

    @Test
    public void testColMove() {
        int[][] expectedPos = new int[][]{{0, 1}, {1, 1}, {1, 2}, {1, 3}};
        assertEquals(piece.moveCol(1), expectedPos);
    }
}
