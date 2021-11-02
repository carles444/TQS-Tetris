package TetrisGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TetrisGameClientTests {

    TetrisGameClient tetrisGame;

    @BeforeEach
    void setUp() {
        tetrisGame = new TetrisGameClient();
    }
    //pasword de 8 caracteres tiene que contener minusculas, mayusculas, numeros, y caracteres especiales
    @Test
    void login(){
        //el pasword correcte usuari erroni
        assertFalse(tetrisGame.createUser("loco","1eG$5dg@"));
        assertFalse( tetrisGame.createUser("CharlymikelRichartOssart","1eG$5dg@"));
        assertFalse( tetrisGame.createUser(" ","1eG$5dg@"));
        assertFalse(tetrisGame.createUser("","1eG$5dg@"));
        assertFalse( tetrisGame.createUser("Char Y","1eG$5dg@"));
        assertFalse(tetrisGame.createUser("12345","1eG$5dg@"));
        assertFalse(tetrisGame.createUser("·$&&","1eG$5dg@"));
        assertFalse( tetrisGame.createUser("Charly123123","1eG$5dg@"));
        assertFalse( tetrisGame.createUser("Charly.$&&","1eG$5dg@"));
        assertFalse( tetrisGame.createUser("Charly123123.%&&","1eG$5dg@"));
        //el pasword correcte usuari erroni
        assertFalse( tetrisGame.createUser("Charly","a"));
        assertFalse( tetrisGame.createUser("Charly",""));

        assertFalse( tetrisGame.createUser("Charly"," "));
        assertFalse( tetrisGame.createUser("Charly","aaaaaaaaa"));

        assertFalse( tetrisGame.createUser("Charly","acvd1265"));

        assertFalse( tetrisGame.createUser("Charly","ahsjdk#~€¬"));
        assertFalse( tetrisGame.createUser("Charly","1659@€¬$"));

        assertFalse( tetrisGame.createUser("Charly","akjfafngjnakjfgnkdjf"));
        assertFalse( tetrisGame.createUser("Charly","a"));
        //Correcto
        assertTrue( tetrisGame.createUser("Charly","1eG$5dg@"));










    }
}
