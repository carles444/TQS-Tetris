package TetrisGame.Mock;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MockControls {
  Robot roobot;

  public MockControls() throws AWTException {
    roobot= new Robot();
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
  public void pressKeyLeft(){
    roobot.keyPress(KeyEvent.VK_LEFT);
  }
  public void pressKeyUp(){
    roobot.keyPress(KeyEvent.VK_UP);
  }
  public void pressKeyDown(){
    roobot.keyPress(KeyEvent.VK_DOWN);
  }
}
