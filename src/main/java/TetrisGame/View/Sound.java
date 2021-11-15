package TetrisGame.View;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
  private static Clip clip;
  public static void stop(){
    clip.stop();
  }
  public static Clip startSoundMenu() throws LineUnavailableException, IOException, UnsupportedAudioFileException, UnsupportedAudioFileException {
    AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("./data/Sounds/menu.wav"));
    clip = AudioSystem.getClip();
    clip.open(inputStream);
    clip.loop(Clip.LOOP_CONTINUOUSLY);
    clip.start();
    return clip;
  }

  public static Clip startSoundGame() throws LineUnavailableException, IOException, UnsupportedAudioFileException, UnsupportedAudioFileException {
    clip.stop();

    AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("./data/Sounds/soundtrack.wav"));
    clip = AudioSystem.getClip();
    clip.open(inputStream);
    clip.loop(Clip.LOOP_CONTINUOUSLY);
    clip.start();
    return clip;
  }
  public static Clip sounLineEfect() throws LineUnavailableException, IOException, UnsupportedAudioFileException, UnsupportedAudioFileException {


    AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("./data/Sounds/line.wav"));
    clip = AudioSystem.getClip();
    clip.open(inputStream);
    clip.start();
    return clip;
  }
}
