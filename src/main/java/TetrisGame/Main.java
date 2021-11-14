package TetrisGame;

import TetrisGame.Controller.Game;
import TetrisGame.Controller.menuControl;
import TetrisGame.Model.TetrisGameClient;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Main {
    static TetrisGameClient tgC;
    static boolean logged = false;
    static String username, password;





    public static void play() {
        Game game = new Game();
        game.start();
    }


    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        //Clip clip = soundMenu();

        tgC = new TetrisGameClient();
        boolean end = false;
        while(!end) {
            switch (menuControl.menu()) {
                case 1:
                    if (!menuControl.login(username,password,tgC)) {
                        System.out.println("Failed Login");
                    } else {
                        logged = true;
                    }
                    break;
                case 2:
                    if (!menuControl.signUp(username,password,tgC)) {
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
