package TetrisGame;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class PieceTests {
    Piece blueRicky;

    @BeforeEach
    public void setUp() {
        blueRicky = new BlueRicky(new int[]{0, 0});
    }
    @Test
    public void testMoveCol() {
        int[][] expectedPos = new int[][]{{0, 1}, {1, 1}, {1, 2}, {1, 3}};
        assertArrayEquals(blueRicky.moveCol(1), expectedPos);

        expectedPos = new int[][]{{0, 3}, {1, 3}, {1, 4}, {1, 5}};
        assertArrayEquals(blueRicky.moveCol(2), expectedPos);

        expectedPos = new int[][]{{0, 2}, {1, 2}, {1, 3}, {1, 4}};
        assertArrayEquals(blueRicky.moveCol(-1), expectedPos);

        expectedPos = new int[][]{{0, 0}, {1, 0}, {1, 1}, {1, 2}};
        assertArrayEquals(blueRicky.moveCol(-2), expectedPos);

        expectedPos = new int[][]{{0, 0}, {1, 0}, {1, 1}, {1, 2}};
        assertArrayEquals(blueRicky.moveCol(0), expectedPos);

    }

    @Test
    public void testMoveRow() {
        int[][] expectedPos = new int[][]{{1, 0}, {2, 0}, {2, 1}, {2, 2}};
        assertArrayEquals(blueRicky.moveRow(1), expectedPos);

        expectedPos = new int[][]{{3, 0}, {4, 0}, {4, 1}, {4, 2}};
        assertArrayEquals(blueRicky.moveRow(2), expectedPos);

        expectedPos = new int[][]{{2, 0}, {3, 0}, {3, 1}, {3, 2}};
        assertArrayEquals(blueRicky.moveRow(-1), expectedPos);

        expectedPos = new int[][]{{0, 0}, {1, 0}, {1, 1}, {1, 2}};
        assertArrayEquals(blueRicky.moveRow(-2), expectedPos);

        expectedPos = new int[][]{{0, 0}, {1, 0}, {1, 1}, {1, 2}};
        assertArrayEquals(blueRicky.moveRow(0), expectedPos);

    }


}
