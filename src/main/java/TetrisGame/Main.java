package TetrisGame;

import TetrisGame.Controller.Game;
import TetrisGame.Controller.Player;
import TetrisGame.Controller.menuControl;
import TetrisGame.Model.TetrisGameClient;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Main {
    static TetrisGameClient tgC;
    static boolean logged = false;
    static String username, password;





    public static int play() {
        Game game = new Game();
        game.start();
        return game.getScore();
    }


    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        //Clip clip = soundMenu();
        Player player=new Player();
        StringBuilder[] words = new StringBuilder[2];
        tgC = new TetrisGameClient();
        boolean end = false;
        while(!end) {
            switch (menuControl.menu()) {
                case 1:
                    if (!menuControl.login(player,tgC)) {
                        System.out.println("Failed Login");
                    } else {
                        logged = true;
                    }
                    break;
                case 2:
                    if (!menuControl.signUp(player,tgC)) {
                        System.out.println("Failed signUp");
                    } else {
                        logged = true;
                    }
                    break;
                case 3:
                    if(logged) {
                        int score = play();
                        tgC.savePuntuation(player, score);
                    }
                    break;
                case 4:
                    end = true;
                    break;

            }
        }
    }
}
