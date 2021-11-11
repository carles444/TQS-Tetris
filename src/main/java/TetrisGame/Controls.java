package TetrisGame;

import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class Controls implements KeyListener {
    private Timer timer;




    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public boolean keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_UP){
        System.out.println("asfashfjdskfaj");}
        return true;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
