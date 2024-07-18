package levels;

import entity.EnemyManager;
import entity.Player;
import gamestates.Playing;

import java.awt.*;
import java.util.Timer;

public class Level3 {
    private EnemyManager enemyManager;
    private Player player;
    private Playing playing;
    private Timer timer;

    public Level3(Playing playing, Player player) {
        this.playing = playing;
        this.player = player;
        this.enemyManager = new EnemyManager(playing, player, 15);

    }

    public void render(Graphics g){
        enemyManager.draw(g);
        enemyManager.update();
        g.setFont(new Font("Ink Free", Font.BOLD,150));
        g.drawString("Level 3",1000,200);
    }
}
