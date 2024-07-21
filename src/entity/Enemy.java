package entity;


import java.awt.*;

import static utils.Constants.EnemyConstants.*;
import static utils.Constants.PlayerConstants.GetSpriteAmt;

public class Enemy extends Entity {

    // Private variables to store the animation index, enemy state, and enemy type
    private int aniIndex, enemyState, enemyType;
    private int aniTick;
    private int aniSpeed = 25;

    // Constructor for the Enemy class that takes in the x and y coordinates and the enemy type
    public Enemy(float x, float y, int enemyType) {
        // Calling the superclass constructor with the x, y coordinates, and a width and height of 60 and 90 respectively
        super(x, y, 60, 90);

        // Initializing the hitbox
        initHitbox();

        // Setting the enemy type
        this.enemyType = enemyType;
    }

    // Private method to update the animation tick
    private void updateAnimationTick() {
        // Incrementing the animation tick
        aniTick++;

        // If the animation tick is greater than or equal to the animation speed
        if (aniTick >= aniSpeed) {
            // Reset the animation tick to 0
            aniTick = 0;
            aniIndex++;

            // If the animation index is greater than or equal to the total number of sprites for the current enemy state
            if (aniIndex >= GetSpriteAmt(enemyState) ) {
                // Reset the animation index to 0
                aniIndex = 0;
            }
        }
    }

    // Public method to update the enemy
    public void update(){
        // Calling the updateAnimationTick method
        updateAnimationTick();
    }

    // Public method to get the current animation index
    public int getAniIndex(){
        return aniIndex;
    }

    // Public method to get the current enemy state
    public int getEnemyState(){
        return enemyState;
    }
}