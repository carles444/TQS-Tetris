package TetrisGame;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClevelandZTests {
    Piece clevelandz;
    @BeforeEach
    public void setUp() {
        clevelandz = new ClevelandZ(new int[]{0, 0});
    }

    @Test
    public void testGetPositions() {
        int[][] expectedPos = new int[][]{{0, 0}, {0, 1}, {1, 1}, {1, 2}};
        assertArrayEquals(clevelandz.getPositions(), expectedPos);
    }

    @Test
    public void testRotateRightClevelandZ() {
        int[][] expectedPos = new int[][]{{-1, 2}, {0, 2}, {0, 1}, {1, 1}};
        assertArrayEquals(clevelandz.rotateRight(), expectedPos);
        clevelandz.setPositions(clevelandz.rotateRight());


        expectedPos = new int[][]{{0, 0}, {0, 1}, {1, 1}, {1, 2}};
        assertArrayEquals(clevelandz.rotateRight(), expectedPos);
    }

    @Test
    public void testRotateLeftClevelandZ() {
        int[][] expectedPos = new int[][]{{-1, 2}, {0, 2}, {0, 1}, {1, 1}};
        assertArrayEquals(clevelandz.rotateRight(), expectedPos);
        clevelandz.setPositions(clevelandz.rotateLeft());

        expectedPos = new int[][]{{0, 0}, {0, 1}, {1, 1}, {1, 2}};
        assertArrayEquals(clevelandz.rotateRight(), expectedPos);
    }
}
