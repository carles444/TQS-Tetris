package TetrisGame;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MockControls {
  Robot roobot= new Robot();

  public MockControls() throws AWTException {
  }

  public void pressKeyRight(){
    roobot.keyPress(KeyEvent.VK_RIGHT);
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
