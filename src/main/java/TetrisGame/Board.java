package TetrisGame;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Integer>> matrix;
    private Piece piece;

    private Piece generateRandomPiece() {
        return null;
    }

    public Board(int nRows, int nCols) {
        matrix = new ArrayList<>();
        for(int i = 0; i < nRows; i++) {
            matrix.add(new ArrayList<Integer>());
            for(int j = 0; j < nCols; j++) {
                matrix.get(i).add(0);
            }
        }
        piece = new OrangeRicky(new int[]{0, 0}); //TODO: make it random
    }


    public List<List<Integer>> getMat() { return matrix; }
    public Piece getPiece() { return piece; }
    public int getNRows() { return matrix.size(); }
    public int getNCols() { return matrix.get(0).size(); }
}
