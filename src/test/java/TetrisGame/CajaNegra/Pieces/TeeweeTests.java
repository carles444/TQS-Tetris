package TetrisGame.CajaNegra.Pieces;

import TetrisGame.View.Pieces.Piece;
import TetrisGame.View.Pieces.Teewee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TeeweeTests {
    Piece tewee;
    @BeforeEach
    public void setUp() {
        tewee = new Teewee(new int[]{0, 0});
    }

    @Test
    public void testGetPositions() {
        int[][] expectedPos = new int[][]{{0, 0}, {1, 0}, {1, -1}, {1, 1}};
        assertArrayEquals(tewee.getPositions(), expectedPos);
    }

    @Test
    public void testRotateRightTeewee() {
        int[][] expectedPos = new int[][]{{0, 1}, {0, 0}, {-1, 0}, {1, 0}};
        assertArrayEquals(tewee.rotateRight(), expectedPos);
        tewee.setPositions(tewee.rotateRight());

        expectedPos = new int[][]{{1, 0}, {0, 0}, {0, 1}, {0, -1}};
        assertArrayEquals(tewee.rotateRight(), expectedPos);
        tewee.setPositions(tewee.rotateRight());

        expectedPos = new int[][]{{0, -1}, {0, 0}, {1, 0}, {-1, 0}};
        assertArrayEquals(tewee.rotateRight(), expectedPos);
        tewee.setPositions(tewee.rotateRight());

        expectedPos = new int[][]{{0, 0}, {1, 0}, {1, -1}, {1, 1}};
        assertArrayEquals(tewee.rotateRight(), expectedPos);
    }

    @Test
    public void testRotateLeftTeewee() {
        int[][] expectedPos = new int[][]{{0, -1}, {0, 0}, {1, 0}, {-1, 0}};
        assertArrayEquals(tewee.rotateLeft(), expectedPos);
        tewee.setPositions(tewee.rotateLeft());

        expectedPos = new int[][]{{1, 0}, {0, 0}, {0, 1}, {0, -1}};
        assertArrayEquals(tewee.rotateLeft(), expectedPos);
        tewee.setPositions(tewee.rotateLeft());

        expectedPos = new int[][]{{0, 1}, {0, 0}, {-1, 0}, {1, 0}};
        assertArrayEquals(tewee.rotateLeft(), expectedPos);
        tewee.setPositions(tewee.rotateLeft());

        expectedPos = new int[][]{{0, 0}, {1, 0}, {1, -1}, {1, 1}};
        assertArrayEquals(tewee.rotateLeft(), expectedPos);
    }

}
