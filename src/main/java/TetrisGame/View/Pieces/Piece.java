package TetrisGame.View.Pieces;

public abstract class Piece {
    protected int[][] positions; //first position is the lowest row one
    public static int pieceDim = 4;

    public static int getPieceDim() {
        return pieceDim;
    }

    public Piece() {
        positions = new int[pieceDim][2];
    }
    public int[][] moveCol(int nCols){
        int[][] auxPos = clonePositions();
        for(int i = 0; i < pieceDim; i++){
            auxPos[i][1]+=nCols;
        }
        return auxPos;
    }

    public int[][] clonePositions() {
        int[][] auxPos = new int[pieceDim][2];
        for(int i = 0; i < pieceDim; i++) {
            auxPos[i][0] = positions[i][0];
            auxPos[i][1] = positions[i][1];
        }
        return auxPos;
    }

    public int[][] getPositions() {
        return positions;
    }
    public void setPositions(int[][] pos) { positions = pos; }

    public int[][] moveRow(int nRows){
        int[][] auxPos = clonePositions();
        for(int i = 0; i < pieceDim; i++){
            auxPos[i][0]+=nRows;
        }
        return auxPos;
    }

    public int[][] rotateRight() {
        return null;
    }

    public int[][] rotateLeft() {
       return null;
    }

    public String getName() {return null;}
}


