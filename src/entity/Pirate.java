package entity;

import static utils.Constants.EnemyConstants.*;
public class Pirate extends Enemy{

    public Pirate(float x, float y){
        super(x,y,PIRATE);
    }

    // In the Pirate class
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
