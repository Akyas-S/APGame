

package levels;

import entity.EnemyManager;
import entity.Player;
import gamestates.Playing;
import utils.LoadImages;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;

public class Level1 {
    private EnemyManager enemyManager;
    private Player player;
    private Playing playing;

    public Level1(Playing playing, Player player) {
        this.playing = playing;
        this.player = player;
        this.enemyManager = new EnemyManager(playing, player, 10);


    }

    public void render(Graphics g){
        enemyManager.draw(g);
        enemyManager.update();
        g.setFont(new Font("Ink Free", Font.BOLD,150));
        g.drawString("Level 1",1000,200);
    }
}
