package gamestates;

import entity.Player;
import main.GameController;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class Playing extends State implements Statemethods {
    private Player player;

    public Playing(GameController game) {
        super(game);
        initClasses();
    }

    private void initClasses() {

        player = new Player(200,200);
    }

    public Player getPlayer(){
        return player;
    }

    @Override
    public void render(Graphics g) {
        player.render(g);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int temp = e.getButton();
        if (temp == MouseEvent.BUTTON1) {
            player.setUp(false);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int temp = e.getKeyCode();
        if (temp == KeyEvent.VK_W || temp == KeyEvent.VK_UP){
            player.setUp(true);}
        if (temp == KeyEvent.VK_A || temp == KeyEvent.VK_LEFT){
            player.setLeft(true);}
        if (temp == KeyEvent.VK_D || temp == KeyEvent.VK_RIGHT){
            player.setRight(true);}
        if (temp == KeyEvent.VK_S || temp == KeyEvent.VK_DOWN){
            player.setDown(true);}

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int temp = e.getKeyCode();
        if (temp == KeyEvent.VK_W || temp == KeyEvent.VK_UP){
            player.setUp(false);}
        if (temp == KeyEvent.VK_A || temp == KeyEvent.VK_LEFT){
            player.setLeft(false);}
        if (temp == KeyEvent.VK_D || temp == KeyEvent.VK_RIGHT){
            player.setRight(false);}
        if (temp == KeyEvent.VK_S || temp == KeyEvent.VK_DOWN){
            player.setDown(false);}
    }
}
