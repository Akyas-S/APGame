package gamestates;

import main.GameController;
import utils.LoadImages;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Controls extends State implements Statemethods {
    private BufferedImage controlsbg;
    private BufferedImage Closecontrolicon;
    private BufferedImage upkeyicon;
    private BufferedImage downkeyicon;
    private BufferedImage leftkeyicon;
    private BufferedImage rightkeyicon;

    private BufferedImage uparrowkeyicon;
    private BufferedImage downarrowkeyicon;
    private BufferedImage leftarrowkeyicon;
    private BufferedImage rightarrowkeyicon;

    private Rectangle Closecontrolbounds;
    private Rectangle upkeyiconbounds;
    private Rectangle downkeyiconbounds;
    private Rectangle leftkeyiconbounds;
    private Rectangle rightkeyiconbounds;

    private boolean isWASDup = true;
    private boolean isWASDdown = true;
    private boolean isWASDleft = true;
    private boolean isWASDright = true;

    public Controls(GameController game){
        super(game);
        loadControlsBackground();
        loadControlButtons();
    }

    private void loadControlButtons() {
        Closecontrolicon = LoadImages.GetSprite(LoadImages.Closebtnimg);
        upkeyicon = LoadImages.GetSprite(LoadImages.KEY_W);
        downkeyicon = LoadImages.GetSprite(LoadImages.KEY_S);
        leftkeyicon = LoadImages.GetSprite(LoadImages.KEY_A);
        rightkeyicon = LoadImages.GetSprite(LoadImages.KEY_D);

        uparrowkeyicon = LoadImages.GetSprite(LoadImages.KEYUPARROW);
        downarrowkeyicon = LoadImages.GetSprite(LoadImages.KEYDOWNARROW);
        leftarrowkeyicon = LoadImages.GetSprite(LoadImages.KEYLEFTARROW);
        rightarrowkeyicon = LoadImages.GetSprite(LoadImages.KEYRIGHTARROW);

        Closecontrolbounds = new Rectangle(110, 50, 140, 140);
        upkeyiconbounds = new Rectangle(510, 260, 90, 90);
        downkeyiconbounds = new Rectangle(510, 380, 90,90);
        leftkeyiconbounds = new Rectangle(950, 260, 90,90);
        rightkeyiconbounds = new Rectangle(950, 380, 90,90);


    }

    private void loadControlsBackground() {
        controlsbg = LoadImages.GetSprite(LoadImages.Controlsimg);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(controlsbg, 0, 0,1280,720, null);
        g.drawImage(Closecontrolicon, 110, 50, 140, 140,null);
        if (isWASDup) {
            g.drawImage(upkeyicon, 510, 260, 90, 90,null);
        } else {
            g.drawImage(uparrowkeyicon, 510, 260, 90, 90,null);
        }
        if (isWASDdown) {
            g.drawImage(downkeyicon, 510, 380, 90,90,null);
        } else {
            g.drawImage(downarrowkeyicon, 510, 380, 90,90,null);
        }
        if (isWASDleft) {
            g.drawImage(leftkeyicon, 950, 260, 90,90,null);
        } else {
            g.drawImage(leftarrowkeyicon, 950, 260, 90,90,null);
        }
        if (isWASDright) {
            g.drawImage(rightkeyicon, 950, 380, 90,90,null);
        } else {
            g.drawImage(rightarrowkeyicon, 950, 380, 90,90,null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent con) {
        Point clickPoint = con.getPoint();
        if (Closecontrolbounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.SETTINGS;
            game.getAudioPlayer().playButtonSound();
        }
        else if (upkeyiconbounds.contains(clickPoint)) {
            isWASDup = !isWASDup;
            game.getAudioPlayer().playButtonSound();
        }
        else if (downkeyiconbounds.contains(clickPoint)) {
            isWASDdown = !isWASDdown;
            game.getAudioPlayer().playButtonSound();
        }
        else if (leftkeyiconbounds.contains(clickPoint)) {
            isWASDleft = !isWASDleft;
            game.getAudioPlayer().playButtonSound();
        }
        else if (rightkeyiconbounds.contains(clickPoint)) {
            isWASDright = !isWASDright;
            game.getAudioPlayer().playButtonSound();
        }
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