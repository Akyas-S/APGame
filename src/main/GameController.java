package main;

import gamestates.Gamestate;
import gamestates.Playing;
import gamestates.Menu;

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
    private Menu menu;

    public GameController(){

        initClasses();
        gamePanel = new GamePanel(this);
        window = new Window(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void initClasses() {

        menu = new Menu(this);
        playing = new Playing(this);
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
                menu.render(g);
                break;
            case PLAYING:
                playing.render(g);
                break;
            default:
                break;
        }
    }

    public Menu getMenu(){
        return menu;
    }

    public Playing getPlaying(){
        return playing;
    }


}
