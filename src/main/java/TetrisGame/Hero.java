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

    @Override
    public String getName() {
        return "Hero";
    }

    @Override
    public int[][] rotateRight() {
        if (positions[0][1] == positions[1][1]) {
            positions[0][0] += 3;
            positions[0][1] -= 2;
            positions[1][0] += 2;
            positions[1][1] -= 1;
            positions[2][0] += 1;
            positions[3][1] += 1;
        } else {
            positions[0][0] -= 3;
            positions[0][1] += 2;
            positions[1][0] -= 2;
            positions[1][1] += 1;
            positions[2][0] -= 1;
            positions[3][1] -= 1;
        }
        return positions;
    }

    @Override
    public int[][] rotateLeft() {
        if (positions[0][1] == positions[1][1]) {
            positions[0][0] += 3;
            positions[0][1] -= 2;
            positions[1][0] += 2;
            positions[1][1] -= 1;
            positions[2][0] += 1;
            positions[3][1] += 1;
        } else {
            positions[0][0] -= 3;
            positions[0][1] += 2;
            positions[1][0] -= 2;
            positions[1][1] += 1;
            positions[2][0] -= 1;
            positions[3][1] -= 1;
        }
        return positions;
    }
}
