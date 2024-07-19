package Inputs;

import gamestates.Gamestate;
import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static utils.Constants.Directions.*;


public class KeyboardInputs implements KeyListener {

    // Private variable to store the GamePanel instance
    private GamePanel gamePanel;

    // Constructor for the KeyboardInputs class that takes in a GamePanel instance
    public KeyboardInputs(GamePanel gamePanel){
        // Setting the gamePanel instance
        this.gamePanel=gamePanel;
    }

    // Override method for the keyTyped event (not implemented)
    @Override
    public void keyTyped(KeyEvent e) {

    }

    // Override method for the keyPressed event
    @Override
    public void keyPressed(KeyEvent e) {
        // Switch statement to handle different game states
        switch (Gamestate.state){
            // If the game state is MENU
            case MENU:
                // Call the keyPressed method on the Menu instance
                gamePanel.getGame().getMenu().keyPressed(e);
                break;
            // If the game state is PLAYING
            case PLAYING:
                // Call the keyPressed method on the Playing instance
                gamePanel.getGame().getPlaying().keyPressed(e);
                break;
            // If the game state is SETTINGS
            case SETTINGS:
                // Call the keyPressed method on the Settings instance
                gamePanel.getGame().getSettings().keyPressed(e);
                break;
            // If the game state is AUDIO
            case AUDIO:
                // Call the keyPressed method on the Audio instance
                gamePanel.getGame().getAudio().keyPressed(e);
                break;
            // If the game state is CONTROLS
            case CONTROLS:
                // Call the keyPressed method on the Controls instance
                gamePanel.getGame().getControls().keyPressed(e);
                break;
            // If the game state is PAUSE
            case PAUSE:
                // Call the keyPressed method on the Pause instance
                gamePanel.getGame().getPause().keyPressed(e);
                break;
            // If the game state is NEXTLEVEL2
            case NEXTLEVEL2:
                // Call the keyPressed method on the NextLevel2 instance
                gamePanel.getGame().getNextLevel2().keyPressed(e);
                break;
            // Default case (do nothing)
            default:
                break;
        }
    }

    // Override method for the keyReleased event
    public void keyReleased(KeyEvent e) {
        // Switch statement to handle different game states
        switch (Gamestate.state){
            // If the game state is MENU
            case MENU:
                // Call the keyReleased method on the Menu instance
                gamePanel.getGame().getMenu().keyReleased(e);
                break;
            // If the game state is PLAYING
            case PLAYING:
                // Call the keyReleased method on the Playing instance
                gamePanel.getGame().getPlaying().keyReleased(e);
                break;
            // If the game state is SETTINGS
            case SETTINGS:
                // Call the keyReleased method on the Settings instance
                gamePanel.getGame().getSettings().keyReleased(e);
                break;
            // If the game state is AUDIO
            case AUDIO:
                // Call the keyReleased method on the Audio instance
                gamePanel.getGame().getAudio().keyReleased(e);
                break;
            // If the game state is CONTROLS
            case CONTROLS:
                // Call the keyReleased method on the Controls instance
                gamePanel.getGame().getControls().keyReleased(e);
                break;
            // If the game state is PAUSE
            case PAUSE:
                // Call the keyReleased method on the Pause instance
                gamePanel.getGame().getPause().keyReleased(e);
                // If the game state is NEXTLEVEL2
            case NEXTLEVEL2:
                // Call the keyReleased method on the NextLevel2 instance
                gamePanel.getGame().getNextLevel2().keyReleased(e);
                break;
            // Default case (do nothing)
            default:
                break;
        }
    }
}