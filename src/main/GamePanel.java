package main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;
import data.SaveLoad;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private GameController game;

    public GamePanel(GameController game){

        mouseInputs = new MouseInputs(this);
        this.game = game;
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }


    private void setPanelSize() {
        Dimension size = new Dimension(1280, 720);
        setPreferredSize(size);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);


    }

    public GameController getGame(){
        return game;
    }


}