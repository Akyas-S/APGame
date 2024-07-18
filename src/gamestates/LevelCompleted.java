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

        menuButtonBounds = new Rectangle(500, 200, 294, 91);
        replayButtonBounds = new Rectangle(500, 310, 294, 91);

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(background, 0,0,1280,720,null);
        g.drawImage(Menuicon, 500,200,294, 91,null);
        g.drawImage(Replayicon, 500,310,294, 91, null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point clickPoint = e.getPoint();
        if (menuButtonBounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.MENU;
            game.getAudioPlayer().playMenuButtonSound();
        } else if (storeButtonBounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.STORE;
            game.getAudioPlayer().playMenuButtonSound();
        } else if (settingsButtonBounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.SETTINGS;
            game.getAudioPlayer().playMenuButtonSound();
        } else if (exitButtonBounds.contains(clickPoint)) {
            game.getAudioPlayer().playMenuButtonSound();
            System.exit(0);
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

