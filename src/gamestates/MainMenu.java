package gamestates;

import main.GameController;
import utils.LoadImages;
import utils.LoadImages.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class MainMenu extends State implements Statemethods {
    private BufferedImage background;

    private BufferedImage Starticon;
    private BufferedImage Storeicon;
    private BufferedImage Settingsicon;
    private BufferedImage Exiticon;

    private Rectangle startButtonBounds;
    private Rectangle storeButtonBounds;
    private Rectangle settingsButtonBounds;
    private Rectangle exitButtonBounds;



    public MainMenu(GameController game){
        super(game);
        loadBackground();
        loadButtons();
    }

    private void loadButtons() {
        Starticon = LoadImages.GetSprite(LoadImages.Startbtnimg);
        Storeicon = LoadImages.GetSprite(LoadImages.Storebtnimg);
        Settingsicon = LoadImages.GetSprite(LoadImages.Settingsbtnimg);
        Exiticon = LoadImages.GetSprite(LoadImages.Exitbtnimg);

        startButtonBounds = new Rectangle(760, 295, Starticon.getWidth(), Starticon.getHeight());
        storeButtonBounds = new Rectangle(760, 460, Storeicon.getWidth(), Storeicon.getHeight());
        settingsButtonBounds = new Rectangle(760, 625, Settingsicon.getWidth(), Settingsicon.getHeight());
        exitButtonBounds = new Rectangle(760, 790, Exiticon.getWidth(), Exiticon.getHeight());
    }

    private void loadBackground() {
        background = LoadImages.GetSprite(LoadImages.Menuimg);
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(background, 0,0,null);
        g.drawImage(Starticon, 760,295,null);
        g.drawImage(Storeicon, 760,460,null);
        g.drawImage(Settingsicon, 760,625,null);
        g.drawImage(Exiticon, 760,790,null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point clickPoint = e.getPoint();

        if (startButtonBounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.PLAYING;
        } else if (storeButtonBounds.contains(clickPoint)) {

        } else if (settingsButtonBounds.contains(clickPoint)) {

        } else if (exitButtonBounds.contains(clickPoint)) {
            System.exit(0);
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
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Gamestate.state = Gamestate.PLAYING;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
