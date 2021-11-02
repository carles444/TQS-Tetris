package TetrisGame;

//   1 0
// 3 2
class RhodeIslandZ extends Piece {
    RhodeIslandZ(int[] initPos) {
        super();
        positions[0] = initPos;
        positions[1] = new int[]{initPos[0], initPos[1] - 1};
        positions[2] = new int[]{initPos[0] + 1, initPos[1] - 1};
        positions[3] = new int[]{initPos[0] + 1, initPos[1] - 2};

    }

    @Override
    public int[][] rotateRight() {
        if (positions[0][1] == positions[1][1]) {
            positions[0][0] -= 1;
            positions[0][1] += 1;
            positions[2][0] += 1;
            positions[2][1] += 1;
            positions[3][0] += 2;
        } else {
            positions[0][0] += 1;
            positions[0][1] -= 1;
            positions[2][0] -= 1;
            positions[2][1] -= 1;
            positions[3][0] -= 2;
        }
        return positions;
    }

    @Override
    public int[][] rotateLeft() {
        if (positions[0][1] == positions[1][1]) {
            positions[0][0] -= 1;
            positions[0][1] += 1;
            positions[2][0] += 1;
            positions[2][1] += 1;
            positions[3][0] += 2;
        } else {
            positions[0][0] += 1;
            positions[0][1] -= 1;
            positions[2][0] -= 1;
            positions[2][1] -= 1;
            positions[3][0] -= 2;
        }
        return positions;
    }
}
