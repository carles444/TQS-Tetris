package TetrisGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlsTests {
    Controls controls;
    @BeforeEach
    void setUp() {
        controls = new Controls();
    }

    @Test
    void pressKey() throws AWTException {
        Robot r = new Robot();
r.keyPress(KeyEvent.VK_DOWN);
        //assertEquals(false, controls.keyPressed(KeyEvent e));

    }
}
