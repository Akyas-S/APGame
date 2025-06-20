package entity;

import static utils.Constants.EnemyConstants.*;

// The Pirate class extends the Enemy class
public class Pirate extends Enemy {

    // The pirate's health, initialized to 50
    private int pirateHealth = 50;

    // A flag to indicate whether the pirate is dead
    public boolean pirateDead = false;

    // Constructor for the Pirate class
    public Pirate(float x, float y) {
        // Calls the superclass constructor with the x, y, and PIRATE constants
            super(x, y, PIRATE);
    }

// Getters and setters for the x and y coordinates of the pirate
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

    // Checks if the pirate is dead (i.e., health is 0 or less)
    public boolean isDead() {
        return pirateHealth <= 0;
    }

    // Method to apply damage to the pirate
    public void takeDamage(int damage) {
        // Subtract the damage from the pirate's health
        pirateHealth -= damage;
        // If the pirate's health is 0 or less, set the pirateDead flag to true
        if (pirateHealth <= 0) {
            pirateDead = true;
        }
    }
}