
package entity;

import data.SaveLoad;
import gamestates.Playing;
import main.GameController;
import utils.LoadImages;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utils.Constants.Directions.*;
import static utils.Constants.Directions.DOWN;
import static utils.Constants.PlayerConstants.*;

public class  Player extends Entity{

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
    float speed =4.5f;

    public boolean dead = false;
    public int playerDamage = 50;
    public int playerScore;
    public int playerCurrentCoins;
    public int playerTotalCoins = 0;
    public int playerHighScore;
    private SaveLoad saveLoad;

    //HUD
    public int playerHealth = 100;

    private BufferedImage hudBarImg;

    private int hudBarWidth = (int) (384);
    private int hudBarHeight = (int) (72);
    private int hudBarX = (int) (10);
    private int hudBarY = (int) (10);

    private int healthBarWidth = (int) (150);
    private int healthBarHeight = (int) (4 );
    private int healthBarXStart = (int) (34);
    private int healthBarYStart = (int) (14);

    private int maxHealth = 10;
    private int currentHealth = maxHealth;
    private int healthWidth = healthBarWidth;


    public Player(float x, float y) {
        super(x, y,120,85);

        loadAnimations();
        enemyManager = new EnemyManager(playing,this,5);
        SaveLoad saveLoad = new SaveLoad(this);
        this.saveLoad = saveLoad;


    }


    public void render(Graphics g){
        updatePos();
        updateAnimationTick();
        setAnimation();

        updateHitbox();

        drawUI(g);

        if(!dead){
            // Draws the sprite of the character
            g.drawImage(animations[playerAction][aniIndex],(int)x,(int)y, null);
            drawHitbox(g);
            g.setFont(new Font("Ink Free", Font.BOLD,50));
            g.drawString("Health: "+ String.valueOf(playerHealth),100,100);
            g.drawString("Score: "+ String.valueOf(playerScore),600,100);
            g.drawString("High Score: "+ String.valueOf(saveLoad.loadHighScore()),900,100);
        }
        playerDead(g);

    }

    private void drawUI(Graphics g) {
       g.drawImage(hudBarImg, hudBarX, hudBarY , hudBarWidth , hudBarHeight, null);
    }

    public void checkHighScore(int playerScore){
        if (playerScore >= playerHighScore){
            playerHighScore = playerScore;
            saveLoad.saveHighScore();
        }

    }

    public void takeDamage(int damage) {
        playerHealth -= damage;
        if (playerHealth == 0){
            dead = true;
        }
    }

    public void playerDead(Graphics g){
        if(dead){
            g.setFont(new Font("Ink Free", Font.BOLD,50));
            g.drawString("Dead",660,540);
            System.out.println(("Score: "+ String.valueOf(playerScore)));
            System.out.println(("Coins Gained: "+ String.valueOf(playerCurrentCoins)));
            System.out.println("Total Coins: "+ String.valueOf(saveLoad.loadCoins()));
            checkHighScore(playerScore);

        }
    }
    protected void updateAttackHitbox(){
        hitbox.width = width + 50;
    }


    // Cycles through the animation frames in the sprite sheet
    private void updateAnimationTick() {
        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick =0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmt(playerAction)){
                aniIndex =0;
                attacking = false;
            }
        }
    }

    private void updatePos() {
        moving = false;

        if (!left && !right && !up && !down)
            return;

        float xSpeed = 0, ySpeed = 0;

        if (left && !right){
            x -= speed;
            moving = true;
        }

        else if (right && !left) {
            x += speed;
            moving = true;
        }

        if (up && !down){
            y -= speed;
            moving = true;
        }
        else if (down && !up){
            y += speed;
            moving = true;
        }
    }

    private void setAnimation() {

        int startAni = playerAction;

        if(moving){
            playerAction = RUNNING;}

        else{
            playerAction = IDLE;}

        if (attacking){
            playerAction = ATTACK;
            updateAttackHitbox();
            enemyManager.checkAttackHitbox(this);
        }

        if (startAni != playerAction){
            resetAniTick();
        }
    }

    private void resetAniTick() {
        aniTick =0;
        aniIndex =0;
    }


    // Selects the animation from the sprite sheet.
    private void loadAnimations() {

        // Gets the player sprite sheet.
        BufferedImage img = LoadImages.GetSprite(LoadImages.PLAYER_SPRITE);

        // sets the maximum number of frames (X which is 10) and the total number of animations (Y which is 3)
        animations = new BufferedImage[3][10];

        for (int j = 0; j < animations.length; j++ ){
            for(int i = 0; i< animations[j].length; i++){
                animations[j][i] = img.getSubimage(i*160,j*100,160,100);
            }
        }

        hudBarImg = LoadImages.GetSprite(LoadImages.PLAYER_HUD);

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

    public void setAttacking(boolean attacking){
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
