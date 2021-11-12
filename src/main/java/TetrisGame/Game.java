package TetrisGame;

import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class  Game  implements Observer {
    private Controls controls;
    private Board board;
    private Timer timer;
    private int score;
    private boolean isRuning;
    private static final long timeInterval = 500;
    public static int nRows = 20;
    public static int nCols = 10;
    TimerTask tick = new TimerTask() {
        @Override
        public void run() {
            board.movePieceDown();
        }
    };

    public Game() {
        controls = new Controls();
        controls.addObserver(this);
        board = Board.getInstance();
        gameFrame gameframe = new gameFrame();
        gameframe.addKeyListener(controls);

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
            TimerTask tick = new TimerTask() {
                @Override
                public void run() {
                    board.movePieceDown();
                }
            };
            timer = new Timer(true);
            timer.scheduleAtFixedRate(tick, 0, timeInterval);
            isRuning = true;
        }
    }

    public void stop() {
        if(isRuning) {
            timer.cancel();
            timer = null;
            isRuning = false;
        }
    }

    public void gameLoop() {
        while(isRuning && !board.isEnded()) {
            clearConsole();
            System.out.println(board);
            score = board.getNCompletedRows() * 100;
        }
    }
    @Override
    public void update(Observable o, Object arg) {
        KeyEvent e= (KeyEvent) arg;
        switch (e.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                board.movePieceRight();
                break;
            case KeyEvent.VK_LEFT:
                board.movePieceLeft();
                break;
            case KeyEvent.VK_UP:
                board.rotatePieceLeft();
                break;
            case KeyEvent.VK_DOWN:
                board.movePieceDown();
                break;

        }


    }
    public boolean gameEnd() { return board.isEnded(); }
    public int getScore() { return score; }
    public Board getBoard() { return board; }
    public boolean isRunning() { return isRuning; }

}
