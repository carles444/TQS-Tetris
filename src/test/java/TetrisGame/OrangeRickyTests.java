package TetrisGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//    #
//# # #
//TODO: afegir comprovador de constructor i adaptar orangeRicky
public class OrangeRickyTests {
    Piece orangeRicky;
    @BeforeEach
    public void setUp() {
        orangeRicky = new OrangeRicky(new int[]{0, 0});
    }

    @Test
    public void testGetPositions() {
        int[][] expectedPos = new int[][]{{0, 0}, {1, 0}, {1, -1}, {1, -2}};
        assertArrayEquals(orangeRicky.getPositions(), expectedPos);
    }

    @Test
    public void testRotateRightBlueRicky() {
        int[][] expectedPos = new int[][]{{0, 2}, {0, 1}, {1, 1}, {2, 1}};
        assertArrayEquals(orangeRicky.rotateRight(), expectedPos);

        expectedPos = new int[][]{{2, 2}, {1, 2}, {1, 1}, {1, 0}};
        assertArrayEquals(orangeRicky.rotateRight(), expectedPos);

        expectedPos = new int[][]{{2, 0}, {2, 1}, {1, 1}, {0, 1}};
        assertArrayEquals(orangeRicky.rotateRight(), expectedPos);

        expectedPos = new int[][]{{0, 0}, {1, 0}, {1, 1}, {1, 2}};
        assertArrayEquals(orangeRicky.rotateRight(), expectedPos);
    }

    @Test
    public void testRotateLeftBlueRicky() {
        int[][] expectedPos = new int[][]{{2, 0}, {2, 1}, {1, 1}, {0, 1}};
        assertArrayEquals(orangeRicky.rotateLeft(), expectedPos);

        expectedPos = new int[][]{{2, 2}, {1, 2}, {1, 1}, {1, 0}};
        assertArrayEquals(orangeRicky.rotateLeft(), expectedPos);

        expectedPos = new int[][]{{0, 2}, {0, 1}, {1, 1}, {2, 1}};
        assertArrayEquals(orangeRicky.rotateLeft(), expectedPos);

        expectedPos = new int[][]{{0, 0}, {1, 0}, {1, 1}, {1, 2}};
        assertArrayEquals(orangeRicky.rotateLeft(), expectedPos);
    }
}

