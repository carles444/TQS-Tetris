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
    @Test
    void setScore(){
        assertEquals(false, player.setTopScore(-34444444));
        assertEquals(false, player.setTopScore(-5));
        assertEquals(false, player.setTopScore(-1));

        assertEquals(true, player.setTopScore(0));
        assertEquals(true, player.setTopScore(1));
        assertEquals(true, player.setTopScore(10));
        assertEquals(true, player.setTopScore(500000));
        assertEquals(true, player.setTopScore(999998));
        assertEquals(true, player.setTopScore(999999));
        assertEquals(false, player.setTopScore(1000000));
        assertEquals(false, player.setTopScore(2000000));





    }

}
