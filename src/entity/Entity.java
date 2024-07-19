package entity;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Abstract base class for game entities, such as characters, enemies, or objects.
 */
public abstract class Entity {

    /**
     * Entity's x-coordinate
     */
    protected float x;

    /**
     * Entity's y-coordinate
     */
    protected float y;

    /**
     * Entity's width
     */
    protected int width;

    /**
     * Entity's height
     */
    protected int height;

    /**
     * Entity's hitbox (a rectangular area used for collision detection)
     */
    protected Rectangle2D.Float hitbox;

    /**
     * Constructor to initialize the entity's position and size
     * @param x entity's x-coordinate
     * @param y entity's y-coordinate
     * @param width entity's width
     * @param height entity's height
     */
    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Draw the entity's hitbox on the screen
     * @param g Graphics object to draw with
     */
    protected void drawHitbox(Graphics g) {
        g.setColor(Color.pink);
        g.drawRect((int) hitbox.x, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);
    }

    /**
     * Initialize the entity's hitbox
     */
    protected void initHitbox() {
        hitbox = new Rectangle2D.Float(x, y, width, height);
    }

    /**
     * Update the entity's hitbox position
     */
    protected void updateHitbox() {
        hitbox.x = (int) x;
        hitbox.y = (int) y;
    }

    /**
     * Get the entity's hitbox
     * @return the hitbox
     */
    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }
}