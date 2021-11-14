package TetrisGame.CajaNegra;

import TetrisGame.Controller.Controls;
import TetrisGame.Controller.Game;
import TetrisGame.Mock.MockControls;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;
import java.awt.event.KeyEvent;
import static org.junit.jupiter.api.Assertions.*;


public class ControlsTests {
  Game game;
  @BeforeEach
  void setUp() throws AWTException {
    //controls= Controls.getInstance();
    game=new Game();
  }

  @Test
  public void presskey() throws AWTException, InterruptedException {
    Controls controls=new Controls();
    MockControls mockControls=new MockControls();;

    //Creating and adding the key listener
    game=new Game();
    int[][] initPos = game.getBoard().getPiece().clonePositions();

    game.getCojtrols().pressKeyRight();
    assertEquals(false, GameTests.equalPositions(initPos, game.getBoard().getPiece().getPositions()));
    mockControls.pressKeyLeft();

    assertEquals(false, GameTests.equalPositions(initPos, game.getBoard().getPiece().getPositions()));
    mockControls.pressKeyUp();
    assertEquals(false, GameTests.equalPositions(initPos, game.getBoard().getPiece().getPositions()));
    mockControls.pressKeyDown();
    assertEquals(false, GameTests.equalPositions(initPos, game.getBoard().getPiece().getPositions()));
  }



}
