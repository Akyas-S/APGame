

package main;

import Audio.AudioPlayer;


import gamestates.*;
import entity.Player;
import levels.Level1;


import java.awt.*;

public class GameController implements Runnable {
    //Controls the game scenes

    private Window window;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 60;
    int frames =0;
    long lastCheck = System.currentTimeMillis();


    private Playing playing;
    private MainMenu mainMenu;
    private Player player;
    private Settings settings;
    private Audio audio;
    private Controls controls;
    private Pause pause;
    private AudioPlayer audioPlayer;
    private Store store;
    private NextLevel2 nextLevel2;
    private Death death;
    private Victory victory;



    public GameController(){

        initClasses();
        gamePanel = new GamePanel(this);
        window = new Window(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void initClasses() {
        player = new Player(200,200);
        death = new Death (this);
        nextLevel2 = new NextLevel2(this);
        mainMenu = new MainMenu(this);
        playing = new Playing(this);
        settings = new Settings(this);
        audio = new Audio(this);
        audioPlayer = new AudioPlayer();
        controls = new Controls(this);
        pause=new Pause(this,player);
        store = new Store(this,player);
        victory = new Victory(this);

    }



    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        while(true){

            now = System.nanoTime();
            if (System.nanoTime() - lastFrame >= timePerFrame){

                gamePanel.repaint();
                lastFrame = now;
                frames++;
            }

            //fps counter

            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("Frames: " + frames);
                frames = 0;
            }
            //-----------

        }
    }
    public Player getPlayer() {
        return player;
    }

    public void render(Graphics g){

        switch (Gamestate.state){
            case MENU:
                mainMenu.render(g);
                break;
            case PLAYING:
                playing.render(g);
                break;
            case SETTINGS:
                settings.render(g);
                break;
            case AUDIO:
                audio.render(g);
                break;
            case CONTROLS:
                controls.render(g);
                break;
            case PAUSE:
                pause.render(g);
                break;
            case STORE:
                store.render(g);
                break;
            case NEXTLEVEL2:
                nextLevel2.render(g);
                break;
            case DEATH:
                death.render(g);
                break;
            case VICTORY:
                victory.render(g);
                break;
            default:
                break;
        }
    }

    public MainMenu getMenu(){
        return mainMenu;
    }
    public Settings getSettings(){
        return settings;
    }
    public Audio getAudio(){return audio;}
    public Controls getControls(){return controls;}
    public Playing getPlaying(){return playing;}
    public Pause getPause(){return pause;}
    public AudioPlayer getAudioPlayer(){return audioPlayer;}
    public Store getStore(){return store;}
    public NextLevel2 getNextLevel2(){return nextLevel2;}
    public Death getDeath(){return death;}
    public Victory getVictory(){return victory;}

    public void windowFocusLost() {
        playing.resetDirections();
    }
}
