package TetrisGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//    #
//# # #
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
    public void testRotateRightOrangeRicky() {
        int[][] expectedPos = new int[][]{{1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        assertArrayEquals(orangeRicky.rotateRight(), expectedPos);
        orangeRicky.setPositions(orangeRicky.rotateRight());

        expectedPos = new int[][]{{1, -2}, {0, -2}, {0, -1}, {0, 0}};
        assertArrayEquals(orangeRicky.rotateRight(), expectedPos);
        orangeRicky.setPositions(orangeRicky.rotateRight());

        expectedPos = new int[][]{{-1, -2}, {-1, -1}, {0, -1}, {1, -1}};
        assertArrayEquals(orangeRicky.rotateRight(), expectedPos);
        orangeRicky.setPositions(orangeRicky.rotateRight());

        expectedPos = new int[][]{{0, 0}, {1, 0}, {1, -1}, {1, -2}};
        assertArrayEquals(orangeRicky.rotateRight(), expectedPos);
    }

    @Test
    public void testRotateLeftOrangeRicky() {
        int[][] expectedPos = new int[][]{{-1, -2}, {-1, -1}, {0, -1}, {1, -1}};
        assertArrayEquals(orangeRicky.rotateLeft(), expectedPos);
        orangeRicky.setPositions(orangeRicky.rotateLeft());

        expectedPos = new int[][]{{1, -2}, {0, -2}, {0, -1}, {0, 0}};
        assertArrayEquals(orangeRicky.rotateLeft(), expectedPos);
        orangeRicky.setPositions(orangeRicky.rotateLeft());

        expectedPos = new int[][]{{1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        assertArrayEquals(orangeRicky.rotateLeft(), expectedPos);
        orangeRicky.setPositions(orangeRicky.rotateLeft());

        expectedPos = new int[][]{{0, 0}, {1, 0}, {1, -1}, {1, -2}};
        assertArrayEquals(orangeRicky.rotateLeft(), expectedPos);
    }
}

