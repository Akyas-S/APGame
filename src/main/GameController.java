package main;

import entity.Player;

import java.awt.*;

public class GameController implements Runnable {
    //Controls the game scenes

    private Window window;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 60;
    int frames =0;
    long lastCheck = System.currentTimeMillis();

    private Player player;

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
        player.render(g);
    }

    public Player getPlayer(){
        return player;
    }
}
