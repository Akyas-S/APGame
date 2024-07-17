package entity;

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
    private int aniTick;
    private int aniIndex;
    private int aniSpeed = 10;
    private int playerAction = IDLE;
    private boolean moving, attacking = false;
    private boolean up, left, down, right, attack;
    float speed =4.5f;
    public int player_health = 100;


    public Player(float x, float y) {
        super(x, y,60,85);
        loadAnimations();
    }


    public void render(Graphics g){
        updateAnimationTick();
        setAnimation();
        updatePos();
        updateHitbox();


        // Draws the sprite of the character
        g.drawImage(animations[playerAction][aniIndex],(int)x,(int)y, null);
        drawHitbox(g);
        playerDead(g);
    }
    public void playerDead(Graphics g){
        if(player_health == 0){
            g.setFont(new Font("Ink Free", Font.BOLD,75));
            g.drawString("Dead",500,500);

        }
    }


    // Cycles through the animation frames in the sprite sheet
    private void updateAnimationTick() {
        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick =0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmt(playerAction)){
                aniIndex =0;
            }
        }
    }

    private void updatePos() {
        moving = false;
        if (up) {
            y -= speed;
            moving =true;
        }
        if (down) {
            y += speed;
            moving =true;
        }
        if (left) {
            x -= speed;
            moving =true;
        }
        if (right) {
            x += speed;
            moving =true;
        }

    }

    private void setAnimation() {
        if(moving){
            playerAction = RUNNING;
        }
        else{
            playerAction = IDLE;
        }
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

    public void setAttack(boolean attack){
        this.attack = attack;
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
