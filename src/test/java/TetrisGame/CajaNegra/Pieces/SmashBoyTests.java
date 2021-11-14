package TetrisGame.CajaNegra.Pieces;

import TetrisGame.View.Pieces.Piece;
import TetrisGame.View.Pieces.Smashboy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SmashBoyTests {
    Piece smashboy;
    @BeforeEach
    public void setUp() {
        smashboy = new Smashboy(new int[]{0, 0});
    }

    @Test
    public void testGetPositions() {
        int[][] expectedPos = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        assertArrayEquals(smashboy.getPositions(), expectedPos);
    }

    @Test
    public void testRotateRightSmashBoy() {
        int[][] expectedPos = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        assertArrayEquals(smashboy.getPositions(), expectedPos);
    }

    @Test
    public void testRotateLeftSmashBoy() {
        int[][] expectedPos = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        assertArrayEquals(smashboy.getPositions(), expectedPos);
    }
}
