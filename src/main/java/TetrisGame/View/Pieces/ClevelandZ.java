package TetrisGame.View.Pieces;

//0 1
//  2 3
public class ClevelandZ extends Piece {
    public ClevelandZ(int[] initPos) {
        super();
        positions[0] = initPos;
        positions[1] = new int[]{initPos[0], initPos[1] + 1};
        positions[2] = new int[]{initPos[0] + 1, initPos[1] + 1};
        positions[3] = new int[]{initPos[0] + 1, initPos[1] + 2};
    }

    @Override
    public String getName() {
        return "ClevelandZ";
    }

    @Override
    public int[][] rotateRight() {
        int[][] auxPos = clonePositions();
        if (positions[0][1] == positions[1][1]) {
            auxPos[0][0] += 1;
            auxPos[0][1] -= 2;
            auxPos[1][1] -= 1;
            auxPos[2][0] += 1;
            auxPos[3][1] += 1;
        } else {
            auxPos[0][0] -= 1;
            auxPos[0][1] += 2;
            auxPos[1][1] += 1;
            auxPos[2][0] -= 1;
            auxPos[3][1] -= 1;
        }
        return auxPos;
    }

    @Override
    public int[][] rotateLeft() {
        int[][] auxPos = clonePositions();
        if (positions[0][1] == positions[1][1]) {
            auxPos[0][0] += 1;
            auxPos[0][1] -= 2;
            auxPos[1][1] -= 1;
            auxPos[2][0] += 1;
            auxPos[3][1] += 1;
        } else {
            auxPos[0][0] -= 1;
            auxPos[0][1] += 2;
            auxPos[1][1] += 1;
            auxPos[2][0] -= 1;
            auxPos[3][1] -= 1;
        }
        return auxPos;
    }
}
