package TetrisGame;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RhodeIslandTests {
    Piece rislandz;
    @BeforeEach
    public void setUp() {rislandz = new Rhodelsland(new int[]{0, 0});}

    @Test
    public void testGetPositions() {
        int[][] expectedPos = new int[][]{{0, 0}, {0, -1}, {1, -1}, {1, -2}};
        assertArrayEquals(rislandz.getPositions(), expectedPos);
    }
}
