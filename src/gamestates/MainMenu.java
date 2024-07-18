package gamestates;

import main.GameController;
import utils.LoadImages;
import Audio.AudioPlayer;

import java.awt.*;
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

        startButtonBounds = new Rectangle(500, 200, 294, 91);
        storeButtonBounds = new Rectangle(500, 310, 294, 91);
        settingsButtonBounds = new Rectangle(500, 420, 294, 91);
        exitButtonBounds = new Rectangle(500, 530, 294, 91);
    }

    private void loadBackground() {
        background = LoadImages.GetSprite(LoadImages.Menuimg);
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(background, 0,0,1280,720,null);
        g.drawImage(Starticon, 500,200,294, 91,null);
        g.drawImage(Storeicon, 500,310,294, 91, null);
        g.drawImage(Settingsicon, 500,420,294, 91,null);
        g.drawImage(Exiticon, 500,530,294, 91,null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point clickPoint = e.getPoint();
        if (startButtonBounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.PLAYING;
            game.getAudioPlayer().playMenuButtonSound();
        } else if (storeButtonBounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.STORE;
            game.getAudioPlayer().playMenuButtonSound();
        } else if (settingsButtonBounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.SETTINGS;
            game.getAudioPlayer().playMenuButtonSound();
        } else if (exitButtonBounds.contains(clickPoint)) {
            game.getAudioPlayer().playMenuButtonSound();
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

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
