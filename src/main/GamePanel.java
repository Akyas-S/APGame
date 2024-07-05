package main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import static java.lang.Math.random;


public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float PlayerX = 0;
    private float PlayerY = 0  ;
    private BufferedImage Image;

    public GamePanel(){

        mouseInputs = new MouseInputs(this);
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 720);
        setPreferredSize(size);
    }

    // Takes keyboard inputs and moves player
    public void Move(int X, int Y){
        this.PlayerX += X;
        this.PlayerY += Y;

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage()

    }

}
