package main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    int PlayerXadd = 0;
    int PlayerYadd = 0  ;

    public GamePanel(){
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void Move(int X, int Y){
        this.PlayerXadd += X;
        this.PlayerYadd += Y;
        repaint();
    }

    public void mouseMove(int X, int Y){
        this.PlayerXadd = X;
        this.PlayerYadd = Y;
        repaint();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0 + PlayerXadd, 0 + PlayerYadd, 200, 50);

    }
}
