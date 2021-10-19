package TetrisGame;

public abstract class Piece {
    protected int[][] positions;
    protected static int pieceDim = 4;

    Piece() {
        positions = new int[pieceDim][2];
    }
    public int[][] moveCol(int nCols){
        for(int i = 0; i < pieceDim; i++){
            positions[i][1]+=nCols;
        }
        return positions;
    }

    public int[][] moveRow(int nRows){
        for(int i = 0; i < pieceDim; i++){
            positions[i][0]+=nRows;
        }
        return positions;
    }

    public int[][] rotateRight() {
        return null;
    }

    public int[][] rotateLeft() {
       return null;
    }
}


