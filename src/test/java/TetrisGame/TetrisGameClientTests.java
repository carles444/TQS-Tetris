package TetrisGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


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
        assertEquals(false, tetrisGame.createUser("CharlymikelRichartOssart","1eG$5dg@"));
        assertEquals(false, tetrisGame.createUser(" ","1eG$5dg@"));
        assertEquals(false,tetrisGame.createUser("","1eG$5dg@"));
        assertEquals(false, tetrisGame.createUser("Char Y","1eG$5dg@"));
        assertEquals(false,tetrisGame.createUser("12345","1eG$5dg@"));
        assertEquals(false,tetrisGame.createUser("·$&&","1eG$5dg@"));
        assertEquals(false, tetrisGame.createUser("Charly123123","1eG$5dg@"));
        assertEquals(false, tetrisGame.createUser("Charly.$&&","1eG$5dg@"));
        assertEquals(false, tetrisGame.createUser("Charly123123.%&&","1eG$5dg@"));
        //el pasword correcte usuari erroni
        assertEquals(false, tetrisGame.createUser("Charly","a"));
        assertEquals(false, tetrisGame.createUser("Charly",""));

        assertEquals(false,tetrisGame.createUser("Charly"," "));
        assertEquals(false, tetrisGame.createUser("Charly","aaaaaaaaa"));

        assertEquals(false, tetrisGame.createUser("Charly","acvd1265"));

        assertEquals(false, tetrisGame.createUser("Charly","ahsjdk#~€¬"));
        assertEquals(false, tetrisGame.createUser("Charly","1659@€¬$"));

        assertEquals(false, tetrisGame.createUser("Charly","akjfafngjnakjfgnkdjf"));
        assertEquals(false, tetrisGame.createUser("Charly","a"));
        //Correcto
        assertEquals(true, tetrisGame.createUser("Charly","1eG$5dg@"));
        assertEquals(true,tetrisGame.createUser("loco","1eG$5dg@"));










    }
}
