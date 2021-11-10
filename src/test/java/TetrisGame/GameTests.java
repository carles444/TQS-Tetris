package TetrisGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


public class GameTests {
    Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, game.getScore());
        assertNotNull(game.getBoard());
        assertEquals(true, game.isRunning());
    }
}
