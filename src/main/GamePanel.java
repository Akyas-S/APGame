package main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;
    private GameController game;

    //Constructor for the GamePanel
    public GamePanel(GameController game){
        //Initializes the mouse and keyboard inputs
        mouseInputs = new MouseInputs(this);
        keyboardInputs = new KeyboardInputs(this);
        addKeyListener(new KeyboardInputs(this));

        this.game = game;
        setPanelSize(); // Sets the size of the panel (this is used by the pack(); method in the Window class)
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    // Method to set the size of the panel
    private void setPanelSize() {
        Dimension size = new Dimension(1280, 720);
        setPreferredSize(size);
    }


    public void paintComponent(Graphics g) {
        // Clears the panel before redrawing
        super.paintComponent(g);
        // Draws the game from the GameController
        game.render(g);
    }

    // Getter method for this instance of the game/ameController
    public GameController getGame(){
        return game;
    }


}