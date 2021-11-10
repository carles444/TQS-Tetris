package TetrisGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTests {
    private Board board;
    int nRows = 20;
    int nCols = 10;
    
    public boolean equalMatrix(List<List<Integer>> mat1, List<List<Integer>> mat2) {
        if(mat1.size() != mat2.size())
            return false;
        if(mat1.get(0).size() != mat2.get(0).size())
            return false;
        for(int i = 0; i < mat1.size(); i++) {
            for(int j = 0; j < mat1.get(i).size(); j++){
                if(!Objects.equals(mat1.get(i).get(j), mat2.get(i).get(j)))
                    return false;
            }
        }
        return true;
    }
    
    @BeforeEach
    public void setUp() {
        nRows = 20;
        nCols = 10;
        board = new Board(nRows, nCols);
    }

    @Test
    public void testUsedPositions() {
        List<List<Integer>> matrix = board.getMat();
        int[][] expectedPos = new int[][]{{2, 6}, {3, 6}, {3, 5}, {3, 4}};
        matrix.get(2).set(7, 1);
        board.movePieceColStepped(30);
        assertArrayEquals(board.getPiece().getPositions(), expectedPos);

        expectedPos = new int[][]{{3, 6}, {4, 6}, {4, 5}, {4, 4}};
        matrix.get(5).set(6, 1);
        board.movePieceRowStepped(30);
        assertArrayEquals(board.getPiece().getPositions(), expectedPos);
    }

    @Test
    public void testBasicConstructor() {
        List<List<Integer>> expectedMat = new ArrayList<>();
        for(int i = 0; i < board.getNRows(); i++) {
            expectedMat.add(new ArrayList<Integer>());
            for(int j = 0; j < board.getNCols(); j++) {
                expectedMat.get(i).add(0);
            }
        }
        assertEquals(true, equalMatrix(expectedMat, board.getMat()));
        assertNotNull(board.getPiece());
        assertEquals("OrangeRicky", board.getPiece().getName());
        assertEquals(board.getNRows(), nRows);
        assertEquals(board.getNCols(), nCols);
    }

    boolean pieceInBoard() {
        for(int[] pos : board.getPiece().getPositions()) {
            if(pos[0] >= board.getNRows() || pos[1] >= board.getNCols())
                return false;
        }
        return true;
    }

    @Test
    public void testFixPosition() {
        //right limits
        int[][] expectedPos = new int[][]{{2, 9}, {3, 9}, {3, 8}, {3, 7}};
        int[][] test = new int[][]{{2, 20}, {3, 20}, {3, 19}, {3, 18}};
        board.fixPosition(test);
        assertArrayEquals(test, expectedPos);

        //left limits
        expectedPos = new int[][]{{2, 2}, {3, 2}, {3, 1}, {3, 0}};
        test = new int[][]{{2, -6}, {3, -6}, {3, -7}, {3, -8}};
        board.fixPosition(test);
        assertArrayEquals(test, expectedPos);

        //up limits
        expectedPos = new int[][]{{0, 2}, {1, 2}, {1, 1}, {1, 0}};
        test = new int[][]{{-2, 2}, {-1, 2}, {-1, 1}, {-1, 0}};
        board.fixPosition(test);
        assertArrayEquals(test, expectedPos);

        //down limits
        expectedPos = new int[][]{{18, 2}, {19, 2}, {19, 1}, {19, 0}};
        test = new int[][]{{21, 2}, {22, 2}, {22, 1}, {22, 0}};
        board.fixPosition(test);
        assertArrayEquals(test, expectedPos);
    }

    @Test  //moves the piece and checks if its positions don't exceed board limits
    public void testBoardLimitsMove() {
        board.movePieceCol(100);
        assertEquals(true, pieceInBoard());

        board.movePieceCol(0);
        assertEquals(true, pieceInBoard());

        board.movePieceCol(1);
        assertEquals(true, pieceInBoard());

        board.movePieceCol(5);
        assertEquals(true, pieceInBoard());

        board.movePieceCol(100);
        assertEquals(true, pieceInBoard());

        board.movePieceCol(0);
        assertEquals(true, pieceInBoard());

        board.movePieceCol(1);
        assertEquals(true, pieceInBoard());

        board.movePieceCol(4);
        assertEquals(true, pieceInBoard());

        board.movePieceRow(100);
        assertEquals(true, pieceInBoard());

        board.movePieceRow(0);
        assertEquals(true, pieceInBoard());

        board.movePieceRow(1);
        assertEquals(true, pieceInBoard());

        board.movePieceRow(17);
        assertEquals(true, pieceInBoard());

        board.movePieceRow(100);
        assertEquals(true, pieceInBoard());

        board.movePieceRow(0);
        assertEquals(true, pieceInBoard());

        board.movePieceRow(1);
        assertEquals(true, pieceInBoard());

        board.movePieceRow(17);
        assertEquals(true, pieceInBoard());
    }

    @Test  //rotates the piece and checks if its positions don't exceed board limits
    public void testBoardLimitsRotate() {
        //right limit
        board.movePieceColStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceColStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceColStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceColStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());

        board.movePieceColStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceColStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceColStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceColStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());


        //left limit
        board.movePieceColStepped(-30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceColStepped(-30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceColStepped(-30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceColStepped(-30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());

        board.movePieceColStepped(-30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceColStepped(-30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceColStepped(-30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceColStepped(-30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());


        //down limit
        board.movePieceRowStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceRowStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceRowStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceRowStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());

        board.movePieceRowStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceRowStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceRowStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceRowStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());


        //up limit
        board.movePieceRowStepped(-30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceRowStepped(-30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceRowStepped(-30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceRowStepped(-30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());

        board.movePieceRowStepped(-30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceRowStepped(-30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceRowStepped(-30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceRowStepped(-30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());

        //TODO: test corners explicitly

    }


}
