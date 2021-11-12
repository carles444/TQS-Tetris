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
    private boolean ended;
    private static final long timeInterval = 1500;
    public static int nRows = 20;
    public static int nCols = 10;


    public Game() {
        ended = false;
        controls = new Controls();
        controls.addObserver(this);
        board = Board.getInstance();
        gameFrame gameframe = new gameFrame();
        gameframe.addKeyListener(controls);

        score = 0;
        isRuning = false;
        startGameLoop();
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

    public void startGameLoop() {
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
        gameLoop();
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
        while(!ended && !board.isEnded()) {
            clearConsole();
            System.out.println(board);
            score = board.getNCompletedRows() * 100;
        }
    }
    @Override
    public void update(Observable o, Object arg) {

        KeyEvent e = (KeyEvent) arg;
        if (!isRuning) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
                start();
            return;
        }
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
            case KeyEvent.VK_ESCAPE:
                ended = true;
                break;
            case KeyEvent.VK_SPACE:
                if (isRuning) {
                    stop();
                } else {
                    start();
                }
                break;
        }


    }
    public boolean gameEnd() { return ended; }
    public int getScore() { return score; }
    public Board getBoard() { return board; }
    public boolean isRunning() { return isRuning; }

}
