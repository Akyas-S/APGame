
package levels;

import entity.EnemyManager;
import entity.Player;
import gamestates.Playing;
import utils.LoadImages;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;

public class Level2 {
    private EnemyManager enemyManager;
    private Player player;
    private Playing playing;
    private Timer timer;
    public Level2(Playing playing, Player player) {
        this.playing = playing;
        this.player = player;
        this.enemyManager = new EnemyManager(playing, player, 15);

    }

    public void render(Graphics g){
        enemyManager.draw(g);
        enemyManager.update();
        g.setFont(new Font("Ink Free", Font.BOLD,250));
        g.drawString("Level 2",500,200);
    }
}
