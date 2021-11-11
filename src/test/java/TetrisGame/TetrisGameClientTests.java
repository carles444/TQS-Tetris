package TetrisGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
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
    void createUser() throws IOException {
        assertEquals(true, tetrisGame.createUser("Carlos","1eG$5dg@"));
        assertEquals(true ,tetrisGame.createUser("Ivan","2fG$6dg@"));
        assertEquals(true ,tetrisGame.createUser("David","3gG$7dg@"));
        assertEquals(true ,tetrisGame.createUser("Miguel","4hG$8dg@"));

        assertEquals(false, tetrisGame.createUser("Carlos","1eG$5dg@"));
        assertEquals(false ,tetrisGame.createUser("Ivan","2fG$6dg@"));
        assertEquals(false ,tetrisGame.createUser("David","3gG$7dg@"));
        assertEquals(false ,tetrisGame.createUser("Miguel","4hG$8dg@"));


    }
    @Test
    void login() throws FileNotFoundException {
        assertEquals(true, tetrisGame.login("Carlos","1eG$5dg@"));
        assertEquals(true ,tetrisGame.login("Ivan","2fG$6dg@"));
        assertEquals(true ,tetrisGame.login("David","3gG$7dg@"));
        assertEquals(true ,tetrisGame.login("Miguel","4hG$8dg@"));
//contraseña incorrecta
        assertEquals(false, tetrisGame.login("Carlos","0aA$5dg@"));
        assertEquals(false ,tetrisGame.login("Ivan","0aA$6dg@"));
        assertEquals(false ,tetrisGame.login("David","0aA$7dg@"));
        assertEquals(false ,tetrisGame.login("Miguel","0aA$8dg@"));
//usuario incorrecta

        assertEquals(false, tetrisGame.login("Maria","1eG$5dg@"));
        assertEquals(false ,tetrisGame.login("Carmen","2fG$6dg@"));
        assertEquals(false ,tetrisGame.login("Andrea","3gG$7dg@"));
        assertEquals(false ,tetrisGame.login("Estela","4hG$8dg@"));
    }
}
