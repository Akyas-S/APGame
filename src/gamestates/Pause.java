package gamestates;

import entity.Player;
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
    private Player player;

    private Rectangle resumebtnbounds;
    private Rectangle settingspsbtnbounds;
    private Rectangle quitbtnbounds;

    public Pause (GameController game, Player player){
        super(game);
        loadPauseBackbground();
        loadPauseButtons();
        this.player = player;
    }

    private void loadPauseButtons() {
        resume = LoadImages.GetSprite(LoadImages.Resumebtnimg);
        settingsps = LoadImages.GetSprite(LoadImages.Settpsimg);
        quit = LoadImages.GetSprite(LoadImages.Quitbtnimg);


        resumebtnbounds = new Rectangle(585, 370, resume.getWidth(), resume.getHeight());
        settingspsbtnbounds = new Rectangle(585, 520, settingsps.getWidth(),settingsps.getHeight());
        quitbtnbounds = new Rectangle(585, 670, quit.getWidth(),quit.getHeight());

    }


    private void loadPauseBackbground() {
        pausebg = LoadImages.GetSprite(LoadImages.Pauseimg);
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(pausebg, 0, 0, null);
        g.drawImage(resume, 585, 370, null);
        g.drawImage(settingsps, 585, 520, null);
        g.drawImage(quit, 585, 670, null);

    }

    @Override
    public void mouseClicked(MouseEvent pse) {
        Point clickPoint = pse.getPoint();
        if (resumebtnbounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.PLAYING;
        } else if (settingspsbtnbounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.SETTINGS;
        } else if (quitbtnbounds.contains(clickPoint)) {
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
