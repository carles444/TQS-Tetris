package TetrisGame;

//   0
//2  1  3
class Teewee extends Piece {
    public Teewee(int[] initPos) {
        super();
        positions[0] = initPos;
        positions[1] = new int[]{initPos[0] + 1, initPos[1]};
        positions[2] = new int[]{initPos[0] + 1, initPos[1] - 1};
        positions[3] = new int[]{initPos[0] + 1, initPos[1] + 1};
    }
}
