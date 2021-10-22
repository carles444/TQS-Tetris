package TetrisGame;

//0 1
//  2 3
class ClevelandZ extends Piece {
    ClevelandZ(int[] initPos) {
        super();
        positions[0] = initPos;
        positions[1] = new int[]{initPos[0], initPos[1] + 1};
        positions[2] = new int[]{initPos[0] + 1, initPos[1] + 1};
        positions[3] = new int[]{initPos[0] + 1, initPos[1] + 2};
    }
}
