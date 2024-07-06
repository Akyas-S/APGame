package Mainmenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    static final int screenwidth = 600;
    static final int screenheight = 600;
    static final int unit = 50;
    static final int delay = 50;
    boolean attacked = false;
    Timer enemytimer;
    boolean running = false;
    Timer timer;
    Random random;
    List<Point> enemies;
    Point player;

    GamePanel() {
        random = new Random();
        enemies = new ArrayList<>();
        this.setPreferredSize(new Dimension(screenwidth, screenheight));
        this.setBackground(Color.GREEN);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        running = true;
        timer = new Timer(delay, this);
        timer.start();
        enemytimer = new Timer(1000, this::actionPerformed);
        enemytimer.start();
        player = new Point(300, 300);
        spawnEnemy();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(player.x, player.y, unit, unit); // Draw player

        g.setColor(Color.BLACK);
        for (Point enemy : enemies) {
            g.fillRect(enemy.x, enemy.y, unit, unit); // Draw enemies
        }
        if (attacked){
            g.setColor(Color.BLUE);
            g.fillRect(player.x, player.y, 10,10);
        }
    }

    public void movePlayer(int dx, int dy) {
        int newX = player.x + dx;
        int newY = player.y + dy;

        if (newX >= 0 && newX < screenwidth && newY >= 0 && newY < screenheight) {
            player.x = newX;
            player.y = newY;
        }
    }


    public void moveEnemies() {
        for (Point enemy : enemies) {
            if (enemy.x < player.x) {
                enemy.x += 10;
            } else if (enemy.x > player.x) {
                enemy.x -= 10;
            }

            if (enemy.y < player.y) {
                enemy.y += 10;
            } else if (enemy.y > player.y) {
                enemy.y -= 10;
            }
        }
    }

    public void spawnEnemy() {
        int x = random.nextInt(screenwidth / unit) * unit;
        int y = random.nextInt(screenheight / unit) * unit;
        enemies.add(new Point(x, y));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enemytimer) {
            spawnEnemy(); // Spawn new enemy
        } else if (e.getSource() == timer) {
            moveEnemies(); // Move enemies towards player
            repaint();
        }
    }


    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    movePlayer(0, -(unit/2));
                    break;
                case KeyEvent.VK_S:
                    movePlayer(0, (unit/2));
                    break;
                case KeyEvent.VK_A:
                    movePlayer((-unit/2), 0);
                    break;
                case KeyEvent.VK_D:
                    movePlayer((unit/2), 0);
                    break;
            }
            repaint();
        }
    }
}