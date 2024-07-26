package Inputs;

import gamestates.Gamestate;
import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class  KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;
    // Constructor for KeyboardInputs
    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel=gamePanel;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }
// This method is used to handle key presses in the game
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

            case NEXTLEVEL:
                gamePanel.getGame().getNextLevel().keyPressed(e);
                break;
            case DEATH:
                gamePanel.getGame().getDeath().keyPressed(e);
                break;
            case VICTORY:
                gamePanel.getGame().getVictory().keyPressed(e);
                break;
            default:
                break;
        }
    }
// This method is used to handle key releases in the game
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

            case NEXTLEVEL:
                gamePanel.getGame().getNextLevel().keyReleased(e);
                break;
            case DEATH:
                gamePanel.getGame().getDeath().keyReleased(e);
                break;
            case VICTORY:
                gamePanel.getGame().getVictory().keyReleased(e);
                break;
            default:
                break;
        }
    }

}
