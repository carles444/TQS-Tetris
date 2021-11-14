package TetrisGame.Controller;

import TetrisGame.Model.TetrisGameClient;
import TetrisGame.View.menuView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class menuControl {
  public static int menu(){
    return menuView.menu();
  }
  public static boolean login(String username, String password, TetrisGameClient tgC) throws FileNotFoundException {

    String[] words =menuView.login(username,password);
    username=words[0];
    password=words[1];
    return tgC.login(username, password);

  }
  public static boolean signUp(String username, String password, TetrisGameClient tgC) throws IOException {
    String[] words =menuView.signUp(username,password);
    username=words[0];
    password=words[1];
    return tgC.registerUser(username, password);
  }




}
