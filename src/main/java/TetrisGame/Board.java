package TetrisGame;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.Timer;
import java.util.TimerTask;

import static TetrisGame.Piece.pieceDim;

public class Board {
    public static final int N_PIECES = 7;
    private final List<List<Integer>> matrix;
    private Piece piece;
    //private Timer timer;
    private static final long timeInterval = 500; //millis
    private int nPieces;
    private int nCompletedRows;


    //TODO: method that checks if the piece touches ground or any piece going down

    public Board(int nRows, int nCols) {
        nPieces = 0;
        nCompletedRows = 0;
        matrix = new ArrayList<>();
        for(int i = 0; i < nRows; i++) {
            matrix.add(new ArrayList<Integer>());
            for(int j = 0; j < nCols; j++) {
                matrix.get(i).add(0);
            }
        }
        TimerTask tick = new TimerTask() {
            @Override
            public void run() {
                movePieceDown();
            }
        };
        //timer = new Timer(true);
        piece = generateRandomPiece();
        //every 0.5 secs moves the piece one row down
        //timer.scheduleAtFixedRate(tick, 0, timeInterval);
    }

    private Piece generateRandomPiece() {
        GenerateRandomNum rand = new MockGenerateRandomNum(); //TODO: mockObject
        nPieces++;
        switch (rand.getRandPieceNum()) {
            case 0:
                return new OrangeRicky(new int[]{0, 5});
            case 1:
                return new BlueRicky(new int[]{0, 5});
            case 2:
                return new ClevelandZ(new int[]{0, 6});
            case 3:
                return new RhodeIslandZ(new int[]{0, 5});
            case 4:
                return new Hero(new int[]{0, 5});
            case 5:
                return new Teewee(new int[]{0, 5});
            case 6:
                return new Smashboy(new int[]{0, 5});
            default:
                nPieces--;
                return null;
        }
    }


    private boolean fitsBoard(int[][] positions) {
        for(int[] pos : positions) {
            if(pos[0] >= getNRows() || pos[1] >= getNCols())
                return false;
            if(pos[0] < 0 || pos[1] < 0)
                return false;
            if(matrix.get(pos[0]).get(pos[1]) == 1)
                return false;
        }
        return true;
    }


    //tries to move the piece nPositions
    public boolean movePieceRight() {
        int[][] dest = piece.moveCol(1);
        if(fitsBoard(dest)) {
            piece.setPositions(dest);
            return true;
        }
        return false;
    }

    public boolean movePieceLeft() {
        int[][] dest = piece.moveCol(-1);
        if(fitsBoard(dest)) {
            piece.setPositions(dest);
            return true;
        }
        return false;
    }

    public boolean movePieceDown() {
        int[][] dest = piece.moveRow(1);
        if(fitsBoard(dest)) {
            piece.setPositions(dest);
            return true;
        }
        else { //piece touches ground and generates new piece
            for(int[] pos : piece.getPositions()) {
                matrix.get(pos[0]).set(pos[1], 1);
            }
            piece = generateRandomPiece();
        }
        return false;
    }

    public boolean movePieceUp() {
        int[][] dest = piece.moveRow(-1);
        if(fitsBoard(dest)) {
            piece.setPositions(dest);
            return true;
        }
        return false;
    }


    //move the piece until is it possible 1 by 1
    public void movePieceNCols(int nPos) {
        boolean right = nPos > 0;
        if(right) {
            for (int i = 0; i < nPos; i++) {
                if (!movePieceRight())
                    return;
            }
        }
        else {
            nPos = -nPos;
            for (int i = 0; i < nPos; i++) {
                if (!movePieceLeft())
                    return;
            }
        }
    }

    public void movePieceNRows(int nPos) {
        boolean down = nPos > 0;
        if(down) {
            for (int i = 0; i < nPos; i++) {
                if (!movePieceDown())
                    return;
            }
        }
        else {
            nPos = -nPos;
            for (int i = 0; i < nPos; i++) {
                if (!movePieceUp())
                    return;
            }
        }
    }

    //fix the position when the piece rotates if its needed
    public void fixPosition(int[][] positions) {
        int rowM = 0, colM = 0;
        if(fitsBoard(positions))
            return;
        for(int i = 0; i < pieceDim; i++) {
            if(positions[i][0] >= getNRows()) {
                rowM = (getNRows() - 1) - positions[i][0];
            }
            else if(positions[i][0] < 0) {
                rowM = (-positions[i][0]);
            }
            else if(positions[i][1] >= getNCols()) {
                colM = ((getNCols() - 1) - positions[i][1]);
            }
            else if(positions[i][1] < 0) {
                colM = (-positions[i][1]);
            }
            if(colM!=0 || rowM!=0) {
                for(int j = 0; j < pieceDim; j++) {
                    positions[j][0] += rowM;
                    positions[j][1] += colM;
                }
                rowM = 0;
                colM = 0;
            }
        }
    }

    public void rotatePieceRight() {
        int[][] dest = piece.rotateRight();
        fixPosition(dest);
        if(fitsBoard(dest)) {
            piece.setPositions(dest);
        }
    }

    public void rotatePieceLeft() {
        int[][] dest = piece.rotateLeft();
        fixPosition(dest);
        if(fitsBoard(dest)) {
            piece.setPositions(dest);
        }
    }

    private void deleteRow(int row) {
        for(int i = row; i > 1; i--) {
            for(int j = 0; j < getNCols(); j++) {
                matrix.get(i).set(j, matrix.get(i-1).get(j));
            }
        }
        for(int j = 0; j < getNCols(); j++) {
            matrix.get(0).set(j, 0);
        }
    }

    public void deleteFullRows() {
        for(int i = 0; i < getNRows(); i++) {
            boolean full = true;
            for(int j = 0; j < getNCols(); j++) {
                if(matrix.get(i).get(j) == 0) {
                    full = false;
                    break;
                }
            }
            if(full) {
                deleteRow(i);
                nCompletedRows++;
            }
        }
    }

    public List<List<Integer>> getMat() { return matrix; }
    public Piece getPiece() { return piece; }
    public int getNRows() { return matrix.size(); }
    public int getNCols() { return matrix.get(0).size(); }
    public int getNPieces() { return nPieces; }
    public int getNCompletedRows() { return nCompletedRows; }

    public String toString() {
        StringBuilder out = new StringBuilder();
        for(int[] pos : piece.getPositions()) {
            matrix.get(pos[0]).set(pos[1], 1);
        }

        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                if (integer == 1) {
                    out.append("  0");
                }
            }
            out.append("\n");
        }

        for(int[] pos : piece.getPositions()) {
            matrix.get(pos[0]).set(pos[1], 0);
        }

        return out.toString();
    }
}
