package TetrisGame;

import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import static org.junit.jupiter.api.Assertions.*;

public class TetrisGameClientTests {

    TetrisGameClient tetrisGame;

    @BeforeEach
    void setUp() {
        tetrisGame = new TetrisGameClient();
    }
    // El nombre de usuario solo puede contener hasta 8 letras
    @Test
    void userNameFormatCorrect(){
        assertEquals(false, tetrisGame.isUserNameFormatCorrect("CharlymikelRichartOssart"));
        assertEquals(false, tetrisGame.isUserNameFormatCorrect(" "));
        assertEquals(false,tetrisGame.isUserNameFormatCorrect(""));
        assertEquals(false, tetrisGame.isUserNameFormatCorrect("Char Y"));
        assertEquals(false,tetrisGame.isUserNameFormatCorrect("12345"));
        assertEquals(false,tetrisGame.isUserNameFormatCorrect("·$&&"));
        assertEquals(false, tetrisGame.isUserNameFormatCorrect("Charly123123"));
        assertEquals(false, tetrisGame.isUserNameFormatCorrect("Charly.$&&"));
        assertEquals(false, tetrisGame.isUserNameFormatCorrect("Charly123123.%&&"));

    }
    //La contraseña a de ser de 8 caracteres y tiene que contener minusculas, mayusculas, numeros, y caracteres especiales
    @Test
    void passwordFormatCorrect()
    {
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("a"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect(""));
        assertEquals(false,tetrisGame.isPasswordFormatCorrect(" "));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("aaaaaaaaa"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("acvd1265"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("ahsjdk#~€¬"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("1659@€¬$"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("akjfafngjnakjfgnkdjf"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("1eG$5dg@"));


    }
    @Test
    void createUser() throws IOException, ParseException {
        //assertEquals(true, tetrisGame.createUser("Charly","1eG$5dg@"));
        assertEquals(false ,tetrisGame.createUser("loco","1eG$5dg@"));
    }
    
}
