package TetrisGame;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ControlsTests {
  Controls controls;
  Game game;
  MockControls mockControls;
  @BeforeEach
  void setUp() throws AWTException {
    //controls= Controls.getInstance();
    game=new Game();
    mockControls=new MockControls();
  }

  @Test
  public void presskey() throws AWTException {
    Frame f = new Frame("Demo");
    f.setLayout(new FlowLayout());
    f.setSize(0, 0  );
    Label l = new Label();
    l.setText("This is a demonstration");
    f.add(l);
    f.setVisible(true);

    //Creating and adding the key listener

    game=new Game();

    controls= new Controls();
    controls.addObserver(game.getBoard());


    f.addKeyListener(controls);

    mockControls=new MockControls();
    //game.start();
    Robot roobot=new Robot();
    roobot.keyPress(KeyEvent.VK_RIGHT);
    //mockControls.pressKeyRight();



  }

  public static void main(String[] args)
  {
    //Setting the frame and labels
    Frame f = new Frame("Demo");
    f.setLayout(new FlowLayout());
    f.setSize(200, 200);
    Label l = new Label();
    l.setText("This is a Game");
    f.add(l);
    f.setVisible(true);

    //Creating and adding the key listener
    //Controls k =Controls.getInstance();
    //f.addKeyListener(k);
  }

}
