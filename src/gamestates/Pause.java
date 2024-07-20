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
    private BufferedImage music;
    private BufferedImage nomusic;
    private BufferedImage sfx;
    private BufferedImage nosfx;
    private BufferedImage quit;
    private Player player;

    private Rectangle resumebtnbounds;
    private Rectangle settingspsbtnbounds;
    private Rectangle quitbtnbounds;
    private Rectangle pausemusicbtnbounds;
    private Rectangle pausesfxbtnbounds;

    public Pause (GameController game, Player player){
        super(game);
        loadPauseBackbground();
        loadPauseButtons();
        this.player = player;
    }

    private void loadPauseButtons() {
        music = LoadImages.GetSprite(LoadImages.PAUSEMUSICBTN);
        sfx = LoadImages.GetSprite(LoadImages.PAUSESFXBTN);
        nomusic = LoadImages.GetSprite(LoadImages.PAUSENOMUSICBTN);
        nosfx = LoadImages.GetSprite(LoadImages.PAUSENOSFXBTN);
        resume = LoadImages.GetSprite(LoadImages.Resumebtnimg);
        quit = LoadImages.GetSprite(LoadImages.Quitbtnimg);


        pausemusicbtnbounds = new Rectangle(300,260,100,100);
        pausesfxbtnbounds = new Rectangle(500,260,100,100);
        resumebtnbounds = new Rectangle(345, 370, 600, 150);
        quitbtnbounds = new Rectangle(345, 470, 600, 150);

    }


    private void loadPauseBackbground() {
        pausebg = LoadImages.GetSprite(LoadImages.Pauseimg);
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(pausebg, 0, 0,1280,720, null);
        g.drawImage(resume, 345, 370, 600, 150,null);
        g.drawImage(quit, 345, 470, 600, 150,null);
        g.drawImage(music,300,260,100,100,null);
        g.drawImage(sfx,500,260,100,100,null);

    }

    @Override
    public void mouseClicked(MouseEvent pse) {
        Point clickPoint = pse.getPoint();

        if (resumebtnbounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.PLAYING;
            game.getAudioPlayer().playButtonSound();
        } else if (quitbtnbounds.contains(clickPoint)){
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
