package main;



import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

// This class is responsible for creating the window for the game
public class Window extends JFrame{

    // Constructor for the window
    public Window(GamePanel gamePanel){

        setTitle("Paws of the Caribbean");
        add(gamePanel);
        setResizable(false);
        //pack() method sizes the frame based on the value set using setPanelSize()
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Add a window focus listener to the window to handle when the window loses focus and the game should pause
        // stops the player from moving in one direction when the window is not in focus
        addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowLostFocus(WindowEvent e) {
                gamePanel.getGame().windowFocusLost();
            }

            @Override
            public void windowGainedFocus(WindowEvent e) {
            }

        });

    }
}
