package TetrisGame;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;
import java.awt.event.KeyEvent;
import static org.junit.jupiter.api.Assertions.*;


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

    //Creating and adding the key listener
    game=new Game();
    int[][] initPos = game.getBoard().getPiece().clonePositions();
    mockControls=new MockControls();
    Robot robot =new Robot();
    robot.keyPress(KeyEvent.VK_RIGHT);
    assertEquals(false, GameTests.equalPositions(initPos, game.getBoard().getPiece().getPositions()));

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
