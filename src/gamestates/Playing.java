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

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int temp = e.getKeyCode();
        if (temp == KeyEvent.VK_W){
            player.setUp(true);}
        if (temp == KeyEvent.VK_A){
            player.setLeft(true);}
        if (temp == KeyEvent.VK_D){
            player.setRight(true);}
        if (temp == KeyEvent.VK_S){
            player.setDown(true);}

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int temp = e.getKeyCode();
        if (temp == KeyEvent.VK_W){
            player.setUp(false);}
        if (temp == KeyEvent.VK_A){
            player.setLeft(false);}
        if (temp == KeyEvent.VK_D){
            player.setRight(false);}
        if (temp == KeyEvent.VK_S){
            player.setDown(false);}
    }
}
