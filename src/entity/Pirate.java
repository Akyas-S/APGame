package entity;

import static utils.Constants.EnemyConstants.*;

public class Pirate extends Enemy {

    private int pirateHealth = 50;
    public boolean pirateDead = false;

    public Pirate(float x, float y) {
        super(x, y, PIRATE);
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
    public boolean isDead() {
        return pirateHealth <= 0;
    }

    public void takeDamage(int damage) {
        pirateHealth -= damage;
        if (pirateHealth <= 0) {
            pirateDead = true;

        }
    }
}