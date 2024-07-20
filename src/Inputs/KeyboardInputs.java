package Inputs;

import gamestates.Gamestate;
import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class  KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel=gamePanel;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (Gamestate.state){
            case MENU:
                gamePanel.getGame().getMenu().keyPressed(e);
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().keyPressed(e);
                break;
            case SETTINGS:
                gamePanel.getGame().getSettings().keyPressed(e);
                break;
            case AUDIO:
                gamePanel.getGame().getAudio().keyPressed(e);
                break;
            case CONTROLS:
                gamePanel.getGame().getControls().keyPressed(e);
                break;
            case PAUSE:
                gamePanel.getGame().getPause().keyPressed(e);
                break;
            case STORE:
                gamePanel.getGame().getStore().keyPressed(e);
                break;
            default:
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (Gamestate.state){
            case MENU:
                gamePanel.getGame().getMenu().keyReleased(e);
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().keyReleased(e);
                break;
            case SETTINGS:
                gamePanel.getGame().getSettings().keyReleased(e);
                break;
            case AUDIO:
                gamePanel.getGame().getAudio().keyReleased(e);
                break;
            case CONTROLS:
                gamePanel.getGame().getControls().keyReleased(e);
                break;
            case PAUSE:
                gamePanel.getGame().getPause().keyReleased(e);
                break;
            case STORE:
                gamePanel.getGame().getStore().keyReleased(e);
                break;
            default:
                break;
        }
    }

}
