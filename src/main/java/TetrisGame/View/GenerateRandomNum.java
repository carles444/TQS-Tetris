package TetrisGame.View;
import java.util.Random;
import static TetrisGame.View.Board.N_PIECES;

public class GenerateRandomNum {
    public int getRandPieceNum() {
        Random rand = new Random();
        return rand.nextInt(N_PIECES);
    }
}
