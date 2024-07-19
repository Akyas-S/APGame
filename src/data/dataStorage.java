package data;

// Importing the Serializable interface
import java.io.Serializable;

// Public class dataStorage that implements Serializable
public class dataStorage implements Serializable {

    // Integer to store the player's high score
    int playerHighScore;
    // Integer to store the player's coins
    int playerCoins;
    public boolean isSFXMuted;
    public boolean isMusicMuted;
}