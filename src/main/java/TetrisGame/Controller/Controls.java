package TetrisGame.Controller;

import javax.swing.*;
import java.awt.*;
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
  public void pressKeyRight(){
    Thread t = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        // try catch for forcing Escape key press
        try {
          Robot robObject = new Robot();
          robObject.keyPress(KeyEvent.VK_RIGHT);
        } catch (AWTException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }

      }
    });



  }

}
