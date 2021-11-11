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

    public static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
    }

    public void start() {
        if(!isRuning) {
            timer.scheduleAtFixedRate(tick, 0, timeInterval);
            isRuning = true;
        }
    }

    public void stop() {
        if(isRuning) {
            timer.cancel();
            isRuning = false;
        }
    }

    public void gameLoop() {
        while(isRuning && !board.isEnded()) {
            clearConsole();
            System.out.println(board);
        }
    }

    public boolean gameEnd() { return board.isEnded(); }
    public int getScore() { return score; }
    public Board getBoard() { return board; }
    public boolean isRunning() { return isRuning; }

}
