package levels;

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
    private boolean isLevel1;
    private boolean isLevel2 = false;

    private static BufferedImage background;

    static {
        background = LoadImages.GetSprite(LoadImages.LEVEL_BG);
    }

    public LevelManager(GameController game, Playing playing, Player player){
        this.game = game;
        this.playing = playing;
        this.player = player;
        this.level1 = new Level1(playing, player);
        this.level2 = new Level2(playing, player);
        this.isLevel1 = true;
    }

    public void update(Graphics g) {
        if (isLevel1) {
            level1.render(g);
            if (player.playerScore >= 50) {
                isLevel1 = false;
                isLevel2 = true;
            }
        }
        if(isLevel2){
            level2.render(g);
            if (player.playerScore >= 100){
               isLevel2 = false;
            }
        }
    }

    public void render(Graphics g){
        update(g);
    }

    public static void renderBackground(Graphics g) {
        if (background!= null) {
            g.drawImage(background, 0, 0,null);
        } else {
            // Draw a default background or an error message
            g.setColor(Color.RED);
            g.drawString("Error loading background image", 10, 20);
        }
    }
}