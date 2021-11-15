package TetrisGame.CajaNegra;

import TetrisGame.View.Board;
import TetrisGame.Mock.MockGenerateRandomNum;
import TetrisGame.View.Pieces.Piece;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import static org.junit.jupiter.api.Assertions.assertTrue;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTests {
    private Board board;

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
        board = Board.getInstance(new MockGenerateRandomNum());
    }

    @AfterEach
    public void deleteBoard() {
        board.deleteBoard();
    }

    @Test
    public void testToString() {
        System.out.println(board);
    }

    @Test
    public void testGenerateRandomPiece() {
        board.deleteBoard();
        board = Board.getInstance();
        for(int i = 0; i < 100; i++)
            assertNotNull(board.generateRandomPiece());

    }

    @Test
    public void testTouchGroundAndPiece() {
        List<List<Integer>> matrix = board.getMat();
        int[][] expectedPos = new int[][]{{0, 5}, {1, 5}, {1, 4}, {1, 3}};
        board.movePieceNRows(30);
        assertArrayEquals(board.getPiece().getPositions(), expectedPos);

        expectedPos = new int[][]{{0, 5}, {1, 5}, {1, 4}, {1, 3}};
        matrix.get(5).set(3, 1);
        board.movePieceNRows(30);
        assertArrayEquals(board.getPiece().getPositions(), expectedPos);

        assertEquals(3, board.getNPieces());
    }

    @Test
    public void testUsedPositions() {
        List<List<Integer>> matrix = board.getMat();
        int[][] expectedPos = new int[][]{{0, 6}, {1, 6}, {1, 5}, {1, 4}};
        matrix.get(0).set(7, 1);
        board.movePieceNCols(30);
        assertArrayEquals(board.getPiece().getPositions(), expectedPos);

        expectedPos = new int[][]{{0, 3}, {1, 3}, {1, 2}, {1, 1}};
        matrix.get(1).set(0, 1);
        board.movePieceNCols(-30);
        assertArrayEquals(board.getPiece().getPositions(), expectedPos);

        expectedPos = new int[][]{{0, 5}, {1, 5}, {1, 4}, {1, 3}};
        board.movePieceNRows(30);
        assertArrayEquals(board.getPiece().getPositions(), expectedPos);
    }

    @Test
    public void testBasicConstructor() {
        int nRows = 20;
        int nCols = 10;
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
        assertEquals(false, board.isEnded());
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
        board.movePieceNCols(100);
        assertEquals(true, pieceInBoard());

        board.movePieceNCols(0);
        assertEquals(true, pieceInBoard());

        board.movePieceNCols(1);
        assertEquals(true, pieceInBoard());

        board.movePieceNCols(5);
        assertEquals(true, pieceInBoard());

        board.movePieceNCols(-100);
        assertEquals(true, pieceInBoard());

        board.movePieceNCols(0);
        assertEquals(true, pieceInBoard());

        board.movePieceNCols(-1);
        assertEquals(true, pieceInBoard());

        board.movePieceNCols(-4);
        assertEquals(true, pieceInBoard());

        board.movePieceNRows(100);
        assertEquals(true, pieceInBoard());

        board.movePieceNRows(0);
        assertEquals(true, pieceInBoard());

        board.movePieceNRows(1);
        assertEquals(true, pieceInBoard());

        board.movePieceNRows(17);
        assertEquals(true, pieceInBoard());

        board.movePieceNRows(-100);
        assertEquals(true, pieceInBoard());

        board.movePieceNRows(0);
        assertEquals(true, pieceInBoard());

        board.movePieceNRows(-1);
        assertEquals(true, pieceInBoard());

        board.movePieceNRows(-17);
        assertEquals(true, pieceInBoard());
    }

    @Test  //rotates the piece and checks if its positions don't exceed board limits
    public void testBoardLimitsRotate() {
        //right limit
        board.movePieceNCols(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceNCols(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceNCols(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceNCols(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());

        board.movePieceNCols(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceNCols(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceNCols(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceNCols(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());


        //left limit
        board.movePieceNCols(-30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceNCols(-30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceNCols(-30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceNCols(-30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());

        board.movePieceNCols(-30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceNCols(-30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceNCols(-30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceNCols(-30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());


        //down limit
        board.movePieceNRows(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceNRows(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceNRows(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceNRows(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());

        board.movePieceNRows(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceNRows(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceNRows(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceNRows(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());


        //up limit
        board.movePieceNRows(-30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceNRows(-30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceNRows(-30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceNRows(-30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());

        board.movePieceNRows(-30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceNRows(-30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceNRows(-30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceNRows(-30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());

        //TODO: test corners explicitly

    }

    @Test
    public void testDeleteFullRows() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        List<List<Integer>> expectedMat = new ArrayList<>();
        for(int i = 0; i < board.getNRows(); i++) {
            expectedMat.add(new ArrayList<Integer>());
            for (int j = 0; j < board.getNCols(); j++) {
                expectedMat.get(i).add(0);
            }
        }
        List<List<Integer>> testMat = board.getMat();
        for(int i = 0; i < board.getNCols(); i++) {
            testMat.get(board.getNRows()-1).set(i, 1);
        }
        testMat.get(board.getNRows()-2).set(1, 1);
        testMat.get(board.getNRows()-2).set(3, 1);

        expectedMat.get(board.getNRows()-1).set(1, 1);
        expectedMat.get(board.getNRows()-1).set(3, 1);

        board.deleteFullRows();
        assertEquals(true, equalMatrix(expectedMat, testMat));
        assertEquals(1, board.getNCompletedRows());
    }

    @Test
    public void testIsEnded() {
        board.getMat().get(0).set(5, 1);
        board.movePieceNRows(30);
        assertEquals(true, board.isEnded());
    }

}
