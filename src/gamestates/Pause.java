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
        //settingsps = LoadImages.GetSprite(LoadImages.Settpsimg);
        quit = LoadImages.GetSprite(LoadImages.Quitbtnimg);


        resumebtnbounds = new Rectangle(345, 370, 600, 150);
        //settingspsbtnbounds = new Rectangle(345, 370, 600, 150);
        quitbtnbounds = new Rectangle(345, 470, 600, 150);

    }


    private void loadPauseBackbground() {
        pausebg = LoadImages.GetSprite(LoadImages.Pauseimg);
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(pausebg, 0, 0,1280,720, null);
        g.drawImage(resume, 345, 370, 600, 150,null);
        //g.drawImage(settingsps, 345, 370,600, 150, null);
        g.drawImage(quit, 345, 470, 600, 150,null);

    }

    @Override
    public void mouseClicked(MouseEvent pse) {
        Point clickPoint = pse.getPoint();

        if (resumebtnbounds.contains(clickPoint)) {

            Gamestate.state = Gamestate.PLAYING;
            game.getAudioPlayer().playButtonSound();

        }
//        else if (settingspsbtnbounds.contains(clickPoint)) {
//
//            Gamestate.state = Gamestate.SETTINGS;
//            game.getAudioPlayer().playButtonSound();
//
//        }
        else if (quitbtnbounds.contains(clickPoint))
        {
            Gamestate.state = Gamestate.MENU;
            game.getPlaying().resetAll();
            game.getPlaying().resetLevel();
            game.getPlaying().resetScore();

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
