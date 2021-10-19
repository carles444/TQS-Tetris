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
    @Override
    public int[][] rotateRight() {
        if(positions[0][1] == positions[1][1]) {
            if(positions[0][0] < positions[1][0]) {
                positions[0][1] += 2;
                positions[1][0] -= 1;
                positions[1][1] += 1;
                positions[3][0] += 1;
                positions[3][1] -= 1;
            }
            else {
                positions[0][1] -= 2;
                positions[1][0] += 1;
                positions[1][1] -= 1;
                positions[3][0] -= 1;
                positions[3][1] += 1;
            }
        }
        else {
            if(positions[0][1] < positions[1][1]) {
                positions[0][0] -= 2;
                positions[1][0] -= 1;
                positions[1][1] -= 1;
                positions[3][0] += 1;
                positions[3][1] += 1;
            }
            else {
                positions[0][0] += 2;
                positions[1][0] += 1;
                positions[1][1] += 1;
                positions[3][0] -= 1;
                positions[3][1] -= 1;
            }
        }
        return positions;
    }


    @Override
    public int[][] rotateLeft() {
        if(positions[0][1] == positions[1][1]) {
            if(positions[0][0] < positions[1][0]) {
                positions[0][0] += 2;
                positions[1][0] += 1;
                positions[1][1] += 1;
                positions[3][0] -= 1;
                positions[3][1] -= 1;
            }
            else {
                positions[0][0] -= 2;
                positions[1][0] -= 1;
                positions[1][1] -= 1;
                positions[3][0] += 1;
                positions[3][1] += 1;
            }
        }
        else {
            if(positions[0][1] < positions[1][1]) {
                positions[0][1] += 2;
                positions[1][0] -= 1;
                positions[1][1] += 1;
                positions[3][0] += 1;
                positions[3][1] -= 1;
            }
            else {
                positions[0][1] -= 2;
                positions[1][0] += 1;
                positions[1][1] -= 1;
                positions[3][0] -= 1;
                positions[3][1] += 1;
            }
        }
        return positions;
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