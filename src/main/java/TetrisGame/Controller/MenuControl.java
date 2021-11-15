package TetrisGame.Controller;

import TetrisGame.Model.TetrisGameClient;
import TetrisGame.View.menuView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MenuControl {
  public static int menu() throws IOException {
    return menuView.menu();
  }
  public static boolean login(Player player,TetrisGameClient tgC) throws FileNotFoundException {

    String[]words =menuView.login();
    player.setName(words[0]);
    return tgC.login(words[0], words[1]);

  }
  public static boolean signUp(Player player, TetrisGameClient tgC) throws IOException {
    String[] words =menuView.signUp();
    player.setName(words[0]);

    return tgC.registerUser(words[0], words[1]);
  }




}
