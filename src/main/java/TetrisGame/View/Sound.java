package TetrisGame.View;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
  public static Clip soundMenu() throws LineUnavailableException, IOException, UnsupportedAudioFileException, UnsupportedAudioFileException {
    AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("./data/sounds/soundtrack.wav"));
    Clip clip = AudioSystem.getClip();
    clip.open(inputStream);
    clip.loop(Clip.LOOP_CONTINUOUSLY);
    return clip;
  }
}
