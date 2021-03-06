package TetrisGame.CajaNegra.Pieces;

import TetrisGame.View.Pieces.BlueRicky;
import TetrisGame.View.Pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

//#
//# # #
public class BlueRickyTests {
    Piece blueRicky;
    @BeforeEach
    public void setUp() {
        blueRicky = new BlueRicky(new int[]{0, 0});
    }

    @Test
    public void testGetPositions() {
        int[][] expectedPos = new int[][]{{0, 0}, {1, 0}, {1, 1}, {1, 2}};
        assertArrayEquals(blueRicky.getPositions(), expectedPos);
        assertEquals("BlueRicky", blueRicky.getName());

    }

    @Test
    public void testRotateRightBlueRicky() {
        int[][] expectedPos = new int[][]{{-1, 2}, {-1, 1}, {0, 1}, {1, 1}};
        assertArrayEquals(blueRicky.rotateRight(), expectedPos);
        blueRicky.setPositions(blueRicky.rotateRight());

        expectedPos = new int[][]{{1, 2}, {0, 2}, {0, 1}, {0, 0}};
        assertArrayEquals(blueRicky.rotateRight(), expectedPos);
        blueRicky.setPositions(blueRicky.rotateRight());

        expectedPos = new int[][]{{1, 0}, {1, 1}, {0, 1}, {-1, 1}};
        assertArrayEquals(blueRicky.rotateRight(), expectedPos);
        blueRicky.setPositions(blueRicky.rotateRight());

        expectedPos = new int[][]{{0, 0}, {1, 0}, {1, 1}, {1, 2}};
        assertArrayEquals(blueRicky.rotateRight(), expectedPos);
    }

    @Test
    public void testRotateLeftBlueRicky() {
        int[][] expectedPos = new int[][]{{1, 0}, {1, 1}, {0, 1}, {-1, 1}};
        assertArrayEquals(blueRicky.rotateLeft(), expectedPos);
        blueRicky.setPositions(blueRicky.rotateLeft());

        expectedPos = new int[][]{{1, 2}, {0, 2}, {0, 1}, {0, 0}};
        assertArrayEquals(blueRicky.rotateLeft(), expectedPos);
        blueRicky.setPositions(blueRicky.rotateLeft());

        expectedPos = new int[][]{{-1, 2}, {-1, 1}, {0, 1}, {1, 1}};
        assertArrayEquals(blueRicky.rotateLeft(), expectedPos);
        blueRicky.setPositions(blueRicky.rotateLeft());

        expectedPos = new int[][]{{0, 0}, {1, 0}, {1, 1}, {1, 2}};
        assertArrayEquals(blueRicky.rotateLeft(), expectedPos);
    }
}
