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

    private boolean ispsMusicenabled = true;
    private boolean ispsSFXenabled = true;

    public Pause(GameController game, Player player) {
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


        pausemusicbtnbounds = new Rectangle(700, 280, 100, 100);
        pausesfxbtnbounds = new Rectangle(480, 280, 100, 100);
        resumebtnbounds = new Rectangle(345, 370, 600, 150);
        quitbtnbounds = new Rectangle(345, 470, 600, 150);

    }


    private void loadPauseBackbground() {
        pausebg = LoadImages.GetSprite(LoadImages.Pauseimg);
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(pausebg, 0, 0, 1280, 720, null);
        g.drawImage(resume, 345, 370, 600, 150, null);
        g.drawImage(quit, 345, 470, 600, 150, null);
        if (ispsMusicenabled) {
            g.drawImage(music, 700, 280, 100, 100, null);
        } else {
            g.drawImage(nomusic, 700, 280, 100, 100, null);
        }
        if (ispsSFXenabled) {
            g.drawImage(sfx, 480, 280, 100, 100, null);
        } else {
            g.drawImage(nosfx, 480, 280, 100, 100, null);
        }

    }


    @Override
    public void mouseClicked(MouseEvent pse) {
        Point clickPoint = pse.getPoint();
        if (resumebtnbounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.PLAYING;
            game.getAudioPlayer().playButtonSound();
        } else if (quitbtnbounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.MENU;
            game.getPlaying().resetAll();
            game.getPlaying().resetLevel();
            game.getPlaying().resetScore();
        } else if (pausemusicbtnbounds.contains(clickPoint)) {
            ispsMusicenabled = !ispsMusicenabled; // toggle music button state
            game.getAudioPlayer().playButtonSound();
            game.getAudioPlayer().toggleMusicMute();
        } else if (pausesfxbtnbounds.contains(clickPoint)) {
            ispsSFXenabled = !ispsSFXenabled; // toggle SFX button state
            game.getAudioPlayer().toggleSFXMute();
        }
    }


        @Override
        public void mousePressed (MouseEvent e){

        }

        @Override
        public void mouseReleased (MouseEvent e){

        }

        @Override
        public void mouseMoved (MouseEvent e){

        }

        @Override
        public void keyPressed (KeyEvent e){

        }

        @Override
        public void keyReleased (KeyEvent e){

        }
    }

