package TetrisGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
            for(int j = 0; i < mat1.get(i).size(); j++){
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
    public void testConstructor() {
        List<List<Integer>> expectedMat = new ArrayList<>();
        for(int i = 0; i < board.getNRows(); i++) {
            expectedMat.add(new ArrayList<Integer>());
            for(int j = 0; j < board.getNCols(); j++) {
                expectedMat.get(i).add(0);
            }
        }
        assertTrue(equalMatrix(expectedMat, board.getMat()));
        assertNotNull(board.getPiece());
        assertEquals(board.getNRows(), nRows);
        assertEquals(board.getNCols(), nCols);
    }

}
