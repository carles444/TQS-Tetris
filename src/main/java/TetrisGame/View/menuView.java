package TetrisGame.View;

import TetrisGame.Model.TetrisGameClient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class menuView {
  public static int menu(){
    System.out.println("Tetris Game\n");
    System.out.println(ConsoleColors.RED+ "1. LogIn"+ConsoleColors.RESET);
    System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ "2. SignUp"+ConsoleColors.RESET);
    System.out.println("3. Play");
    System.out.println("4. Exit");
    Scanner sc = new Scanner(System.in);
    return sc.nextInt();

  }
  public static String[] login() throws FileNotFoundException {
    Scanner sc = new Scanner(System.in);


  String username,password;
    System.out.println("Username: ");
    username=sc.nextLine();
    System.out.println("Password: ");
    password=sc.nextLine();



    return new String[]{username,password};

  }
  public static String[]  signUp() throws IOException {
    System.out.println("User must have 8 characters at most");
    Scanner sc = new Scanner(System.in);
    String username,password;

    System.out.println("Username: ");
    username = sc.nextLine();
    System.out.println("Password must have lowercase, uppercase, numbers and special characters(8 chars)");

    System.out.println("Password: ");
    password = sc.nextLine();

    return new String[]{username,password};
  }

  }
