package TetrisGame.Controller;

import TetrisGame.View.Board;

import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class  Game  implements Observer {
    private Controls controls;
    GameFrame gameframe;
    private Board board;
    private Timer timer;
    private int score;
    private boolean isRunning;
    private boolean ended;
    private boolean gameLoop;
    private boolean testing;
    private static final long timeInterval = 1500;
    public static int nRows = 20;
    public static int nCols = 10;


    public Game() {
        testing = false;
        gameLoop = false;
        ended = false;
        controls = new Controls();
        controls.addObserver(this);
        board = Board.getInstance();
        gameframe = new GameFrame();
        gameframe.addKeyListener(controls);

        score = 0;
        isRunning = false;
    }

    public Controls getCojtrols() {
        return controls;
    }

    /*
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

        */
    public void start() {
        if(!isRunning) {
            TimerTask tick = new TimerTask() {
                @Override
                public void run() {
                    board.movePieceDown();
                }
            };
            timer = new Timer(true);
            timer.scheduleAtFixedRate(tick, 0, timeInterval);
            isRunning = true;
        }
        if(!gameLoop && !testing) {
            gameLoop = true;
            gameLoop();
        }
    }

    public void stop() {
        if(isRunning) {
            timer.cancel();
            timer = null;
            isRunning = false;
        }
    }

    public void gameLoop() {
        while(!ended && !board.isEnded()) {
            //clearConsole();
            System.out.println(this);
            score = board.getNCompletedRows() * 100;
        }
        gameframe.end();
    }

    @Override
    public void update(Observable o, Object arg) {
        KeyEvent e = (KeyEvent) arg;
        if (!isRunning) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
                start();
            else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                stop();
                ended = true;
            }
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
                stop();
                ended = true;
                break;
            case KeyEvent.VK_SPACE:
                stop();
                break;
        }


    }
    public void enableTesting() { testing = true; }
    public void disableTesting() { testing = false; }
    public boolean gameEnd() { return ended || board.isEnded(); }
    public int getScore() { return score; }
    public Board getBoard() { return board; }
    public boolean isRunning() { return isRunning; }
    public Controls getControls() {
        if(testing)
            return controls;
        else
            return null;
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("            TETRIS GAME\n\n");
        if(isRunning) {
            out.append("Game Running\n");
        } else {
            out.append("Game Stopped\n");
        }
        out.append("Score: ").append(getScore()).append("\n\n");
        out.append(board.toString());
        return out.toString();
    }

}
