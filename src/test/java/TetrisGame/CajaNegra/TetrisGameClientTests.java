package TetrisGame.CajaNegra;

import TetrisGame.Controller.Player;
import TetrisGame.Model.TetrisGameClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TetrisGameClientTests {

    TetrisGameClient tetrisGame;

    @BeforeEach
    void setUp() {
        tetrisGame = new TetrisGameClient();
    }
    // El nombre de usuario solo puede contener hasta 8 letras
    @Test
    void userNameFormatCorrect(){
        //vacío
        assertEquals(false,tetrisGame.isUserNameFormatCorrect(""));
        //no espacios
        assertEquals(false, tetrisGame.isUserNameFormatCorrect(" "));
        assertEquals(false, tetrisGame.isUserNameFormatCorrect("Char Y"));
        //Demasiado largo
        assertEquals(false, tetrisGame.isUserNameFormatCorrect("CharlymikelRichartOssart"));
        //Solo alphabeticos
        assertEquals(false,tetrisGame.isUserNameFormatCorrect("12345"));
        assertEquals(false,tetrisGame.isUserNameFormatCorrect("·$&&"));
        assertEquals(false, tetrisGame.isUserNameFormatCorrect("Charly123123"));
        assertEquals(false, tetrisGame.isUserNameFormatCorrect("Charly.$&&"));
        assertEquals(false, tetrisGame.isUserNameFormatCorrect("Charly123123.%&&"));
        //Correctos
        assertEquals(true,tetrisGame.isUserNameFormatCorrect("A"));
        assertEquals(true,tetrisGame.isUserNameFormatCorrect("a"));

        assertEquals(true,tetrisGame.isUserNameFormatCorrect("Josefa"));
        assertEquals(true,tetrisGame.isUserNameFormatCorrect("Maria"));
        assertEquals(true,tetrisGame.isUserNameFormatCorrect("Alberto"));



    }
    //La contraseña a de ser minino de 8 maximo 16 caracteres y tiene que contener minusculas, mayusculas, numeros, y caracteres especiales
    @Test
    void passwordFormatCorrect()
    {
        //vacío
        assertEquals(false, tetrisGame.isPasswordFormatCorrect(""));
        //no espacios
        assertEquals(false,tetrisGame.isPasswordFormatCorrect(" "));
        // muy corto
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("a"));
        assertEquals(false, tetrisGame.isUserNameFormatCorrect("a45$"));
        assertEquals(false, tetrisGame.isUserNameFormatCorrect("aA@1bB$"));
        //muy largos
        assertEquals(false, tetrisGame.isUserNameFormatCorrect("aaaaAAAA@@@111bbbBBBB$$$$"));

        //solo minusculas
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("aaaaaaaaa"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("abcdefghi"));
        //solo mayuculas
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("AAAAAAAAA"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("ABCDEFGHI"));
        //solo numeros
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("111111111"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("123456789"));
        //solo caracteres especiales
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("@@@@@@@@@@@"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("@¬)(=?¿&%$"));

        //les faltan dos tipos
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("aaaaaAAAAA"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("aaaaa11111"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("aaaaa@@@@@"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("AAAAA111111"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("AAAAA@@@@@@"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("11111@@@@@"));

        //les faltan un tipo
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("aaaaaAAAAA@@@@@@@"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("aaaaaAAAAA111111"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("AAAAA111111@@@@@@"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("11111@@@@@aaaaaaaa"));
        assertEquals(false, tetrisGame.isPasswordFormatCorrect("11111@@@@@AAAAAA"));


        //correcto
        assertEquals(true, tetrisGame.isPasswordFormatCorrect("11@@AAaa"));
        assertEquals(true, tetrisGame.isPasswordFormatCorrect("222$$$BBBbbb"));
        assertEquals(true, tetrisGame.isPasswordFormatCorrect("aA@1sS$2oO*0"));
        assertEquals(true, tetrisGame.isPasswordFormatCorrect("aAbB123$%&"));
        assertEquals(true, tetrisGame.isPasswordFormatCorrect("1234%&aB"));





    }

    @Test
    void puntuationFormatCorrect(){
        assertEquals(false, tetrisGame.isPuntuationFormatCorrect(-34444444));
        assertEquals(false, tetrisGame.isPuntuationFormatCorrect(-5));
        assertEquals(false, tetrisGame.isPuntuationFormatCorrect(-1));

        assertEquals(true, tetrisGame.isPuntuationFormatCorrect(0));
        assertEquals(true, tetrisGame.isPuntuationFormatCorrect(1));
        assertEquals(true, tetrisGame.isPuntuationFormatCorrect(10));
        assertEquals(true, tetrisGame.isPuntuationFormatCorrect(500000));
        assertEquals(true, tetrisGame.isPuntuationFormatCorrect(999998));
        assertEquals(true, tetrisGame.isPuntuationFormatCorrect(999999));
        assertEquals(false, tetrisGame.isPuntuationFormatCorrect(1000000));
        assertEquals(false, tetrisGame.isPuntuationFormatCorrect(2000000));

    }
    @Test
    void registerUser() throws IOException {
        File file= new File(tetrisGame.getUSER_FILE());
        file.delete();
        assertEquals(true, tetrisGame.registerUser("Carlos","1eG$5dg@"));
        assertEquals(true ,tetrisGame.registerUser("Ivan","2fG$6dg@"));
        assertEquals(true ,tetrisGame.registerUser("David","3gG$7dg@"));
        assertEquals(true ,tetrisGame.registerUser("Miguel","4hG$8dg@"));

        assertEquals(false, tetrisGame.registerUser("Carlos","1eG$5dg@"));
        assertEquals(false ,tetrisGame.registerUser("Ivan","2fG$6dg@"));
        assertEquals(false ,tetrisGame.registerUser("David","3gG$7dg@"));
        assertEquals(false ,tetrisGame.registerUser("Miguel","4hG$8dg@"));


    }
    @Test
    void login() throws FileNotFoundException {
        assertEquals(true, tetrisGame.login("Estevan","1eG$5dg"));
        assertEquals(true ,tetrisGame.login("Julian","2fG$6dg@"));
        assertEquals(true ,tetrisGame.login("Aurelio","3gG$7dg@"));
        assertEquals(true ,tetrisGame.login("Cristian","4hG$8dg@"));
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
    @Test
    void savePuntuation() throws IOException {
        File file= new File(tetrisGame.getUSER_PUNTUATION());
        file.delete();


        assertEquals(true, tetrisGame.savePuntuation(new Player("Estevan"),50000));
        assertEquals(true ,tetrisGame.savePuntuation(new Player("Julian"),50000));
        assertEquals(true ,tetrisGame.savePuntuation(new Player("Aurelio"),50000));
        assertEquals(true ,tetrisGame.savePuntuation(new Player("Cristian"),50000));
        //El valor actual no supera al anteriors
        assertEquals(false, tetrisGame.savePuntuation(new Player("Estevan"),100));
        assertEquals(false ,tetrisGame.savePuntuation(new Player("Julian"),100));
        assertEquals(false ,tetrisGame.savePuntuation(new Player("Aurelio"),100));
        assertEquals(false ,tetrisGame.savePuntuation(new Player("Cristian"),100));

        //formatos erroneos
        assertEquals(false, tetrisGame.savePuntuation(new Player("Estevan"),-34444444));
        assertEquals(false ,tetrisGame.savePuntuation(new Player("Julian"),-5));
        assertEquals(false ,tetrisGame.savePuntuation(new Player("Aurelio"),-1));
        assertEquals(false ,tetrisGame.savePuntuation(new Player("Cristian"),1000000));
        assertEquals(false ,tetrisGame.savePuntuation(new Player("Cristian"),2000000));



    }


}
