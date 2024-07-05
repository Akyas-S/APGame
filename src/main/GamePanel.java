package main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static java.lang.Math.random;


public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    float PlayerX = 0;
    float PlayerY = 0  ;
    int frames;
    int red, green, blue;
    private long lastCheck;
    float xDir = 5f;
    float yDir = 5f;
    Random random;


    public GamePanel(){

        random = new Random();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    // Takes keyboard inputs and moves player
    public void Move(int X, int Y){
        this.PlayerX += X;
        this.PlayerY += Y;

    }
    // Tracks movement of mouse and maps it to player
    public void mouseMove(int X, int Y){
        this.PlayerX = X;
        this.PlayerY = Y;


    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateRect();

        g.setColor(new Color(red,green,blue));
        g.fillRect((int)PlayerX, (int)PlayerY, 50, 50);




    }

    private void updateRect() {
        PlayerX += xDir;
        if (PlayerX >= 1280-50 || PlayerX <0){
            rndcolor();
            xDir *=-1;
        }
        PlayerY += yDir;
        if (PlayerY >= 720-50 || PlayerY < 0){
            rndcolor();
            yDir *=-1;
        }

    }

    private void rndcolor() {
        red = random.nextInt(256);
        green = random.nextInt(256);
        blue = random.nextInt(256);
    }
}
