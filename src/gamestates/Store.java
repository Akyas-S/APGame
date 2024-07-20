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
    private Rectangle buySkin1;
    private Rectangle equipSkin1;
    private Rectangle buySkin2;
    private Rectangle equipSkin2;

    public Store(GameController game) {
        super(game);
        loadStoreBackground();
        loadStoreButtons();
    }

    private void loadStoreButtons() {
        closestorebtn = LoadImages.GetSprite(LoadImages.Closebtnimg);
        closestorebtnbounds = new Rectangle(20, 20, 140, 140);


        buySkin1= new Rectangle(436, 292, 52, 26);
        equipSkin1 = new Rectangle(500, 292, 52, 26);
        buySkin2 = new Rectangle(607, 292, 52, 26);
        equipSkin2 = new Rectangle(673, 292, 52, 26);
    }

    private void loadStoreBackground() {
        store = LoadImages.GetSprite(LoadImages.Storebg);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(store, 0, 0,1280,720, null);
        g.drawImage(closestorebtn, 20, 20, 140, 140, null);

        g.setColor(Color.red);
        g.drawRect(436, 292, 52, 26);
        g.drawRect(500, 292, 52, 26);
        g.drawRect(607, 292, 52, 26);
        g.drawRect(673, 292, 52, 26);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("BUY", 436, 315);
        g.drawString("EQUIP", 500, 315);
        g.drawString("BUY", 607, 315);
        g.drawString("EQUIP", 673, 315);

    }

    @Override
    public void mouseClicked(MouseEvent aud) {
        Point clickPoint = aud.getPoint();
        if (closestorebtnbounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.MENU;
            game.getAudioPlayer().playButtonSound();
        }

        if (buySkin1.contains(clickPoint)) {
            game.getAudioPlayer().playButtonSound();
        }
        if (buySkin2.contains(clickPoint)) {
            game.getAudioPlayer().playButtonSound();
        }
        if (equipSkin1.contains(clickPoint)) {
            game.getAudioPlayer().playButtonSound();
        }
        if (equipSkin2.contains(clickPoint)) {
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
