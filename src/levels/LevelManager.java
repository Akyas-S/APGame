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
    private Player player;
    private static Level1 level1;

    private static BufferedImage background;

    static {
        background = LoadImages.GetSprite(LoadImages.LEVEL_BG);
    }

    public LevelManager(GameController game, Playing playing, Player player){
        this.game = game;
        this.playing = playing;
        this.player = player;
        this.level1 = new Level1(playing, player);
    }

    public static void drawLevels(Graphics g){
        level1.render(g);
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