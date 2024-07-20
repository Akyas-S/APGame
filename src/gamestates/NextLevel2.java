package gamestates;

import levels.LevelManager;
import main.GameController;
import utils.LoadImages;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class NextLevel2 extends State implements Statemethods {
    private BufferedImage background;


    private Rectangle menuButtonBounds;
    private Rectangle replayButtonBounds;
    private Rectangle nextButtonBounds;

    private Playing playing;
    private LevelManager levelManager;


    public NextLevel2(GameController game) {
        super(game);
        playing = new Playing(game);
        loadBackground();
        loadButtons();
    }

    private void loadBackground() {
        background = LoadImages.GetSprite(LoadImages.NEXT_BG);
    }

    private void loadButtons() {

        menuButtonBounds = new Rectangle(575, 508, 120, 51);
        replayButtonBounds= new Rectangle(488, 442, 113, 51);
        nextButtonBounds = new Rectangle(690, 442, 120, 51);

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(background, 0, 0, 1280, 720, null);

        g.setColor(Color.red);
        g.drawRect(575, 508, 120, 51);
        g.drawRect(488, 442, 113, 51);
        g.drawRect(690, 442, 120, 51);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point clickPoint = e.getPoint();
        if (menuButtonBounds.contains(clickPoint)) {
            game.getAudioPlayer().playMenuButtonSound();

            //game resetting test
            game.getPlayer().menu = true;
            game.getPlaying().getLevelManager().isLevel1=true;
            game.getPlaying().getLevelManager().isLevel2=false;



            Gamestate.state = Gamestate.MENU;

        } else if (replayButtonBounds.contains(clickPoint)) {

            game.getAudioPlayer().playMenuButtonSound();

            game.getPlayer().dead = true;
            game.getPlaying().getLevelManager().isLevel1=true;
            game.getPlaying().getLevelManager().isLevel2=false;


            Gamestate.state = Gamestate.PLAYING;

        }else if (nextButtonBounds.contains(clickPoint)) {

            game.getPlayer().menu = true;
            Gamestate.state = Gamestate.PLAYING;

            game.getAudioPlayer().playMenuButtonSound();
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