package Inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class  KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel=gamePanel;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                gamePanel.Move(0,-5);
                break;
            case KeyEvent.VK_A:
                gamePanel.Move(-5,0);
                break;
            case KeyEvent.VK_S:
                gamePanel.Move(0,5);
                break;
            case KeyEvent.VK_D:
                gamePanel.Move(5,0);
                break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
