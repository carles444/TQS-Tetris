package TetrisGame.View;

import TetrisGame.Model.TetrisGameClient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class menuView {
  public static int menu() throws IOException {


    System.out.println(ConsoleColors.RED_UNDERLINED+ "Tetris Game "+ConsoleColors.RESET);
    System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+ "1. LogIn"+ConsoleColors.RESET);
    System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+ "2. SignUp"+ConsoleColors.RESET);
    System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT+ "3. Play"+ConsoleColors.RESET);
    System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT+ "4. Exit"+ConsoleColors.RESET);




    Scanner sc = new Scanner(System.in);
    return sc.nextInt();

  }
  public static String[] login() throws FileNotFoundException {
    Scanner sc = new Scanner(System.in);


  String username,password;
    System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ "Username: "+ConsoleColors.RESET);
    username=sc.nextLine();
    System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Password: "+ConsoleColors.RESET);
    password=sc.nextLine();



    return new String[]{username,password};

  }
  public static String[]  signUp() throws IOException {
    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+ "User must have 8 characters at most"+ConsoleColors.RESET);
    Scanner sc = new Scanner(System.in);
    String username,password;

    System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ "Username: "+ConsoleColors.RESET);
    username = sc.nextLine();
    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Password must have lowercase, uppercase, numbers and special characters(8 chars)"+ConsoleColors.RESET);

    System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Password: "+ConsoleColors.RESET);
    password = sc.nextLine();

    return new String[]{username,password};
  }

  }
