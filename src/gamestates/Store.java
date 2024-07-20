package gamestates;

import main.GameController;
import utils.LoadImages;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Store extends State implements Statemethods {
    private BufferedImage store;
    private BufferedImage closestorebtn;

    private Rectangle closestorebtnbounds;

    public Store(GameController game) {
        super(game);
        loadStoreBackground();
        loadStoreButtons();
    }

    private void loadStoreButtons() {
        closestorebtn = LoadImages.GetSprite(LoadImages.Closebtnimg);

        closestorebtnbounds = new Rectangle(20, 20, 140, 140);
    }

    private void loadStoreBackground() {
        store = LoadImages.GetSprite(LoadImages.Storebg);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(store, 0, 0,1280,720, null);
        g.drawImage(closestorebtn, 20, 20, 140, 140, null);

    }

    @Override
    public void mouseClicked(MouseEvent aud) {
        Point clickPoint = aud.getPoint();
        if (closestorebtnbounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.MENU;
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
