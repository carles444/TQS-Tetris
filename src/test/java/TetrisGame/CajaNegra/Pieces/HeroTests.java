package TetrisGame.CajaNegra.Pieces;

import TetrisGame.View.Pieces.Hero;
import TetrisGame.View.Pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals("Hero", hero.getName());

    }

    @Test
    public void testRotateRightHero() {
        int[][] expectedPos = new int[][]{{-3, 2}, {-2, 2}, {-1, 2}, {0, 2}};
        assertArrayEquals(hero.rotateRight(), expectedPos);
        hero.setPositions(hero.rotateRight());

        expectedPos = new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}};
        assertArrayEquals(hero.rotateRight(), expectedPos);
    }

    @Test
    public void testRotateLeftHero() {
        int[][] expectedPos = new int[][]{{-3, 2}, {-2, 2}, {-1, 2}, {0, 2}};
        assertArrayEquals(hero.rotateLeft(), expectedPos);
        hero.setPositions(hero.rotateLeft());

        expectedPos = new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}};
        assertArrayEquals(hero.rotateLeft(), expectedPos);
    }
}
