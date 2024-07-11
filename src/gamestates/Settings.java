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
    private BufferedImage Videoicon;

    private Rectangle Closebtnbounds;
    private Rectangle Audiobtnbounds;
    private Rectangle Controlbtnbounds;
    private Rectangle Videobtnbounds;

    public Settings(GameController game){
        super(game);
        loadsettBackground();
        loadsettButtons();
    }

    private void loadsettButtons() {
        Closeicon = LoadImages.GetSprite(LoadImages.Closebtnimg);
        Audioicon = LoadImages.GetSprite(LoadImages.Audiobtnimg);
        Controlicon = LoadImages.GetSprite(LoadImages.Controlsbtnimg);
        Videoicon = LoadImages.GetSprite(LoadImages.Videobtnimg);

        Closebtnbounds = new Rectangle(190, 90, Closeicon.getWidth(), Closeicon.getHeight());
        Audiobtnbounds = new Rectangle(460, 350, Audioicon.getWidth(), Audioicon.getHeight());
        Controlbtnbounds = new Rectangle(460, 700, Controlicon.getWidth(), Controlicon.getHeight());
        Videobtnbounds = new Rectangle(460, 525, Videoicon.getWidth(), Videoicon.getHeight());

    }

    private void loadsettBackground() {
        settingsbg = LoadImages.GetSprite(LoadImages.Settingsimg);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(settingsbg, 0,0,null);
        g.drawImage(Audioicon, 460,350,null);
        g.drawImage(Closeicon, 190,90,null);
        g.drawImage(Controlicon, 460,700,null);
        g.drawImage(Videoicon, 460,525,null);
    }

    @Override
    public void mouseClicked(MouseEvent s) {
        Point clickPoint = s.getPoint();
        if (Audiobtnbounds.contains(clickPoint)) {
            System.out.println("Audio");
        } else if (Closebtnbounds.contains(clickPoint)) {
            System.out.println("Close");
        } else if (Controlbtnbounds.contains(clickPoint)) {
            System.out.println("Control");
        } else if (Videobtnbounds.contains(clickPoint)) {
            System.out.println("Video");
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
