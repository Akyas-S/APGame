
package entity;

import data.SaveLoad;
import gamestates.Gamestate;
import gamestates.Playing;
import main.GameController;
import utils.LoadImages;
import gamestates.Store;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static utils.Constants.PlayerConstants.*;

public class  Player extends Entity {

    private Store store;
    private BufferedImage[][] animations;
    private EnemyManager enemyManager;
    private Playing playing;
    private int aniTick;
    private int aniIndex;
    private int aniSpeed = 5;
    private int playerAction = IDLE;
    private boolean moving = false;
    boolean attacking = false;
    private boolean up, left, down, right, attack;
    float speed = 4.5f;

    // Save and load variables
    private SaveLoad saveLoad;

    // Player stats
    public boolean dead = false;
    public int playerDamage = 50;
    public int playerScore;
    public int playerHighScore;
    public int playerCurrentCoins;
    public int playerTotalCoins;


    //HUD
    private BufferedImage hudBarImg;

    private int hudBarWidth = (int) (385);
    private int hudBarHeight = (int) (73);
    private int hudBarX = (int) (10);
    private int hudBarY = (int) (10);

    private int healthBarWidth = (int) (290);
    private int healthBarHeight = (int) (10);
    private int healthBarXStart = (int) (95);
    private int healthBarYStart = (int) (19);

    private int maxHealth = 100;
    private int currentHealth = maxHealth;
    private int healthWidth = healthBarWidth;

    //character flip
    private int flipX = 0;
    private int flipW = 1;
    private int drawOffsetX = 6;
    private int drawOffsetY = 11;
    private int playergap = 0;

    //attack
    private Rectangle2D.Float attackBox;

    public Player(float x, float y) {
        super(x, y, 60, 77);
        initHitbox();
        initAttackBox();
        loadAnimations();
        enemyManager = new EnemyManager(playing, this, 5);
        this.store = store;
        // Create SaveLoad object to handle saving and loading game data
        SaveLoad saveLoad = new SaveLoad(this);
        this.saveLoad = saveLoad;

    }

    private void initAttackBox() {
        attackBox = new Rectangle2D.Float(x, y, 80, 120);
    }


    // Renders the player
    public void render(Graphics g) {
        updateHealthBar();
        updatePos();
        updateAnimationTick();
        setAnimation();
//        drawAttackBox(g);
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

//            drawHitbox(g);
            g.setFont(new Font("arial", Font.BOLD, 20));
            g.setColor(Color.WHITE);
            g.drawString("Score: " + String.valueOf(playerScore), 100, 65);
        } else {
            Gamestate.state = Gamestate.DEATH;
        }
    }

    private void updateAttackBox() {
        if (right)
            attackBox.x = hitbox.x + hitbox.width + 5;
        else if (left)
            attackBox.x = hitbox.x - hitbox.width - 25;

        attackBox.y = hitbox.y + (-20);
    }

    private void drawAttackBox(Graphics g) {
        g.setColor(Color.red);
        g.drawRect((int) attackBox.x, (int) attackBox.y, (int) attackBox.width, (int) attackBox.height);

    }

    public Rectangle2D.Float getAttackBox() {
        return attackBox;
    }

    private void updateHealthBar() {
        healthWidth = (int) (((float) currentHealth / maxHealth) * healthBarWidth);
    }

    private void drawUI(Graphics g) {
        g.drawImage(hudBarImg, hudBarX, hudBarY, hudBarWidth, hudBarHeight, null);
        g.setColor(Color.RED);
        g.fillRect(healthBarXStart, healthBarYStart, healthWidth, healthBarHeight);
    }

    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth <= 0) {
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


    // Cycles through the animation frames in the sprite sheet
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

    private void updatePos() {
        moving = false;

        if (!left && !right && !up && !down)
            return;

        //x axis
        if(x>0){
        if (left && !right) {
            x -= speed;
            flipX = width;
            flipW = -1;
            playergap = 12;
            moving = true;
        }}
        if(x<1280 - hitbox.width){
        if (right && !left) {
            x += speed;
            flipX = 0;
            flipW = 1;
            playergap = 0;
            moving = true;
        }}

        //y axis
        if(y>0){
            if (up && !down) {
                y -= speed;
                moving = true;
        }}
        if(y<720 - hitbox.height){
            if (down && !up) {
                y += speed;
                moving = true;
        }}
    }

    private void setAnimation() {

        int startAni = playerAction;

        if (moving) {
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }

        if (attacking) {
            playerAction = ATTACK;
//            updateAttackHitbox();
            enemyManager.checkAttackHitbox(this);
        }

        if (startAni != playerAction) {
            resetAniTick();
        }
    }

    private void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }


    // Selects the animation from the sprite sheet.
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

    public void resetAllPlayer() {
        resetDirections();

        this.attacking = false;
        this.moving = false;
        this.playerAction = IDLE;
        this.currentHealth = 100;
        this.x = 200;
        this.y = 200;
        this.dead = false;
        System.out.println("reset all");
    }
    public void resetScore(){
        this.playerScore = 0;
    }

    public void resetDirections() {
        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;
    }


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
