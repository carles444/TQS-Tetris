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
}

class OrangeRicky extends Piece {

}

class BlueRicky extends Piece {
    BlueRicky(int[] initPos) {
        super();
        positions[0] = initPos;
        positions[1] = new int[]{initPos[0]+1, initPos[1]};
        positions[2] = new int[]{initPos[0]+1, initPos[1]+1};
        positions[3] = new int[]{initPos[0]+1, initPos[1]+2};
    }
}

class ClevelandZ extends  Piece {

}

class Rhodelsland extends Piece {

}

class Hero extends Piece {

}

class Teewee extends  Piece {

}

class Smashboy extends  Piece {

}