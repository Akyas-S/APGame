package Inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static utils.Constants.Directions.*;


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
        int temp = e.getKeyCode();
        if (temp == KeyEvent.VK_W){
            gamePanel.getGame().getPlayer().setUp(true);}
        if (temp == KeyEvent.VK_A){
            gamePanel.getGame().getPlayer().setLeft(true);}
        if (temp == KeyEvent.VK_D){
            gamePanel.getGame().getPlayer().setRight(true);}
        if (temp == KeyEvent.VK_S){
            gamePanel.getGame().getPlayer().setDown(true);}

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int temp = e.getKeyCode();
        if (temp == KeyEvent.VK_W){
            gamePanel.getGame().getPlayer().setUp(false);}
        if (temp == KeyEvent.VK_A){
            gamePanel.getGame().getPlayer().setLeft(false);}
        if (temp == KeyEvent.VK_D){
            gamePanel.getGame().getPlayer().setRight(false);}
        if (temp == KeyEvent.VK_S){
            gamePanel.getGame().getPlayer().setDown(false);}


    }
}
