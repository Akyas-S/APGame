package main;


import gamestates.Gamestate;
import gamestates.Playing;
import gamestates.MainMenu;
import gamestates.Settings;
import gamestates.Audio;
import gamestates.Controls;
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
    private Level1 Level1;
    private Settings settings;
    private Audio audio;
    private Controls controls;


    public GameController(){

        initClasses();
        gamePanel = new GamePanel(this);
        window = new Window(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void initClasses() {


        mainMenu = new MainMenu(this);
        playing = new Playing(this);
        settings = new Settings(this);
        audio = new Audio(this);
        controls = new Controls(this);
        player = new Player(200,200);
        Level1 = new Level1();

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
}
