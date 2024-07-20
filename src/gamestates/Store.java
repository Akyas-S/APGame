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
    private BufferedImage buybtn;
    private BufferedImage buybtn2;
    private BufferedImage buybtn3;
    private BufferedImage buybtn4;
    private BufferedImage buybtn5;
    private BufferedImage buybtn6;
    private BufferedImage buybtn7;
    private BufferedImage buybtn8;
    private BufferedImage buybtn9;
    private BufferedImage buybtn10;
    private BufferedImage buybtn11;
    private BufferedImage buybtn12;

    private BufferedImage equipbtn;
    private BufferedImage equipbtn2;
    private BufferedImage equipbtn3;
    private BufferedImage equipbtn4;
    private BufferedImage equipbtn5;
    private BufferedImage equipbtn6;
    private BufferedImage equipbtn7;
    private BufferedImage equipbtn8;
    private BufferedImage equipbtn9;
    private BufferedImage equipbtn10;
    private BufferedImage equipbtn11;
    private BufferedImage equipbtn12;

    private Rectangle closestorebtnbounds;
    private Rectangle buybtnbounds;
    private Rectangle buybtnbounds2;
    private Rectangle buybtnbounds3;
    private Rectangle buybtnbounds4;
    private Rectangle buybtnbounds5;
    private Rectangle buybtnbounds6;
    private Rectangle buybtnbounds7;
    private Rectangle buybtnbounds8;
    private Rectangle buybtnbounds9;
    private Rectangle buybtnbounds10;
    private Rectangle buybtnbounds11;
    private Rectangle buybtnbounds12;
    private Rectangle equipbtnbounds;
    private Rectangle equipbtnbounds2;
    private Rectangle equipbtnbounds3;
    private Rectangle equipbtnbounds4;
    private Rectangle equipbtnbounds5;
    private Rectangle equipbtnbounds6;
    private Rectangle equipbtnbounds7;
    private Rectangle equipbtnbounds8;
    private Rectangle equipbtnbounds9;
    private Rectangle equipbtnbounds10;
    private Rectangle equipbtnbounds11;
    private Rectangle equipbtnbounds12;


    public Store(GameController game) {
        super(game);
        loadStoreBackground();
        loadStoreButtons();
    }

    private void loadStoreButtons() {
        closestorebtn = LoadImages.GetSprite(LoadImages.Closebtnimg);
        buybtn = LoadImages.GetSprite(LoadImages.BUYBTN);
        buybtn2 = LoadImages.GetSprite(LoadImages.BUYBTN);
        buybtn3 = LoadImages.GetSprite(LoadImages.BUYBTN);
        buybtn4 = LoadImages.GetSprite(LoadImages.BUYBTN);
        buybtn5 = LoadImages.GetSprite(LoadImages.BUYBTN);
        buybtn6 = LoadImages.GetSprite(LoadImages.BUYBTN);
        buybtn7 = LoadImages.GetSprite(LoadImages.BUYBTN);
        buybtn8 = LoadImages.GetSprite(LoadImages.BUYBTN);
        buybtn9 = LoadImages.GetSprite(LoadImages.BUYBTN);
        buybtn10 = LoadImages.GetSprite(LoadImages.BUYBTN);
        buybtn11 = LoadImages.GetSprite(LoadImages.BUYBTN);
        buybtn12 = LoadImages.GetSprite(LoadImages.BUYBTN);

        equipbtn = LoadImages.GetSprite(LoadImages.EQUIPBTN);
        equipbtn2 = LoadImages.GetSprite(LoadImages.EQUIPBTN);
        equipbtn3 = LoadImages.GetSprite(LoadImages.EQUIPBTN);
        equipbtn4 = LoadImages.GetSprite(LoadImages.EQUIPBTN);
        equipbtn5 = LoadImages.GetSprite(LoadImages.EQUIPBTN);
        equipbtn6 = LoadImages.GetSprite(LoadImages.EQUIPBTN);
        equipbtn7 = LoadImages.GetSprite(LoadImages.EQUIPBTN);
        equipbtn8 = LoadImages.GetSprite(LoadImages.EQUIPBTN);
        equipbtn9 = LoadImages.GetSprite(LoadImages.EQUIPBTN);
        equipbtn10 = LoadImages.GetSprite(LoadImages.EQUIPBTN);
        equipbtn11 = LoadImages.GetSprite(LoadImages.EQUIPBTN);
        equipbtn12 = LoadImages.GetSprite(LoadImages.EQUIPBTN);

        closestorebtnbounds = new Rectangle(20, 20, 140, 140);
        buybtnbounds = new Rectangle(430,290,68, 30);
        buybtnbounds2 = new Rectangle(600,290,68, 30);
        buybtnbounds3 = new Rectangle(870,295,68, 30);
        buybtnbounds4 = new Rectangle(1040,295,68, 30);
        buybtnbounds5 = new Rectangle(430,455,68, 30);
        buybtnbounds6 = new Rectangle(600,455,68, 30);
        buybtnbounds7 = new Rectangle(870,455,68, 30);
        buybtnbounds8 = new Rectangle(1040,455,68, 30);
        buybtnbounds9 = new Rectangle(430,610,68, 30);
        buybtnbounds10 = new Rectangle(870,610,68, 30);
        buybtnbounds11 = new Rectangle(1040,610,68, 30);
        buybtnbounds12 = new Rectangle(430,610,68, 30);

        equipbtnbounds = new Rectangle(500, 290, 68, 30);
        equipbtnbounds2 = new Rectangle(670, 290, 68, 30);
        equipbtnbounds3 = new Rectangle(940, 295, 68, 30);
        equipbtnbounds4 = new Rectangle(1110, 295, 68, 30);
        equipbtnbounds5 = new Rectangle(500, 455, 68, 30);
        equipbtnbounds6 = new Rectangle(670, 455, 68, 30);
        equipbtnbounds7 = new Rectangle(940, 455, 68, 30);
        equipbtnbounds8 = new Rectangle(1110, 455, 68, 30);
        equipbtnbounds9 = new Rectangle(500, 610, 68, 30);
        equipbtnbounds10 = new Rectangle(670, 610, 68, 30);
        equipbtnbounds11 = new Rectangle(940, 610, 68, 30);
        equipbtnbounds12 = new Rectangle(1110, 610, 68, 30);
    }

    private void loadStoreBackground() {
        store = LoadImages.GetSprite(LoadImages.Storebg);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(store, 0, 0,1280,720, null);
        g.drawImage(closestorebtn, 20, 20, 140, 140, null);
        g.drawImage(buybtn, 430, 290, 68, 30, null);
        g.drawImage(buybtn2, 600, 290, 68, 30, null);
        g.drawImage(buybtn3, 870, 295, 68, 30, null);
        g.drawImage(buybtn4, 1040, 295, 68, 30, null);
        g.drawImage(buybtn5, 430, 455, 68, 30, null);
        g.drawImage(buybtn6, 600, 455, 68, 30, null);
        g.drawImage(buybtn7, 870, 455, 68, 30, null);
        g.drawImage(buybtn8, 1040, 455, 68, 30, null);
        g.drawImage(buybtn9, 430, 610, 68, 30, null);
        g.drawImage(buybtn10, 600, 610, 68, 30, null);
        g.drawImage(buybtn11, 870, 610, 68, 30, null);
        g.drawImage(buybtn12, 1040, 610, 68, 30, null);

        g.drawImage(equipbtn, 500,290, 68, 30, null);
        g.drawImage(equipbtn2, 670, 290, 68, 30, null);
        g.drawImage(equipbtn3, 940, 295, 68, 30, null);
        g.drawImage(equipbtn4, 1110, 295, 68, 30, null);
        g.drawImage(equipbtn5, 500, 455, 68, 30, null);
        g.drawImage(equipbtn6, 670, 455, 68, 30, null);
        g.drawImage(equipbtn7, 940, 455, 68, 30, null);
        g.drawImage(equipbtn8, 1110, 455, 68, 30, null);
        g.drawImage(equipbtn9, 500, 610, 68, 30, null);
        g.drawImage(equipbtn10, 670, 610, 68, 30, null);
        g.drawImage(equipbtn11, 940, 610, 68, 30, null);
        g.drawImage(equipbtn12, 1110, 610, 68, 30, null);

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
