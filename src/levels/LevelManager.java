package levels;

import data.SaveLoad;
import entity.Player;
import gamestates.Playing;
import main.GameController;
import utils.LoadImages;


import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelManager {
    private GameController game;
    private Playing playing;
    private static Player player;
    private Level1 level1;
    private Level2 level2;
    private Level3 level3;
    private boolean isLevel1;
    private boolean isLevel2 = false;
    private boolean islevel3 = false;
    private SaveLoad saveLoad;



    public LevelManager(GameController game, Playing playing, Player player){
        this.game = game;
        this.playing = playing;
        this.player = player;
        this.level1 = new Level1(playing, player);
        this.level2 = new Level2(playing, player);
        this.level3 = new Level3(playing, player);
        this.isLevel1 = true;
        SaveLoad saveLoad = new SaveLoad(player);
        this.saveLoad = saveLoad;
    }

    public void update(Graphics g) {
        if (isLevel1) {
            level1.render(g);
            if (player.playerScore >= 50) {
                isLevel1 = false;
                isLevel2 = true;
                calcuateCoins(player.playerScore);
                saveLoad.saveCoins();
                System.out.println("Total coins: " + player.playerTotalCoins);
            }
        }
        if(isLevel2){
            level2.render(g);
            if (player.playerScore >= 100){
               isLevel2 = false;
               islevel3 = true;
               calcuateCoins(player.playerScore);
               saveLoad.saveCoins();
                System.out.println("Total coins: " + player.playerTotalCoins);
            }
        }
        if(islevel3){
            level3.render(g);
            if(player.playerScore == 200){
                islevel3 = false;
                calcuateCoins(player.playerScore);
                saveLoad.saveCoins();
                System.out.println("Total coins: " + player.playerTotalCoins);
            }
        }
    }
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