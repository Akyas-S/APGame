package gamestates;

import main.GameController;
import utils.LoadImages;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Pause extends State implements Statemethods {
    private BufferedImage pausebg;
    private BufferedImage resume;
    private BufferedImage settingsps;
    private BufferedImage quit;

    private Rectangle resumebtnbounds;
    private Rectangle settingspsbtnbounds;
    private Rectangle quitbtnbounds;

    public Pause (GameController game){
        super(game);
        loadPauseBackbground();
        loadPauseButtons();
    }

    private void loadPauseButtons() {
        resume = LoadImages.GetSprite(LoadImages.Resumebtnimg);
        settingsps = LoadImages.GetSprite(LoadImages.Settpsimg);
        quit = LoadImages.GetSprite(LoadImages.Quitbtnimg);


        resumebtnbounds = new Rectangle(155, 200, resume.getWidth(), resume.getHeight());
        settingspsbtnbounds = new Rectangle(155, 280, settingsps.getWidth(),settingsps.getHeight());
        quitbtnbounds = new Rectangle(155, 360, quit.getWidth(),quit.getHeight());

    }


    private void loadPauseBackbground() {
        pausebg = LoadImages.GetSprite(LoadImages.Pauseimg);
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(pausebg, 0, 0, null);
        g.drawImage(resume, 155, 200, null);
        g.drawImage(settingsps, 155, 280, null);
        g.drawImage(quit, 155, 360, null);

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
