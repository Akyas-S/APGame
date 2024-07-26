
package levels;

import entity.EnemyManager;
import entity.Player;
import gamestates.Playing;
import utils.LoadImages;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;

public class Level3 {
    private EnemyManager enemyManager;
    private Player player;
    private Playing playing;

    private static BufferedImage background;
    // Load the background image for this level
    static {background = LoadImages.GetSprite(LoadImages.LEVEL3_BG);}

    public Level3(Playing playing, Player player) {
        this.playing = playing;
        this.player = player;
        this.enemyManager = new EnemyManager(playing, player, 5);

    }
    // Render the background and the enemies for this level
    // enmeies are drawn and updated using the EnemyManager object created in this class
    public void render(Graphics g){
        renderBackground(g);
        enemyManager.draw(g);
        enemyManager.update();
    }

    // method used to render the background image for this level
    public static void renderBackground(Graphics g) {
        if (background!= null) {
            g.drawImage(background, 0, 0,1280 ,720, null);
        } else {
            // Draw a default background or an error message
            g.setColor(Color.RED);
            g.drawString("Error loading background image", 10, 20);
        }

    }
}