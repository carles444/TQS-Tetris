package TetrisGame;
import java.util.ArrayList;
import java.util.List;


public class Board {
    public static final int N_PIECES = 7;
    private List<List<Integer>> matrix;
    private Piece piece;


    private Piece generateRandomPiece() {
        GenerateRandomNum rand = new MockGenerateRandomNum(); //TODO: mockObject
        switch (rand.getRandPieceNum()) {
            case 0:
                return new OrangeRicky(new int[]{2, 4});
            case 1:
                return new BlueRicky(new int[]{2, 4});
            case 2:
                return new ClevelandZ(new int[]{2, 4});
            case 3:
                return new RhodeIslandZ(new int[]{2, 4});
            case 4:
                return new Hero(new int[]{2, 4});
            case 5:
                return new Teewee(new int[]{2, 4});
            case 6:
                return new Smashboy(new int[]{2, 4});
            default:
                return null;
        }
    }

    public Board(int nRows, int nCols) {
        matrix = new ArrayList<>();
        for(int i = 0; i < nRows; i++) {
            matrix.add(new ArrayList<Integer>());
            for(int j = 0; j < nCols; j++) {
                matrix.get(i).add(0);
            }
        }
        piece = generateRandomPiece();
    }

    private boolean fitsBoard(int[][] positions) {
        for(int[] pos : positions) {
            if(pos[0] >= getNRows() || pos[1] >= getNCols())
                return false;
        }
        return true;
    }


    //tries to move the piece nPositions
    public boolean movePieceCol(int nPos) {
        int[][] dest = piece.moveCol(nPos);
        if(fitsBoard(dest)) {
            piece.setPositions(dest);
            return true;
        }
        return false;
    }

    public boolean movePieceRow(int nPos) {
        int[][] dest = piece.moveRow(nPos);
        if(fitsBoard(dest)) {
            piece.setPositions(dest);
            return true;
        }
        return false;
    }


    //move the piece until is it possible 1 by 1
    public void movePieceColStepped(int nPos) {
        for(int i = 0; i < nPos; i++) {
            if(!movePieceCol(1))
                return;
        }
    }
    public void movePieceRowStepped(int nPos) {
        for(int i = 0; i < nPos; i++) {
            if(!movePieceRow(1))
                return;
        }
    }

    public void fixRotation(int[][] positions) {
        //TODO: implement method
    }

    public void rotatePieceRight() {
        int[][] dest = piece.rotateRight();
        fixRotation(dest);
        piece.setPositions(dest);
    }

    public void rotatePieceLeft() {
        int[][] dest = piece.rotateLeft();
        fixRotation(dest);
        piece.setPositions(dest);
    }

    public List<List<Integer>> getMat() { return matrix; }
    public Piece getPiece() { return piece; }
    public int getNRows() { return matrix.size(); }
    public int getNCols() { return matrix.get(0).size(); }
}
