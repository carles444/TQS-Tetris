package TetrisGame.CajaNegra.Pieces;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import TetrisGame.View.Pieces.Piece;
import TetrisGame.View.Pieces.RhodeIslandZ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RhodeIslandTests {
    Piece rislandz;
    @BeforeEach
    public void setUp() {rislandz = new RhodeIslandZ(new int[]{0, 0});}

    @Test
    public void testGetPositions() {
        int[][] expectedPos = new int[][]{{0, 0}, {0, -1}, {1, -1}, {1, -2}};
        assertArrayEquals(rislandz.getPositions(), expectedPos);
    }

    @Test
    public void testRotateRightRhodeIsland() {
        int[][] expectedPos = new int[][]{{1, -1}, {0, -1}, {0, -2}, {-1, -2}};
        assertArrayEquals(rislandz.rotateRight(), expectedPos);
        rislandz.setPositions(rislandz.rotateRight());

        expectedPos = new int[][]{{0, 0}, {0, -1}, {1, -1}, {1, -2}};
        assertArrayEquals(rislandz.rotateRight(), expectedPos);
    }

    @Test
    public void testRotateLeftRhodeIsland() {
        int[][] expectedPos = new int[][]{{1, -1}, {0, -1}, {0, -2}, {-1, -2}};
        assertArrayEquals(rislandz.rotateLeft(), expectedPos);
        rislandz.setPositions(rislandz.rotateLeft());

        expectedPos = new int[][]{{0, 0}, {0, -1}, {1, -1}, {1, -2}};
        assertArrayEquals(rislandz.rotateLeft(), expectedPos);
    }
}
