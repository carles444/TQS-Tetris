package TetrisGame;
import java.util.ArrayList;
import java.util.List;



public class Board {
    public static final int N_PIECES = 7;
    private List<List<Integer>> matrix;
    private Piece piece;


    private Piece generateRandomPiece() {
        GenerateRandomNum rand = new MockGenerateRandomNum();
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


    public List<List<Integer>> getMat() { return matrix; }
    public Piece getPiece() { return piece; }
    public int getNRows() { return matrix.size(); }
    public int getNCols() { return matrix.get(0).size(); }
}
