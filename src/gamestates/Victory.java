package gamestates;

import entity.Player;
import levels.LevelManager;
import main.GameController;
import utils.LoadImages;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Victory extends State implements Statemethods {
    private BufferedImage background;

    private Rectangle menuButtonBounds;


    private Playing playing;
    LevelManager levelManager;


    public Victory(GameController game) {
        super(game);
        loadBackground();
        loadButtons();
    }

    private void loadBackground() {
        background = LoadImages.GetSprite(LoadImages.WON_BG);
    }

    private void loadButtons() {

        menuButtonBounds = new Rectangle(548, 469, 192, 73);


    }

    @Override
    public void render(Graphics g) {
        g.drawImage(background, 0, 0, 1280, 720, null);
    }

    // Define what happens when the mouse is clicked
    @Override
    public void mouseClicked(MouseEvent e) {
        Point clickPoint = e.getPoint();
        if (menuButtonBounds.contains(clickPoint)) {
            game.getAudioPlayer().playMenuButtonSound();
            game.getPlaying().resetAll();
            game.getPlaying().resetLevel();
            game.getPlaying().resetScore();

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