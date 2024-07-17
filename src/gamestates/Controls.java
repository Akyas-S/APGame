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

    private Rectangle Closecontrolbounds;
    private Rectangle upkeyiconbounds;
    private Rectangle downkeyiconbounds;
    private Rectangle leftkeyiconbounds;
    private Rectangle rightkeyiconbounds;

    public Controls(GameController game){
        super(game);
        loadControlsBackground();
        loadControlButtons();
    }

    private void loadControlButtons() {
        Closecontrolicon = LoadImages.GetSprite(LoadImages.Closebtnimg);
        upkeyicon = LoadImages.GetSprite(LoadImages.Keybtnimg);
        downkeyicon = LoadImages.GetSprite(LoadImages.Keybtnimg);
        leftkeyicon = LoadImages.GetSprite(LoadImages.Keybtnimg);
        rightkeyicon = LoadImages.GetSprite(LoadImages.Keybtnimg);

        Closecontrolbounds = new Rectangle(190, 90, Closecontrolicon.getWidth(), Closecontrolicon.getHeight());
        upkeyiconbounds = new Rectangle(780, 400, upkeyicon.getWidth(), upkeyicon.getHeight());
        downkeyiconbounds = new Rectangle(780, 580, downkeyicon.getWidth(), downkeyicon.getHeight());
        leftkeyiconbounds = new Rectangle(1400, 400, leftkeyicon.getWidth(), leftkeyicon.getHeight());
        rightkeyiconbounds = new Rectangle(1400, 580, rightkeyicon.getWidth(), rightkeyicon.getHeight());
    }

    private void loadControlsBackground() {
        controlsbg = LoadImages.GetSprite(LoadImages.Controlsimg);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(controlsbg, 0, 0, null);
        g.drawImage(Closecontrolicon, 190,90,null);
        g.drawImage(upkeyicon, 780,400,null);
        g.drawImage(downkeyicon, 780,580,null);
        g.drawImage(leftkeyicon, 1400,400,null);
        g.drawImage(rightkeyicon, 1400,580,null);

    }

    @Override
    public void mouseClicked(MouseEvent con) {
        Point clickPoint = con.getPoint();
        if (Closecontrolbounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.MENU;
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