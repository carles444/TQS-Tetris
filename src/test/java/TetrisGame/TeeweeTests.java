package TetrisGame;

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

}
