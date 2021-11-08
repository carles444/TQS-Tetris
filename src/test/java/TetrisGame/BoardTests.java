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

    @Test  //moves the piece and checks if its positions don't exceed board limits
    public void testBoardLimitsMove() {//Todo: test exception negative number
        board.movePieceRight(100);
        assertEquals(true, pieceInBoard());

        board.movePieceRight(0);
        assertEquals(true, pieceInBoard());

        board.movePieceRight(1);
        assertEquals(true, pieceInBoard());

        board.movePieceRight(5);
        assertEquals(true, pieceInBoard());

        board.movePieceLeft(100);
        assertEquals(true, pieceInBoard());

        board.movePieceLeft(0);
        assertEquals(true, pieceInBoard());

        board.movePieceLeft(1);
        assertEquals(true, pieceInBoard());

        board.movePieceLeft(4);
        assertEquals(true, pieceInBoard());

        board.movePieceDown(100);
        assertEquals(true, pieceInBoard());

        board.movePieceDown(0);
        assertEquals(true, pieceInBoard());

        board.movePieceDown(1);
        assertEquals(true, pieceInBoard());

        board.movePieceDown(17);
        assertEquals(true, pieceInBoard());

        board.movePieceUp(100);
        assertEquals(true, pieceInBoard());

        board.movePieceUp(0);
        assertEquals(true, pieceInBoard());

        board.movePieceUp(1);
        assertEquals(true, pieceInBoard());

        board.movePieceUp(17);
        assertEquals(true, pieceInBoard());
    }

    @Test  //rotates the piece and checks if its positions don't exceed board limits
    public void testBoardLimitsRotate() {
        //right limit
        board.movePieceRightStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceRightStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceRightStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceRightStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());

        board.movePieceRightStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceRightStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceRightStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceRightStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());


        //left limit
        board.movePieceLeftStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceLeftStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceLeftStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceLeftStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());

        board.movePieceLeftStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceLeftStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceLeftStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceLeftStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());


        //down limit
        board.movePieceDownStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceDownStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceDownStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceDownStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());

        board.movePieceDownStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceDownStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceDownStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceDownStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());


        //up limit
        board.movePieceUpStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceUpStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceUpStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());
        board.movePieceUpStepped(30);
        board.rotatePieceRight();
        assertEquals(true, pieceInBoard());

        board.movePieceUpStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceUpStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceUpStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());
        board.movePieceUpStepped(30);
        board.rotatePieceLeft();
        assertEquals(true, pieceInBoard());

        //TODO: test corners explicitly

    }


}
