package levels;

import data.SaveLoad;
import entity.Player;
import gamestates.Gamestate;
import gamestates.Playing;
import main.GameController;
import utils.LoadImages;


import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelManager {

    // GameController, Playing, and Player objects
    private GameController game;
    private Playing playing;
    private static Player player;

    // Level objects
    private Level1 level1;
    private Level2 level2;

    // Boolean to track which level is currently active
    private boolean isLevel1;
    private boolean isLevel2 = false;

    // SaveLoad object to handle saving and loading game data
    private SaveLoad saveLoad;

    // Constructor for LevelManager
    public LevelManager(GameController game, Playing playing, Player player){
        this.game = game;
        this.playing = playing;
        this.player = player;
        this.level1 = new Level1(playing, player);
        this.level2 = new Level2(playing, player);
        this.isLevel1 = true;

        // Create SaveLoad object to handle saving and loading game data
        SaveLoad saveLoad = new SaveLoad(player);
        this.saveLoad = saveLoad;
    }

    // method to set the level to Level 1
    public void resetLevel() {
            isLevel1 = true;
            isLevel2 = false;
    }

    // Update method for LevelManager
    public void update(Graphics g) {
        if (isLevel1) {
            level1.render(g);
            if (player.playerScore >= 25) {
                Gamestate.state = Gamestate.NEXTLEVEL2;
                isLevel1 = false;
                isLevel2 = true;

                // Calculate and save coins earned in Level 1
                calcuateCoins(player.playerScore);
                saveLoad.saveCoins();
                System.out.println("Total coins: " + player.playerTotalCoins);
            }
        }
        // If Level 2 is active, render it and check for level completion
        if (isLevel2) {
            level2.render(g);
            // If player score reaches 50, move to Level 3
            if (player.playerScore >= 50) {
                isLevel2 = false;
                Gamestate.state = Gamestate.VICTORY;
                // Calculate and save coins earned in Level 2
                calcuateCoins(player.playerScore);
                saveLoad.saveCoins();
                System.out.println("Total coins: " + player.playerTotalCoins);
            }
        }

    }

    // Calculate coins earned based on player score
    private void calcuateCoins(int Score){
        player.playerCurrentCoins = Score / 2;
        player.playerTotalCoins += player.playerCurrentCoins;
        System.out.println("Current coins: " + player.playerCurrentCoins);
        System.out.println("Total coins: " + player.playerTotalCoins);
    }


    public void render(Graphics g){
        update(g);
    }



}