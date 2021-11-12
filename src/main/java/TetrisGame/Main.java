package TetrisGame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static TetrisGameClient tgC;
    static boolean logged = false;
    static String username, password;
    public static int menu() {
        System.out.println("Tetris Game\n");
        System.out.println("1. LogIn");
        System.out.println("2. SignUp");
        System.out.println("3. Play");
        System.out.println("4. Exit");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static  boolean signUp() throws IOException {
        System.out.println("User must have 8 characters at most");
        Scanner sc = new Scanner(System.in);

        System.out.println("Username: ");
        username = sc.nextLine();
        System.out.println("Password must have lowercase, uppercase, numbers and special characters(8 chars)");

        System.out.println("Password: ");
        password = sc.nextLine();

        return tgC.createUser(username, password);
    }
    public static boolean logIn() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Username: ");
        username = sc.nextLine();
        System.out.println("Password: ");
        password = sc.nextLine();

        return tgC.login(username, password);
    }

    public static void play() {
        Game game = new Game();
    }

    public static void main(String[] args) throws IOException {
        tgC = new TetrisGameClient();
        boolean end = false;
        while(!end) {
            switch (menu()) {
                case 1:
                    if (!logIn()) {
                        System.out.println("Failed Login");
                    } else {
                        logged = true;
                    }
                    break;
                case 2:
                    if (!signUp()) {
                        System.out.println("Failed signUp");
                    } else {
                        logged = true;
                    }
                    break;
                case 3:
                    if(logged) {
                        play();
                        //Todo: guardar datos
                    }
                    break;
                case 4:
                    end = true;
                    break;

            }
        }
    }
}
