package TetrisGame;

import java.util.Timer;
import java.util.TimerTask;

public class Game {
    private Board board;
    private Timer timer;
    private int score;
    private boolean isRuning;
    private static long timeInterval = 500;
    public static int nRows = 20;
    public static int nCols = 10;
    TimerTask tick = new TimerTask() {
        @Override
        public void run() {
            board.movePieceDown();
        }
    };

    public Game() {
        board = Board.getInstance();
        score = 0;
        isRuning = true;
        timer = new Timer(true);

        timer.scheduleAtFixedRate(tick, 0, timeInterval);
    }

    public void start() {
        timer.scheduleAtFixedRate(tick, 0, timeInterval);
    }

    public void stop() {
        timer.cancel();
    }

    public void gameLoop() {

    }

    public boolean gameEnd() { return board.isEnded(); }
    public int getScore() { return score; }
    public Board getBoard() { return board; }
    public boolean isRunning() { return isRuning; }

}
