package utils;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class LoadAudio {
    private File musicFile1;
    private File musicFile2;
    private File sfxFile;
    private Clip musicClip1;
    private Clip musicClip2;
    private Clip sfxClip;

    public LoadAudio(String musicFilePath1, String musicFilePath2, String sfxFilePath) {
        this.musicFile1 = new File(musicFilePath1);
        this.musicFile2 = new File(musicFilePath2);
        this.sfxFile = new File(sfxFilePath);
    }

    public boolean loadAudio() {
        try {
            AudioInputStream musicAudioInputStream1 = AudioSystem.getAudioInputStream(musicFile1);
            musicClip1 = AudioSystem.getClip();
            musicClip1.open(musicAudioInputStream1);

            AudioInputStream musicAudioInputStream2 = AudioSystem.getAudioInputStream(musicFile2);
            musicClip2 = AudioSystem.getClip();
            musicClip2.open(musicAudioInputStream2);

            AudioInputStream sfxAudioInputStream = AudioSystem.getAudioInputStream(sfxFile);
            sfxClip = AudioSystem.getClip();
            sfxClip.open(sfxAudioInputStream);

            return true;
        } catch (Exception e) {
            System.err.println("Error: Unable to load audio files");
            return false;
        }
    }

    public Clip getMusicClip1() {
        return musicClip1;
    }

    public Clip getMusicClip2() {
        return musicClip2;
    }

    public Clip getSFXClip() {
        return sfxClip;
    }
}
