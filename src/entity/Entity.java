package entity;

import java.awt.*;
import java.awt.geom.Rectangle2D;

// Abstract class for the entity class that will be inherited by other classes such as player and enemy
public abstract class Entity {

  // Variables for the position and size of the entity
    protected float x;
    protected float y;
    protected int width;
    protected int height;
    // Variable for the hitbox of the entity
    protected Rectangle2D.Float hitbox;

// Constructor for the entity class that initializes the position and size of the entity
    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

// Code to draw entity hitbox (is commented out in render methods as well)

//    protected void drawHitbox(Graphics g) {
//        g.setColor(Color.pink);
//        g.drawRect((int) hitbox.x, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);
//    }

    // Initializes the hitbox of the entity
    protected void initHitbox() {
        hitbox = new Rectangle2D.Float(x, y, width, height);
    }

    // updates the hitbox to the current position of the entity
    protected void updateHitbox() {
        hitbox.x = (int) x;
        hitbox.y = (int) y;
    }

 // Gets method for hitbox so that it can be accessed by other classes
    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }
}