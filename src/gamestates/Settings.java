package gamestates;

import main.GameController;
import utils.LoadImages;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Settings extends State implements Statemethods {
    private BufferedImage settingsbg;

    private BufferedImage Closeicon;
    private BufferedImage Audioicon;
    private BufferedImage Controlicon;

    private Rectangle Closebtnbounds;
    private Rectangle Audiobtnbounds;
    private Rectangle Controlbtnbounds;

    public Settings(GameController game){
        super(game);
        loadsettBackground();
        loadsettButtons();
    }

    private void loadsettButtons() {
        Closeicon = LoadImages.GetSprite(LoadImages.Closebtnimg);
        Audioicon = LoadImages.GetSprite(LoadImages.Audiobtnimg);
        Controlicon = LoadImages.GetSprite(LoadImages.Controlsbtnimg);

        Closebtnbounds = new Rectangle(140, 65, 140, 140);
        Audiobtnbounds = new Rectangle(250,230,750, 150);
        Controlbtnbounds = new Rectangle(250,360,750, 150);

    }

    private void loadsettBackground() {
        settingsbg = LoadImages.GetSprite(LoadImages.Settingsimg);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(settingsbg, 0,0,1280,720,null);
        g.drawImage(Closeicon, 140, 65, 140, 140,null);
        g.drawImage(Audioicon, 250,230,750, 150, null);
        g.drawImage(Controlicon, 250,360,750, 150, null);
    }

    @Override
    public void mouseClicked(MouseEvent s) {
        Point clickPoint = s.getPoint();
        if (Audiobtnbounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.AUDIO;
            game.getAudioPlayer().playButtonSound();
        } else if (Closebtnbounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.MENU;
            game.getAudioPlayer().playButtonSound();
        } else if (Controlbtnbounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.CONTROLS;
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
