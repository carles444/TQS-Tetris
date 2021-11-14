package TetrisGame.CajaBlanca;

import TetrisGame.View.Pieces.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//con estos tests nos aseguramos de que por cada pieza rote de todas las maneras en ambas direcciones,
//es decir, que entre en todos los condicionales del rotate

public class PieceCajaBlancaTests {
    Piece orangeRicky;
    Piece blueRicky;
    Piece clevelandz;
    Piece rislandz;
    Piece hero;
    Piece smashboy;
    Piece tewee;

    @BeforeEach
    public void setUp() {
        orangeRicky = new OrangeRicky(new int[]{0, 0});
        blueRicky = new BlueRicky(new int[]{0, 0});
        clevelandz = new ClevelandZ(new int[]{0, 0});
        rislandz = new RhodeIslandZ(new int[]{0, 0});
        hero = new Hero(new int[]{0, 0});
        smashboy = new Smashboy(new int[]{0, 0});
        tewee = new Teewee(new int[]{0, 0});
    }



    @Test
    public void testRotateBlueRicky() {
        //test rotate goes through all conditions

        //rotate right
        int[][] expectedPos = new int[][]{{-1, 2}, {-1, 1}, {0, 1}, {1, 1}};
        assertArrayEquals(blueRicky.rotateRight(), expectedPos);
        blueRicky.setPositions(blueRicky.rotateRight());

        expectedPos = new int[][]{{1, 2}, {0, 2}, {0, 1}, {0, 0}};
        assertArrayEquals(blueRicky.rotateRight(), expectedPos);
        blueRicky.setPositions(blueRicky.rotateRight());

        expectedPos = new int[][]{{1, 0}, {1, 1}, {0, 1}, {-1, 1}};
        assertArrayEquals(blueRicky.rotateRight(), expectedPos);
        blueRicky.setPositions(blueRicky.rotateRight());

        expectedPos = new int[][]{{0, 0}, {1, 0}, {1, 1}, {1, 2}};
        assertArrayEquals(blueRicky.rotateRight(), expectedPos);
        blueRicky.setPositions(blueRicky.rotateRight());

        //rotate left
        expectedPos = new int[][]{{1, 0}, {1, 1}, {0, 1}, {-1, 1}};
        assertArrayEquals(blueRicky.rotateLeft(), expectedPos);
        blueRicky.setPositions(blueRicky.rotateLeft());

        expectedPos = new int[][]{{1, 2}, {0, 2}, {0, 1}, {0, 0}};
        assertArrayEquals(blueRicky.rotateLeft(), expectedPos);
        blueRicky.setPositions(blueRicky.rotateLeft());

        expectedPos = new int[][]{{-1, 2}, {-1, 1}, {0, 1}, {1, 1}};
        assertArrayEquals(blueRicky.rotateLeft(), expectedPos);
        blueRicky.setPositions(blueRicky.rotateLeft());

        expectedPos = new int[][]{{0, 0}, {1, 0}, {1, 1}, {1, 2}};
        assertArrayEquals(blueRicky.rotateLeft(), expectedPos);
    }

    @Test
    public void testRotateOrangeRicky() {
        //test rotate goes through all conditions

        //rotate right
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
        orangeRicky.setPositions(orangeRicky.rotateRight());

        //rotate left
        expectedPos = new int[][]{{-1, -2}, {-1, -1}, {0, -1}, {1, -1}};
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

    @Test
    public void testRotateClevelandZ() {
        //test rotate goes through all conditions

        //rotate right
        int[][] expectedPos = new int[][]{{-1, 2}, {0, 2}, {0, 1}, {1, 1}};
        assertArrayEquals(clevelandz.rotateRight(), expectedPos);
        clevelandz.setPositions(clevelandz.rotateRight());


        expectedPos = new int[][]{{0, 0}, {0, 1}, {1, 1}, {1, 2}};
        assertArrayEquals(clevelandz.rotateRight(), expectedPos);
        clevelandz.setPositions(clevelandz.rotateRight());

        //rotate left
        expectedPos = new int[][]{{-1, 2}, {0, 2}, {0, 1}, {1, 1}};
        assertArrayEquals(clevelandz.rotateRight(), expectedPos);
        clevelandz.setPositions(clevelandz.rotateLeft());

        expectedPos = new int[][]{{0, 0}, {0, 1}, {1, 1}, {1, 2}};
        assertArrayEquals(clevelandz.rotateRight(), expectedPos);
    }

    @Test
    public void testRotateRhodeIslandZ() {
        //test rotate goes through all conditions

        //rotate right
        int[][] expectedPos = new int[][]{{1, -1}, {0, -1}, {0, -2}, {-1, -2}};
        assertArrayEquals(rislandz.rotateRight(), expectedPos);
        rislandz.setPositions(rislandz.rotateRight());

        expectedPos = new int[][]{{0, 0}, {0, -1}, {1, -1}, {1, -2}};
        assertArrayEquals(rislandz.rotateRight(), expectedPos);
        rislandz.setPositions(rislandz.rotateRight());

        //rotate left
        expectedPos = new int[][]{{1, -1}, {0, -1}, {0, -2}, {-1, -2}};
        assertArrayEquals(rislandz.rotateLeft(), expectedPos);
        rislandz.setPositions(rislandz.rotateLeft());

        expectedPos = new int[][]{{0, 0}, {0, -1}, {1, -1}, {1, -2}};
        assertArrayEquals(rislandz.rotateLeft(), expectedPos);
    }

    @Test
    public void testRotateTeewee() {
        //test rotate goes through all conditions

        //rotate right
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
        tewee.setPositions(tewee.rotateRight());

        //rotate left
        expectedPos = new int[][]{{0, -1}, {0, 0}, {1, 0}, {-1, 0}};
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

    @Test
    public void testRotateHero() {
        //test rotate goes through all conditions

        //rotate right
        int[][] expectedPos = new int[][]{{-3, 2}, {-2, 2}, {-1, 2}, {0, 2}};
        assertArrayEquals(hero.rotateRight(), expectedPos);
        hero.setPositions(hero.rotateRight());

        expectedPos = new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}};
        assertArrayEquals(hero.rotateRight(), expectedPos);
        hero.setPositions(hero.rotateRight());

        //rotate left
        expectedPos = new int[][]{{-3, 2}, {-2, 2}, {-1, 2}, {0, 2}};
        assertArrayEquals(hero.rotateRight(), expectedPos);
        hero.setPositions(hero.rotateLeft());

        expectedPos = new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}};
        assertArrayEquals(hero.rotateRight(), expectedPos);
    }

    @Test
    public void testRotateSmashBoy() {
        //test rotate goes through all conditions

        //rotate right
        int[][] expectedPos = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        assertArrayEquals(smashboy.getPositions(), expectedPos);

        //rotate left
        expectedPos = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        assertArrayEquals(smashboy.getPositions(), expectedPos);
    }
}
