

package gamestates;

import entity.EnemyManager;
import entity.Player;
import levels.LevelManager;
import main.GameController;
import Audio.AudioPlayer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.image.BufferedImage;

public class Playing extends State implements Statemethods {
    private Player player;
    private EnemyManager enemyManager;
    private LevelManager levelManager;
    private Random random = new Random();
    private BufferedImage pausebtn;
    private AudioPlayer audio;



    public Playing(GameController game) {
        super(game);
        initClasses();
    }



    private void initClasses() {
        player = new Player(200,200);
        enemyManager = new EnemyManager(this,player,5);
        levelManager = new LevelManager(game,this,player);
    }
    private void keyBinds(){

    }
    public void resetAll(){
            player.resetAllPlayer();
    }

    public void resetScore(){
        player.resetScore();
    }
    public void resetLevel(){
        levelManager.resetLevel();
    }
    public void resetDirections() {
        player.resetDirections();
    }

    public Player getPlayer(){
        return player;
    }


    @Override
    public void render(Graphics g) {
        levelManager.render(g);
        player.render(g);
        g.drawImage(pausebtn, 10, 10, null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()== MouseEvent.BUTTON1){
            player.setAttacking(true);
            game.getAudioPlayer().playAttackSFX();
        }        Point clickPoint = e.getPoint();
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
        if (temp == Controls.moveup){
            player.setUp(true);}
        if (temp == Controls.moveleft){
            player.setLeft(true);}
        if (temp == Controls.moveright){
            player.setRight(true);}
        if (temp == Controls.movedown){
            player.setDown(true);}
        if (temp == KeyEvent.VK_ESCAPE){
            Gamestate.state = Gamestate.PAUSE;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int temp = e.getKeyCode();
        if (temp == Controls.moveup){
            player.setUp(false);}
        if (temp == Controls.moveleft){
            player.setLeft(false);}
        if (temp == Controls.moveright){
            player.setRight(false);}
        if (temp == Controls.movedown){
            player.setDown(false);}
    }

    // TESTING
   // public LevelManager getLevelManager(){return levelManager;}


}
