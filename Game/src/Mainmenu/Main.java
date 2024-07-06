package Mainmenu;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.File;

public class Main {
    private static FloatControl volumeControl;

    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        MainMenu mainMenu = new MainMenu();
        File bgMusic = new File("/Users/hello/IdeaProjects/Game/src/Mainmenu/GUI/Menu/bg.wav");
        audio(bgMusic);
    }

    private static void audio(File bgMusic) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Clip clip;

        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bgMusic);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

        setVolume(-25.0f);

        clip.start();
    }

    public static void setVolume(float volume) {
        volumeControl.setValue(volume);
    }
}