package TetrisGame;

//   1 0
// 3 2
class Rhodelsland extends Piece {
    Rhodelsland(int[] initPos) {
        super();
        positions[0] = initPos;
        positions[1] = new int[]{initPos[0], initPos[1] - 1};
        positions[2] = new int[]{initPos[0] + 1, initPos[1] - 1};
        positions[3] = new int[]{initPos[0] + 1, initPos[1] - 2};

    }
}
