package levels;

import entity.Player;
import gamestates.Gamestate;
import gamestates.Playing;
import main.GameController;
import utils.LoadImages;


import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelManager {
    private GameController game;
    private Playing playing;
    private  Player player;
    private Level1 level1;
    private Level2 level2;
    public boolean isLevel1;
    public boolean isLevel2 = false;
    public boolean clearEnemies = false;



    public LevelManager(GameController game, Playing playing, Player player){
        this.game = game;
        this.playing = playing;
        this.player = player;
        this.level1 = new Level1(playing, player);
        this.level2 = new Level2(playing, player);
        this.isLevel1 = true;
    }
    public void resetLevel() {
            isLevel1 = true;
            isLevel2 = false;
    }
    public void update(Graphics g) {
        if (isLevel1) {
            level1.render(g);
            if (player.playerScore >= 25) {

                isLevel1 = false;
                isLevel2 = true;
            }
        }
        if(isLevel2){
            level2.render(g);
            if (player.playerScore >= 50){
               isLevel2 = false;
            }
        }

    }

    public void render(Graphics g){
        update(g);
    }



}