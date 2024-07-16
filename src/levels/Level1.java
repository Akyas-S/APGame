

package levels;

import entity.EnemyManager;
import entity.Player;
import gamestates.Playing;
import utils.LoadImages;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Level1 {
    private EnemyManager enemyManager;
    private Player player;
    private Playing playing;

    public Level1(Playing playing, Player player) {
        this.playing = playing;
        this.player = player;
        this.enemyManager = new EnemyManager(playing, player, 5);
    }

    public void render(Graphics g){
        enemyManager.draw(g);
        enemyManager.update();
    }
}
