package TetrisGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HeroTests {
    Piece hero;
    @BeforeEach
    public void setUp() {
        hero = new Hero(new int[]{0, 0});
    }

    @Test
    public void testGetPositions() {
        int[][] expectedPos = new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}};
        assertArrayEquals(hero.getPositions(), expectedPos);
    }
}
