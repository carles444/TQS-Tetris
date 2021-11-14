package TetrisGame.CajaBlanca;


import TetrisGame.Model.TetrisGameClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TetrisGameClientCajaBlancaTests {
  TetrisGameClient tetrisGame;

  @BeforeEach
  void setUp() {
    tetrisGame = new TetrisGameClient();
  }

  // El nombre de usuario solo puede contener hasta 8 letras
  @Test
  void userNameFormatCorrect(){
    // camino 1.1 if->isEmptyOrCantainScape()->empty-> return false
    assertEquals(false,tetrisGame.isUserNameFormatCorrect(""));
    //camino 1.2 if->isEmptyOrCantainScape()->contains(" ")-> return false
    assertEquals(false, tetrisGame.isUserNameFormatCorrect(" "));
    assertEquals(false, tetrisGame.isUserNameFormatCorrect("Char Y"));
    //camino 2 if->not isEmptyOrCantainScape()-> but leng>8 -> return false
    assertEquals(false, tetrisGame.isUserNameFormatCorrect("CharlymikelRichartOssart"));
    //camino 3.1 if->not isEmptyOrCantainScape()-> not leng>8 ->if-> but contains number -> return false
    assertEquals(false,tetrisGame.isUserNameFormatCorrect("12345"));
    assertEquals(false, tetrisGame.isUserNameFormatCorrect("Charly123123"));
    //camino 3.2 if->not isEmptyOrCantainScape()-> not leng>8 ->if-> but contains especialCaracter -> return false
    assertEquals(false,tetrisGame.isUserNameFormatCorrect("·$&&"));
    assertEquals(false, tetrisGame.isUserNameFormatCorrect("Charly.$&&"));
    //camino 3.3 if->not isEmptyOrCantainScape()-> not leng>8 ->if-> but contains especialCaracter and number -> return false
    assertEquals(false, tetrisGame.isUserNameFormatCorrect("Charly123123.%&&"));
    //camino 4 if->not isEmptyOrCantainScape()-> not leng>8 ->if-> only alphabetic -> return true
    assertEquals(true, tetrisGame.isUserNameFormatCorrect("Charly"));
  }


  //La contraseña a de ser minino de 8 caracteres y tiene que contener minusculas, mayusculas, numeros, y caracteres especiales
  @Test
  void passwordFormatCorrect()
  {

    // camino 1.1 if->isEmptyOrCantainScape()->empty-> return false
    assertEquals(false,tetrisGame.isPasswordFormatCorrect(""));
    //camino 1.2 if->isEmptyOrCantainScape()->contains(" ")-> return false
    assertEquals(false, tetrisGame.isPasswordFormatCorrect(" "));
    assertEquals(false, tetrisGame.isPasswordFormatCorrect("a45$ Y"));
    //camino 2.1 if->not isEmptyOrCantainScape()-> but not isIncorrectLenght() -> return false
    assertEquals(false, tetrisGame.isUserNameFormatCorrect("aA11@"));
    //camino 2.2 if->not isEmptyOrCantainScape()-> but not isIncorrectLenght() -> return false
    assertEquals(false, tetrisGame.isUserNameFormatCorrect("aaaaAAAA@@@111bbbBBBB$$$$"));


    //camino 3.1 if->not isEmptyOrCantainScape()->  isIncorrectLenght() ->if but no contains number-> return false
    assertEquals(false, tetrisGame.isPasswordFormatCorrect("aA@sS$oO*"));
    //camino 3.2 if->not isEmptyOrCantainScape()->  isIncorrectLenght() ->if but no contains special caracter-> return false
    assertEquals(false, tetrisGame.isPasswordFormatCorrect("aA1sS2oO2"));
    //camino 3.3 if->not isEmptyOrCantainScape()->  isIncorrectLenght() ->if but no contains upperCase-> return false
    assertEquals(false, tetrisGame.isPasswordFormatCorrect("a@1s$2o*2"));
    //camino 3.3 if->not isEmptyOrCantainScape()->  isIncorrectLenght() ->if but no contains lowerCase-> return false
    assertEquals(false, tetrisGame.isPasswordFormatCorrect("A@1S$2O3"));

    //camino 4.1 if->not isEmptyOrCantainScape()->  isIncorrectLenght() ->if but only contains number-> return false
    assertEquals(false, tetrisGame.isPasswordFormatCorrect("123456789"));
    //camino 4.2 if->not isEmptyOrCantainScape()->  isIncorrectLenght() ->if but only contains special caracter-> return false
    assertEquals(false, tetrisGame.isPasswordFormatCorrect("!·$%&/()="));
    //camino 4.3 if->not isEmptyOrCantainScape()->  isIncorrectLenght() ->if but only contains upperCase-> return false
    assertEquals(false, tetrisGame.isPasswordFormatCorrect("ABCDEFGH"));
    //camino 4.3 if->not isEmptyOrCantainScape()->  isIncorrectLenght() ->if but only contains lowerCase-> return false
    assertEquals(false, tetrisGame.isPasswordFormatCorrect("abcdefgh"));

    //camino 5 if->not isEmptyOrCantainScape()->  isIncorrectLenght() ->if contains number,specialcaracter, upperCase, lowerCase-> return true
    assertEquals(true, tetrisGame.isPasswordFormatCorrect("aA@1sS$2oO*0"));
    assertEquals(true, tetrisGame.isPasswordFormatCorrect("aAbB123$%&"));
    assertEquals(true, tetrisGame.isPasswordFormatCorrect("1234%&aB"));






  }

@Test
void puntuationFormatCorrect(){
  //camino 1 if->puntuation<0 -> return false
  assertEquals(false, tetrisGame.isPuntuationFormatCorrect(-34444444));
  assertEquals(false, tetrisGame.isPuntuationFormatCorrect(-5));
  assertEquals(false, tetrisGame.isPuntuationFormatCorrect(-1));

  //camino 2 if->puntuation>0-> if puntuation >999999 -> return false
  assertEquals(false, tetrisGame.isPuntuationFormatCorrect(1000000));
  assertEquals(false, tetrisGame.isPuntuationFormatCorrect(2000000));

  //camino 3 if->puntuation>=0-> if puntuation <=999999 -> return true
  assertEquals(true, tetrisGame.isPuntuationFormatCorrect(0));
  assertEquals(true, tetrisGame.isPuntuationFormatCorrect(100));
  assertEquals(true, tetrisGame.isPuntuationFormatCorrect(500000));
  assertEquals(true, tetrisGame.isPuntuationFormatCorrect(999999));

}

  @Test
  void registerUser() throws IOException {
    File file= new File(tetrisGame.getUSER_FILE());
    file.delete();
    //camino 1 if->not isUserNameFormatCorrect()-> return false
    assertEquals(false, tetrisGame.registerUser("","1eG$5dg@"));
    assertEquals(false, tetrisGame.registerUser("Charly12","1eG$5dg@"));
    assertEquals(false, tetrisGame.registerUser("Char Y","1eG$5dg@"));
    assertEquals(false, tetrisGame.registerUser("Charly.$&&","1eG$5dg@"));
    //camino 1.2 if->isUserNameFormatCorrect()-> not isPasswordFormatCorrect->return false
    assertEquals(false, tetrisGame.registerUser("Carlos",""));
    assertEquals(false, tetrisGame.registerUser("Carlos","aA11@"));
    assertEquals(false, tetrisGame.registerUser("Carlos","aaaaAAAA@@@111bbbBBBB$$$$"));
    assertEquals(false, tetrisGame.registerUser("Carlos","123456789"));
    assertEquals(false, tetrisGame.registerUser("Carlos","abcdefgh"));

    //camino 2 if->isUserNameFormatCorrect()->isPasswordFormatCorrect->if isFirstsUser()->writeJson()->return True
    assertEquals(true, tetrisGame.registerUser("Carlos","1eG$5dg@"));

    //camino 3 if->isUserNameFormatCorrect()->isPasswordFormatCorrect->if not isFirstsUser() -> userExist()-> return false
    assertEquals(false, tetrisGame.registerUser("Carlos","1eG$5dg@"));

    //camino 4 if->isUserNameFormatCorrect()->isPasswordFormatCorrect->if not isFirstsUser() -> userNotExist()-> writeJson()-> return true
    assertEquals(true ,tetrisGame.registerUser("Miguel","4hG$8dg@"));


  }
  @Test
  void login() throws FileNotFoundException {
    //camino 1 if->userIncorrect()-> return false
    assertEquals(false,tetrisGame.login("Eustaqio","1eG$5dg@"));

    //camino 2 if->userCorrect()->but password incorrect -> return false
    assertEquals(false,tetrisGame.login("Estevan","2eG$5dg@"));

    //camino 3 if->userCorrect()-> password correct -> return true
    assertEquals(false,tetrisGame.login("Estevan","1eG$5dg@"));


  }

  @Test
  void savePuntuation() throws IOException {
    File file= new File(tetrisGame.getUSER_PUNTUATION());
    if (file.exists()){
    file.delete();}

    //camino 1 if->isPuntuationFormatIncorrect-> return false
    assertEquals(false,tetrisGame.savePuntuation("Eustaqio",-34444444));
    assertEquals(false,tetrisGame.savePuntuation("Estevan",1000000));

    //camino 2 if->userNotExist->writeJson -> return true
    assertEquals(true,tetrisGame.savePuntuation("Carlos",50000));

    //camino 3 if->userExist()-> currentPuntuation<lastPuntuation -> return true
    assertEquals(false,tetrisGame.savePuntuation("Carlos",10000));

    //camino 3 if->userExist()-> currentPuntuation>lastPuntuation -> return true
    assertEquals(true,tetrisGame.savePuntuation("Carlos",60000));


  }


}
