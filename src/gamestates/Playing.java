

package gamestates;

import entity.EnemyManager;
import entity.Player;
import levels.LevelManager;
import main.GameController;
import utils.LoadImages;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.image.BufferedImage;

public class Playing extends State implements Statemethods {
    // Private variable to store the Player instance
    private Player player;

    // Private variable to store the EnemyManager instance
    private EnemyManager enemyManager;

    // Private variable to store the LevelManager instance
    private LevelManager levelManager;

    // Private variable to store a Random instance
    private Random random = new Random();

    // Private variable to store a BufferedImage for the pause button
    private BufferedImage pausebtn;



    // Constructor for the Playing class that takes in a GameController instance
    public Playing(GameController game) {
        // Calling the superclass constructor
        super(game);
        // Initializing the classes
        initClasses();
    }

    // Private method to initialize the classes
    private void initClasses() {
        // Creating a new Player instance
        player = new Player(200,200);
        // Creating a new EnemyManager instance
        enemyManager = new EnemyManager(this,player,5);
        // Creating a new LevelManager instance
        levelManager = new LevelManager(game,this,player);
    }

    // Private method to set up key bindings (not implemented)
    private void keyBinds(){

    }

    // Public method to get the Player instance
    public Player getPlayer(){
        return player;
    }

    // Override method for rendering the game state
    @Override
    public void render(Graphics g) {
        // Rendering the level
        levelManager.render(g);
        // Rendering the player
        player.render(g);
        // Drawing the pause button
        g.drawImage(pausebtn, 10, 10, null);
    }

    // Override method for handling mouse clicks
    @Override
    public void mouseClicked(MouseEvent e) {
        // If the left mouse button is clicked
        if(e.getButton()== MouseEvent.BUTTON1){
            // Set the player's attacking state to true
            player.setAttacking(true);
        }
        // Get the click point
        Point clickPoint = e.getPoint();
    }

    // Override method for handling mouse presses (not implemented)
    @Override
    public void mousePressed(MouseEvent e) {

    }

    // Override method for handling mouse releases (not implemented)
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    // Override method for handling mouse movements (not implemented)
    @Override
    public void mouseMoved(MouseEvent e) {

    }

    // Override method for handling key presses
    @Override
    public void keyPressed(KeyEvent e) {
        // Get the key code
        int temp = e.getKeyCode();
        // If the W key is pressed
        if (temp == KeyEvent.VK_W){
            // Set the player's up state to true
            player.setUp(true);
        }
        // If the A key is pressed
        if (temp == KeyEvent.VK_A){
            // Set the player's left state to true
            player.setLeft(true);
        }
        // If the D key is pressed
        if (temp == KeyEvent.VK_D){
            // Set the player's right state to true
            player.setRight(true);
        }
        // If the S key is pressed
        if (temp == KeyEvent.VK_S){
            // Set the player's down state to true
            player.setDown(true);
        }
        // If the ESCAPE key is pressed
        if (temp == KeyEvent.VK_ESCAPE){
            // Change the game state to PAUSE
            Gamestate.state = Gamestate.PAUSE;
        }
    }

    // Override method for handling key releases
    @Override
    public void keyReleased(KeyEvent e) {
        // Get the key code
        int temp = e.getKeyCode();
        // If the W key is released
        if (temp == KeyEvent.VK_W){
            // Set the player's up state to false
            player.setUp(false);
        }
        // If the A key is released
        if (temp == KeyEvent.VK_A){
            // Set the player's left state to false
            player.setLeft(false);
        }
        // If the D key is released
        if (temp == KeyEvent.VK_D){
            // Set the player's right state to false
            player.setRight(false);
        }
        // If the S key is released
        if (temp == KeyEvent.VK_S){
            // Set the player's down state to false
            player.setDown(false);
        }
    }
}