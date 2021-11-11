package TetrisGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;


public class Controls extends Observable implements KeyListener  {


  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    notifyObservers(e);
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
