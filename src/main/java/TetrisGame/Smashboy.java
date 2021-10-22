package TetrisGame;

//0 1
//2 3

class Smashboy extends  Piece {
    public Smashboy(int[] initPos) {
        super();
        positions[0] = initPos;
        positions[1] = new int[]{initPos[0], initPos[1] +1};
        positions[2] = new int[]{initPos[0] + 1, initPos[1]};
        positions[3] = new int[]{initPos[0] + 1, initPos[1] + 1};
    }
}
