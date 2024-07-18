package gamestates;

import main.GameController;
import utils.LoadImages;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class LevelCompleted extends State implements Statemethods {
    private BufferedImage background;

    private BufferedImage Menuicon;
    private BufferedImage Replayicon;
    private BufferedImage Nexticon;

    private Rectangle menuButtonBounds;
    private Rectangle replayButtonBounds;
    private Rectangle nextButtonBounds;

    public LevelCompleted(GameController game) {
        super(game);
        loadBackground();
        loadButtons();
    }

    private void loadBackground() {background = LoadImages.GetSprite(LoadImages.WON_BG);
    }

    private void loadButtons() {
        Menuicon = LoadImages.GetSprite(LoadImages.MENU_BUTTON);
        Replayicon = LoadImages.GetSprite(LoadImages.REPLAY_BUTTON);
        Nexticon = LoadImages.GetSprite(LoadImages.NEXT_LVL);

        menuButtonBounds = new Rectangle(500, 200, 294, 91);
        replayButtonBounds = new Rectangle(700, 200, 294, 91);
        nextButtonBounds = new Rectangle(600, 310, 294, 91);

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(background, 0,0,1280,720,null);
        g.drawImage(Menuicon, 500,200,294, 91,null);
        g.drawImage(Replayicon, 700,200,294, 91, null);
        g.drawImage(Nexticon, 600, 310, 294, 91, null);


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point clickPoint = e.getPoint();
        if (menuButtonBounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.MENU;
            game.getAudioPlayer().playMenuButtonSound();
        } // else if (replayButtonBounds.contains(clickPoint)) {
          //Gamestate.state = Gamestate.;
          //game.getAudioPlayer().playMenuButtonSound();
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

    } else if (nextButtonBounds.contains(clickPoint) {
            Gamestate.state = Gamestate.PLAYING;
            game.getAudioPlayer().playMenuButtonSound();
        }


