package gamestates;

import main.GameController;
import utils.LoadImages;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Controls extends State implements Statemethods {
    private BufferedImage controlsbg;

    public Controls(GameController game){
        super(game);

        loadControlsBackground();
    }

    private void loadControlsBackground() {
        controlsbg = LoadImages.GetSprite(LoadImages.Controlsimg);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(controlsbg, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}