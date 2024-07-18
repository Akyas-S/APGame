

package entity;

import gamestates.Playing;
import utils.LoadImages;
import entity.Pirate;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Manages the enemies (pirates) in the game.
 */
public class EnemyManager{

    // Reference to the Playing game state
    private Playing playing;
    private int numEnemies;
    private int EnemyAttack = 1;
    // Array of pirate images
    private BufferedImage[][] pirateArray;

    // List of pirate objects
    private ArrayList<Pirate> pirates = new ArrayList<>();

    // List of initial positions for pirates
    private ArrayList<Point> positions = new ArrayList<>();

    // Random number generator
    private Random rand = new Random();

    // Reference to the player object
    private Player player;

    // timestamp of the last spawn
    private long lastSpawnTime = 0;

    // 2 seconds in milliseconds
    private final long spawnInterval = 2000;

    /**
     * Constructor for EnemyManager.
     * playing Reference to the Playing game state
     * player Reference to the player object
     */
    public EnemyManager(Playing playing, Player player,int numEnemies){
        this.playing = playing;
        this.player = player;
        this.numEnemies = numEnemies;
        loadEnemyImgs(); // Load pirate images
        movePirates(); // Initialize pirate positions
        for (Point p : generatePositions()) {
            addPirate((int) p.getX(), (int) p.getY()); // Add pirates to the game
        }
        lastSpawnTime = System.currentTimeMillis();
    }

    /**
     * Update method for the enemy manager.
     * Updates the positions of all pirates.
     */
    public void update(){
        for (Pirate p : pirates) {
            p.update();// Update each pirate's state
        }
        movePirates(); // Update pirate positions

        // Check if it's time to spawn a new pirate
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastSpawnTime >= spawnInterval && pirates.size() < numEnemies ) {
            lastSpawnTime = currentTime;
            for (int i = 0; i < numEnemies; i++) {
                int x = rand.nextInt(800);
                int y = rand.nextInt(700);
                addPirate(x, y); // Add a new pirate at a random position with random direction
            }
        }
    }
    /**
     * Draw method for the enemy manager.
     * Draws all pirates on the screen.
     * g Graphics object for drawing
     */
    public void draw(Graphics g){
        drawPirates(g);// Draw all pirates
    }

    /**
     * Add a new pirate to the game.
     * x Initial x-coordinate of the pirate
     * y Initial y-coordinate of the pirate
     */
    public void addPirate(int x, int y) {
        pirates.add(new Pirate(x, y)); // Create a new pirate object
    }

    /**
     * Generate a list of random positions for pirates.
     * List of Point objects representing pirate positions
     */
    private ArrayList<Point> generatePositions(){

        for (int i = 0; i < numEnemies; i++) { // Loop to generate 5 random coordinates
            int x = rand.nextInt(1000);
            int y = rand.nextInt(800);
            positions.add(new Point(x, y)); // Add the random coordinates to the list
        }
        return positions;
    }

    /**
     * Draw all pirates on the screen.
     * g Graphics object for drawing
     */
    private void drawPirates(Graphics g) {
        Iterator<Pirate> iterator = pirates.iterator();
        while (iterator.hasNext()) {
            Pirate p = iterator.next();
            p.update();
            g.drawImage(pirateArray[p.getEnemyState()][p.getAniIndex()], (int) p.getX(), (int) p.getY(), 160, 100, null);
            p.drawHitbox(g);
            p.updateHitbox();
            if(player.attacking){
                checkAttackHitbox(player);
                if (p.isDead()) {
                    iterator.remove(); // Remove the pirate from the list when it's dead
                    System.out.println("Pirate removed from the map!");
                    player.playerScore++;
                }
            }

        }
    }

    /**
     * Move all pirates towards the player.
     */
    private void movePirates() {
        for (Pirate p : pirates) {
            if (!player.dead) {
                // Calculate the direction vector from the pirate to the player
                float dx = player.getX() - p.getX();
                float dy = player.getY() - p.getY();

                // Normalize the direction vector
                float length = (float) Math.sqrt(dx * dx + dy * dy);
                if (length > 0) {
                    dx /= length;
                    dy /= length;
                }

                // Check for collisions with other pirates and the player
                float newX = p.getX() + dx * 4f;
                float newY = p.getY() + dy * 4f;
                if (!checkCollision(newX, newY, p)) {
                    p.setX(newX);
                    p.setY(newY);
                }
            }
        }
    }

    /**
     * Check for collisions between a pirate and other pirates.
     * x New x-coordinate of the pirate
     * y New y-coordinate of the pirate
     * pirate Pirate object to check for collisions
     *True if a collision is detected, false otherwise
     */
    private boolean checkCollision(float x, float y, Pirate pirate) {
        // Check collision with other pirates
        for (Pirate otherPirate : pirates) {
            if (otherPirate != pirate && distance(x, y, otherPirate.getHitbox().x, otherPirate.getHitbox().y) < 35 ) {
                return true;
            }
        }

        // Check collision with the player
        if (!player.dead && distance(x, y, player.getX(), player.getY()) < 35) {
            player.takeDamage(EnemyAttack);
            return true;
        }
        return false;
    }

    public void checkAttackHitbox(Player player) {
        for (Pirate p : pirates) {
            if (p.getHitbox().intersects(player.getHitbox())) {
                p.takeDamage(player.playerDamage);

            }
        }
    }
    /**
     * Calculate the distance between two points using Pythogaras.
     * x1 x-coordinate of the first point
     * y1 y-coordinate of the first point
     * x2 x-coordinate of the second point
     * y2 y-coordinate of the second point
     * Find distance between the two points
     */
    private float distance(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    /**
     * Load pirate images from a sprite sheet.
     */
    private void loadEnemyImgs(){
        pirateArray = new BufferedImage[1][10];
        BufferedImage img = LoadImages.GetSprite(LoadImages.PIRATE_GHOST); // Assuming PIRATE_SPRITE is correct

        if (img == null) {
            System.err.println("Error: Could not load pirate sprite image.");
            return;
        }

        for (int j = 0; j < pirateArray.length; j++) {
            for (int i = 0; i < pirateArray[j].length; i++) {
                pirateArray[j][i] = img.getSubimage(i*160 , 0, 160, 100);
            }
        }
    }
}
