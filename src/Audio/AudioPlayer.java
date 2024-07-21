package Audio;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
// AudioPlayer class to handle the audio in the game
public class AudioPlayer {

    // Constants for the different songs and sound effects
    public static int MENU = 0;
    public static int FOREST = 1;

    public static int POP = 0;
    public static int FROG = 1;
    public static int LEVELCOMPLETE = 2;
    public static int SWORDSWISH = 3;

    // Arrays to store the music and sound effects
    private Clip[] music, sfx;
    private int currentSongId;
    private float volume = 0.9f;
    private boolean musicMute, sfxMute;

    // Constructor to load the music and sound effects
    public AudioPlayer() {
        loadMusic();
        loadSFX();
        playMusic(MENU);
    }

    private void loadMusic() {
        String[] names = { "menu", "forest"};
        music = new Clip[names.length];
        for (int i = 0; i < music.length; i++)
            music[i] = getClip(names[i]);
    }

    private void loadSFX() {
        String[] effectNames = { "pop", "frog","levelcomplete","SwordSwish"};
        sfx = new Clip[effectNames.length];
        for (int i = 0; i < sfx.length; i++)
            sfx[i] = getClip(effectNames[i]);

        updateEffectsVolume();

    }

    private Clip getClip(String name) {
        URL url = getClass().getResource("/AudioFiles/" + name + ".wav");
        AudioInputStream audio;
        try {
            audio = AudioSystem.getAudioInputStream(url);
            Clip c = AudioSystem.getClip();
            c.open(audio);
            return c;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void stopSong() {
        if (music[currentSongId].isActive())
            music[currentSongId].stop();
    }

    public void setLevelSong(int lvlIndex) {
        if (lvlIndex == 1)
            playMusic(FOREST);
    }

    public void playAttackSFX(){
        playSFX(SWORDSWISH);
    }

    public void playMenuButtonSound(){
        int menubtnsfx = 1;
        playSFX(menubtnsfx);
    }

    public void playButtonSound(){
        int btnsound = 1;
        playSFX(btnsound);
    }


    public void playSFX(int pSFX) {
        sfx[pSFX].setMicrosecondPosition(0);
        sfx[pSFX].start();
    }

    public void playMusic(int pMusic) {
        stopSong();

        currentSongId = pMusic;
        updateSongVolume();
        music[currentSongId].setMicrosecondPosition(0);
        music[currentSongId].loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void toggleMusicMute() {
        this.musicMute = !musicMute;
        for (Clip c : music) {
            BooleanControl booleanControl = (BooleanControl) c.getControl(BooleanControl.Type.MUTE);
            booleanControl.setValue(musicMute);
        }
    }

    public void toggleSFXMute() {
        this.sfxMute = !sfxMute;
        for (Clip c : sfx) {
            BooleanControl booleanControl = (BooleanControl) c.getControl(BooleanControl.Type.MUTE);
            booleanControl.setValue(sfxMute);
        }
        if (!sfxMute)
            playSFX(POP);
    }

    private void updateSongVolume() {
        FloatControl gainControl = (FloatControl) music[currentSongId].getControl(FloatControl.Type.MASTER_GAIN);
        float range = gainControl.getMaximum() - gainControl.getMinimum();
        float gain = (range * volume) + gainControl.getMinimum();
        gainControl.setValue(gain);

    }

    private void updateEffectsVolume() {
        for (Clip c : sfx) {
            FloatControl gainControl = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
            float range = gainControl.getMaximum() - gainControl.getMinimum();
            float gain = (range * volume) + gainControl.getMinimum();
            gainControl.setValue(gain);
        }
    }

}