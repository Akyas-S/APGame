
package entity;

import data.SaveLoad;
import gamestates.Playing;
import utils.LoadImages;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static utils.Constants.PlayerConstants.*;

public class Player extends Entity {

    // Animation variables
    private BufferedImage[][] animations;
    private EnemyManager enemyManager;
    private Playing playing;
    private int aniTick;
    private int aniIndex;
    private int aniSpeed = 5;
    private int playerAction = IDLE;
    private boolean moving = false;
    boolean attacking = false;

    // Movement variables
    private boolean up, left, down, right, attack;
    private float speed = 4.5f;

    // Save and load variables
    private SaveLoad saveLoad;

    // Player stats
    public boolean dead = false;
    public int playerDamage = 50;
    public int playerScore;
    public int playerHighScore;
    public int playerCurrentCoins;
    public int playerTotalCoins;

    // HUD variables
    private BufferedImage hudBarImg;
    private int hudBarWidth = 385;
    private int hudBarHeight = 73;
    private int hudBarX = 10;
    private int hudBarY = 10;
    private int healthBarWidth = 290;
    private int healthBarHeight = 10;
    private int healthBarXStart = 95;
    private int healthBarYStart = 19;
    private int maxHealth = 100;
    private int currentHealth = maxHealth;
    private int healthWidth = healthBarWidth;

    // Character flip variables
    private int flipX = 0;
    private int flipW = 1;
    private int drawOffsetX = 6;
    private int drawOffsetY = 11;
    private int playergap = 0;

    // Attack variables
    private Rectangle2D.Float attackBox;

    // Constructor
    public Player(float x, float y) {
        super(x, y, 60, 77);
        initHitbox();
        initAttackBox();
        loadAnimations();
        saveLoad = new SaveLoad(this);
        enemyManager = new EnemyManager(playing, this, 5);
    }

    // Initializes the attack box
    private void initAttackBox() {
        attackBox = new Rectangle2D.Float(x, y, 80, 120);
    }

    // Renders the player
    public void render(Graphics g) {
        updateHealthBar();
        updatePos();
        updateAnimationTick();
        setAnimation();
        drawAttackBox(g);
        updateAttackBox();
        updateHitbox();

        drawUI(g);

        if (!dead) {
            // Draws the sprite of the character
            g.drawImage(animations[playerAction][aniIndex],
                    (int) (hitbox.x - drawOffsetX) + flipX + playergap,
                    (int) (hitbox.y - drawOffsetY),
                    160 * flipW,
                    100,
                    null);

            drawHitbox(g);
            g.setFont(new Font("arial", Font.BOLD, 20));
            g.setColor(Color.WHITE);
            g.drawString("Score: " + String.valueOf(playerScore), 100, 65);
        }
        playerDead();
    }

    // Updates the attack box
    private void updateAttackBox() {
        if (right)
            attackBox.x = hitbox.x + hitbox.width + 5;
        else if (left)
            attackBox.x = hitbox.x - hitbox.width - 25;

        attackBox.y = hitbox.y + (-20);
    }

    // Draws the attack box
    private void drawAttackBox(Graphics g) {
        g.setColor(Color.red);
        g.drawRect((int) attackBox.x, (int) attackBox.y, (int) attackBox.width, (int) attackBox.height);
    }

    // Gets the attack box
    public Rectangle2D.Float getAttackBox() {
        return attackBox;
    }

    // Updates the health bar
    private void updateHealthBar() {
        healthWidth = (int) (((float) maxHealth / currentHealth) * healthBarWidth);
    }

    // Draws the UI
    private void drawUI(Graphics g) {
        g.drawImage(hudBarImg, hudBarX, hudBarY, hudBarWidth, hudBarHeight, null);
        g.setColor(Color.RED);
        g.fillRect(healthBarXStart, healthBarYStart, healthWidth, healthBarHeight);
    }

    // Takes damage
    public void takeDamage(int damage) {
        maxHealth -= damage;
        if (maxHealth <= 0) {
            dead = true;
        }
    }

    // Checks high score
    public void checkHighScore(int playerScore) {
        if (playerScore >= playerHighScore) {
            playerHighScore = playerScore;
            saveLoad.saveHighScore();
        }
    }
    // Player dead
    public void playerDead() {
        if (dead) {
            System.out.println("Score: " + String.valueOf(playerScore));
            System.out.println("HighScore : " + String.valueOf(saveLoad.loadHighScore()));
            System.out.println("Coins Gained: " + String.valueOf(playerCurrentCoins));
            System.out.println("Total Coins: " + String.valueOf(saveLoad.loadCoins()));
            checkHighScore(playerScore);
        }
    }

    // Updates the animation tick
    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmt(playerAction)) {
                aniIndex = 0;
                attacking = false;
            }
        }
    }

    // Updates the position
    private void updatePos() {
        moving = false;

        if (!left && !right && !up && !down)
            return;

        float xSpeed = 0, ySpeed = 0;

        if (left && !right) {
            x -= speed;
            flipX = width;
            flipW = -1;
            playergap = 12;
            moving = true;
        }

        else if (right && !left) {
            x += speed;
            flipX = 0;
            flipW = 1;
            playergap = 0;
            moving = true;
        }

        if (up && !down) {
            y -= speed;
            moving = true;
        } else if (down && !up) {
            y += speed;
            moving = true;
        }
    }

    // Sets the animation
    private void setAnimation() {

        int startAni = playerAction;

        if (moving) {
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }

        if (attacking) {
            playerAction = ATTACK;
            //updateAttackHitbox();
            enemyManager.checkAttackHitbox(this);
        }

        if (startAni != playerAction) {
            resetAniTick();
        }
    }

    // Resets the animation tick
    private void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    // Loads the animations
    private void loadAnimations() {

        // Gets the player sprite sheet.
        BufferedImage img = LoadImages.GetSprite(LoadImages.PLAYER_SPRITE);

        // sets the maximum number of frames (X which is 10) and the total number of animations (Y which is 3)
        animations = new BufferedImage[3][10];

        for (int j = 0; j < animations.length; j++) {
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i * 160, j * 100, 160, 100);
            }
        }

        hudBarImg = LoadImages.GetSprite(LoadImages.PLAYER_HUD);
    }

    // Getters and setters
    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}