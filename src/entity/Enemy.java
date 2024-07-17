package entity;


import java.awt.*;

import static utils.Constants.EnemyConstants.*;
import static utils.Constants.PlayerConstants.GetSpriteAmt;

public class Enemy extends Entity {
    private int aniIndex, enemyState, enemyType;
    private int aniTick;
    private int aniSpeed = 25;

    public Enemy(float x, float y, int enemyType) {
        super(x, y,60,90);
        this.enemyType = enemyType;


    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmt(enemyState) ) {
                aniIndex = 0;
            }
        }
    }
    public void update(){
        updateAnimationTick();
    }
    public int getAniIndex(){
        return aniIndex;
    }
    public int getEnemyState(){
        return enemyState;
    }

}
