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
    mockControls.pressKeyRight();
    assertEquals(true, GameTests.equalPositions(initPos, game.getBoard().getPiece().getPositions()));
    mockControls.pressKeyLeft();

    assertEquals(true, GameTests.equalPositions(initPos, game.getBoard().getPiece().getPositions()));
    mockControls.pressKeyUp();
    assertEquals(true, GameTests.equalPositions(initPos, game.getBoard().getPiece().getPositions()));
    mockControls.pressKeyDown();
    assertEquals(true, GameTests.equalPositions(initPos, game.getBoard().getPiece().getPositions()));
  }



}
