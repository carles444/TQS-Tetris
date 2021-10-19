package TetrisGame;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlayerTests {

    Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    void Player() {

        assertEquals(true, player.setName("Charly"));
        assertEquals(false, player.setName("CharlymikelRichartOssart"));

        assertEquals(false, player.setName(" "));
        assertEquals(false, player.setName(""));

        assertEquals(false, player.setName("Char Y"));


        assertEquals(false, player.setName("12345"));

        assertEquals(false, player.setName("·$&&"));

        assertEquals(false, player.setName("Charly123123"));

        assertEquals(false, player.setName("Charly.$&&"));

        assertEquals(false, player.setName("Charly123123.%&&"));

    }

}
