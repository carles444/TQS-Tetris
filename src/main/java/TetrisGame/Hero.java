package TetrisGame;

//0 1 2 3

class Hero extends Piece {
    Hero(int[] initPos) {
        super();
        positions[0] = initPos;
        positions[1] = new int[]{initPos[0], initPos[1] + 1};
        positions[2] = new int[]{initPos[0], initPos[1] + 2};
        positions[3] = new int[]{initPos[0], initPos[1] + 3};
    }
}
