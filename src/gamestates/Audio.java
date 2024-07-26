package gamestates;

import main.GameController;
import utils.LoadImages;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

    public class Audio extends State implements Statemethods {

    private BufferedImage audiobg;
    private BufferedImage Closeaudicon;
    private BufferedImage Musicicon;
    private BufferedImage SFXicon;
    private BufferedImage NoSFXicon;// new image for alternate state
    private BufferedImage NoMusicicon;

    // new image for alternate state
    private boolean isSFXEnabled = true; // flag to track SFX button state
    private boolean isMusicEnabled = true;
    private Rectangle Closeaudbtnbounds;
    private Rectangle Musicbtnbounds;
    private Rectangle SFXbtnbounds;

    public Audio(GameController game){
        super(game);
        loadaudioBackground();
        loadaudioButtons();
    }

    private void loadaudioButtons() {
        Closeaudicon = LoadImages.GetSprite(LoadImages.Closebtnimg);
        Musicicon = LoadImages.GetSprite(LoadImages.Checkbtnimg);
        SFXicon = LoadImages.GetSprite(LoadImages.Checkbtnimg);
        NoSFXicon = LoadImages.GetSprite(LoadImages.Crossbtnimg);
        NoMusicicon = LoadImages.GetSprite(LoadImages.Crossbtnimg);
        Closeaudbtnbounds = new Rectangle(140, 65, 140, 140);
        Musicbtnbounds = new Rectangle(830,240,110, 110);
        SFXbtnbounds = new Rectangle(830,370,110, 110);
    }


    private void loadaudioBackground() {
        audiobg = LoadImages.GetSprite(LoadImages.Audioimg);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(audiobg, 0, 0,1280,720, null);
        g.drawImage(Closeaudicon, 140, 65, 140, 140, null);
        // render SFX button based on its state

        if (isMusicEnabled) {
            g.drawImage(Musicicon, 830,240,110, 110,null);
        } else {
            g.drawImage(NoMusicicon, 830,240,110, 110,null);
        }
        if (isSFXEnabled) {
            g.drawImage(SFXicon, 830,370,110, 110,null);
        } else {
            g.drawImage(NoSFXicon, 830,370,110, 110,null);
        }

    }

    @Override
    public void mouseClicked(MouseEvent aud) {
        Point clickPoint = aud.getPoint();
        if (Closeaudbtnbounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.SETTINGS;
            game.getAudioPlayer().playButtonSound();

        } else if (Musicbtnbounds.contains(clickPoint)) {
            isMusicEnabled = !isMusicEnabled; // toggle music button state
            game.getAudioPlayer().toggleMusicMute();

        } else if (SFXbtnbounds.contains(clickPoint)) {
            isSFXEnabled = !isSFXEnabled; // toggle SFX button state
            game.getAudioPlayer().toggleSFXMute();
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
