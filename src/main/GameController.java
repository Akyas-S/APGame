

package main;

import Audio.AudioPlayer;


import gamestates.*;
import entity.Player;


import java.awt.*;

public class GameController implements Runnable {

    // Variables for the game window and game panel
    private Window window;
    private GamePanel gamePanel;
    // Thread for the game loop
    private Thread gameThread;
    // Used to set the FPS the game runs at
    private final int FPS_SET = 60;
    // Variables for FPS counter
    int frames =0;
    long lastCheck = System.currentTimeMillis();

    // Variables for Game states
    private Playing playing;
    private MainMenu mainMenu;
    private Player player;
    private Settings settings;
    private Audio audio;
    private Controls controls;
    private Pause pause;
    private AudioPlayer audioPlayer;
    private Store store;
    private NextLevel nextLevel;
    private Death death;
    private Victory victory;


    // Constructor for the GameController class
    public GameController(){
        initClasses();
        gamePanel = new GamePanel(this);
        window = new Window(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        startGameLoop();
    }
    // Initialize all the game states and objects needed to run the game
    private void initClasses() {
        player = new Player(200,200);
        death = new Death (this);
        nextLevel = new NextLevel(this);
        mainMenu = new MainMenu(this,player);
        playing = new Playing(this);
        settings = new Settings(this);
        audio = new Audio(this);
        audioPlayer = new AudioPlayer();
        controls = new Controls(this);
        pause=new Pause(this,player);
        store = new Store(this,player);
        victory = new Victory(this);
    }


    // Start the game loop in a new thread
    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();

    }

    // Run method for the game loop
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



    // Render the game states
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
            case NEXTLEVEL:
                nextLevel.render(g);
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


    // Getter for the player object
    public Player getPlayer() {return player;}
    // Getters for all the game states
    public MainMenu getMenu(){return mainMenu;}
    public Settings getSettings(){return settings;}
    public Audio getAudio(){return audio;}
    public Controls getControls(){return controls;}
    public Playing getPlaying(){return playing;}
    public Pause getPause(){return pause;}
    public AudioPlayer getAudioPlayer(){return audioPlayer;}
    public Store getStore(){return store;}
    public NextLevel getNextLevel(){return nextLevel;}
    public Death getDeath(){return death;}
    public Victory getVictory(){return victory;}

    // calls the reset directions method in the playing class that sets all directions to false
    // when the window loses focus
    public void windowFocusLost() {playing.resetDirections();}
}
