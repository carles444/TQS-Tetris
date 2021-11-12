package TetrisGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;


public class Controls extends  Observable implements KeyListener {

 public Controls(){

 }

  @Override
  public void keyTyped(KeyEvent e) {

    int a=0;
  }

  @Override
  public void keyPressed(KeyEvent e) {
    setChanged();

    notifyObservers(e);
  }

  @Override
  public void keyReleased(KeyEvent e) {

    int a=0;
  }


}
