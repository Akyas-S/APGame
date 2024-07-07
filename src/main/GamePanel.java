package main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;


public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float PlayerX = 0;
    private float PlayerY = 0;
    private float[] EnemyX = new float[5];
    private float[] EnemyY = new float[5];
    private BufferedImage img;
    private Image enemy;
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 8;
    private Random rand = new Random();
    Point EnemyLocations[] = new Point[5];


    public GamePanel() {
        importImg();
        loadAnimations();
        GenerateEnemyLocations();
        EnemySpawn();

        mouseInputs = new MouseInputs(this);
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
        animations = new BufferedImage[10][10];

        for (int j = 0; j < animations.length; j++) {
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i * 128, j * 80, 128, 80);
            }
        }
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/cat2/catsprite.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

         is = getClass().getResourceAsStream("/cat/Idle (1).png");
        try {
            enemy = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1920, 1080);
        setPreferredSize(size);
    }

    public void Move(int X, int Y) {
        int newX = (int) (this.PlayerX + X);
        int newY = (int) (this.PlayerY + Y);

        // Check if the new position is within the map boundaries
        if (newX >= 0 && newX <= getWidth() - 100) {
            this.PlayerX = newX;
        }
        if (newY >= 0 && newY <= getHeight() - 100) {
            this.PlayerY = newY;
        }
    }

    private void GenerateEnemyLocations() {
       for (int i = 0; i < EnemyLocations.length; i++) { //loop through the array to add random coordinates
           int x = (rand.nextInt(1900));
           int y = (rand.nextInt(1060));
            EnemyLocations[i] = new Point(x, y); //add the random coordinates to the list
        }
    }
    private void EnemySpawn() {
        //loop through each of the coordinate placeholders to add the values generated
        for (int i = 0; i < EnemyLocations.length; i++) {
            EnemyX[i] = (float) EnemyLocations[i].getX();
            EnemyY[i] = (float) EnemyLocations[i].getY();
        }
    }

    private void updateEnemyPositions() {
        for (int i = 0; i < EnemyX.length; i++) {
            //calculate the difference between the player and enemy coordinates
            float dx = PlayerX - EnemyX[i];
            float dy = PlayerY - EnemyY[i];
            // use pythogaras to get the distance between them
            float distance = (float) Math.sqrt(dx * dx + dy * dy);

            if (distance > 0) {
                //move the enemy closer to the player
                float newX = EnemyX[i] + dx / distance * 3;
                float newY = EnemyY[i] + dy / distance * 3;

                //check for overlap with other enemies
                boolean overlap = false;
                for (int j = 0; j < EnemyX.length; j++) {
                    if (i != j) {
                        float distanceToOtherEnemy = (float) Math.sqrt(Math.pow(newX - EnemyX[j], 2) + Math.pow(newY - EnemyY[j], 2));
                        if (distanceToOtherEnemy < 150) {
                            overlap = true;
                            break;
                        }
                    }
                }

                if (!overlap) {
                    EnemyX[i] = newX;
                    EnemyY[i] = newY;
                }

                //enemies stay within the map
                if (EnemyX[i] < 0) EnemyX[i] = 0;
                if (EnemyX[i] > getWidth() - 50) EnemyX[i] = getWidth() - 50;
                if (EnemyY[i] < 0) EnemyY[i] = 0;
                if (EnemyY[i] > getHeight() - 50) EnemyY[i] = getHeight() - 50;
            }
        }
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= animations.length) {
                aniIndex = 0;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateAnimationTick();
        updateEnemyPositions();

        g.drawImage(animations[0][aniIndex], (int) PlayerX, (int) PlayerY, null);
        for (int i = 0; i < EnemyX.length; i++) {
            g.drawImage(enemy, (int) EnemyX[i], (int) EnemyY[i], 128,90 ,null);
        }
    }
}