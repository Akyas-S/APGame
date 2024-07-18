package Audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class AudioPlayer {
//    public static int Btnsfx = 0;
//
//    public static int Mainmenuaud = 0;
//    public static int ForestLevel = 1;
//
//    private Clip[] effects, music;
//
//    private int currmusicID;
//    private float volume = 0.5f;
//    private boolean musicMute, sfxMute;


    public AudioPlayer() {
//        loadMusic();
//        loadSFX();
//        playMusic(Mainmenuaud);
    }

//    private void loadMusic(){
//        String[] names = {"mainMenuAud", "forestScene"};
//        music = new Clip[names.length];
//        for (int i = 0; i < music.length; i++)
//            music[i] = getClip(names[i]);
//    }
//
//    private void loadSFX(){
//        String[] names = {"BtnSfx"};
//        effects = new Clip[names.length];
//        for (int i = 0; i < effects.length; i++)
//            effects[i] = getClip(names[i]);
//
//        updateMusicVolume();
//
//    }
//    private Clip getClip(String name) {
//        URL url = getClass().getResource("/AudioFiles/" + name + ".wav");
//        AudioInputStream audio;
//
//        try {
//            audio = AudioSystem.getAudioInputStream(url);
//            Clip c = AudioSystem.getClip();
//            c.open(audio);
//            return c;
//
//        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
//
//            e.printStackTrace();
//        }
//
//        return null;
//
//    }
//    public void stopMusic() {
//        if (music[currmusicID].isActive())
//            music[currmusicID].stop();
//    }
//
//    public void setLevelSong(int levelIndex) {
//        if (levelIndex == 1){
//            playMusic(Mainmenuaud);
//        }
//        else if (levelIndex == 2){
//            playMusic(ForestLevel);
//        }
//    }
//
//
//    public void playEffect (int effect){
//        effects[effect].setMicrosecondPosition(0);
//        effects[effect].start();
//    }
//
//    public void playMusic (int musicP){
//        stopMusic();
//
//        currmusicID = musicP;
//        updateMusicVolume();
//        music[currmusicID].setMicrosecondPosition(0);
//        music[currmusicID].loop(Clip.LOOP_CONTINUOUSLY);
//
//    }
//
//    public void toggleMusicMute(){
//        this.musicMute = !musicMute;
//        for (Clip c : music){
//            BooleanControl musicVolume = (BooleanControl) c.getControl(BooleanControl.Type.MUTE);
//            musicVolume.setValue(musicMute);
//        }
//    }
//
//    public void toggleSFXMute(){
//        this.sfxMute = !sfxMute;
//        for (Clip c : effects){
//            BooleanControl sfxVolume = (BooleanControl) c.getControl(BooleanControl.Type.MUTE);
//            sfxVolume.setValue(sfxMute);
//        }
//
//    }
//
//    private void updateMusicVolume(){
//        FloatControl gainControl = (FloatControl) music[0].getControl(FloatControl.Type.MASTER_GAIN);
//        float range = gainControl.getMaximum() - gainControl.getMinimum();
//        float gain = (range*volume)+gainControl.getMinimum();
//        gainControl.setValue(gain);
//    }
//
//    private void updateSFXVolume(){
//        FloatControl gainControl = (FloatControl) effects[0].getControl(FloatControl.Type.MASTER_GAIN);
//        float range = gainControl.getMaximum() - gainControl.getMinimum();
//        float gain = (range*volume)+gainControl.getMinimum();
//        gainControl.setValue(gain);
//
//    }
}
