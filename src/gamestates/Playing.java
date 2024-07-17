

package gamestates;

import entity.EnemyManager;
import entity.Player;
import levels.LevelManager;
import main.GameController;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Playing extends State implements Statemethods {
    private Player player;
    private EnemyManager enemyManager;
    private LevelManager levelManager;
    private Random random = new Random();

    public Playing(GameController game) {
        super(game);
        initClasses();

    }

    private void initClasses() {

        player = new Player(200,200);
        enemyManager = new EnemyManager(this,player,5);
        levelManager = new LevelManager(game,this,player);
    }

    public Player getPlayer(){
        return player;
    }
    @Override
    public void render(Graphics g) {
        levelManager.renderBackground(g);
        player.render(g);
        levelManager.drawLevels(g);

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
