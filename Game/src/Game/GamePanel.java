package Game;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float PlayerX = 0;
    private float PlayerY = 0  ;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 8;

    public GamePanel(){

        importImg();
        loadAnimations();
        mouseInputs = new MouseInputs(this);
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    private void loadAnimations() {
        animations = new BufferedImage[10][10];

        for (int j = 0; j < animations.length; j++ ){
            for(int i = 0; i< animations[j].length; i++){
                animations[j][i] = img.getSubimage(i*128,j*80,128,80);
            }}
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/cat2/catsprite.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                is.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1920, 1080);
        setPreferredSize(size);
    }

    // Takes keyboard inputs and moves player
    public void Move(int X, int Y){
        this.PlayerX += X;
        this.PlayerY += Y;

    }
    private void updateAnimationTick() {
        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick =0;
            aniIndex++;
            if(aniIndex >= animations.length){
                aniIndex =0;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateAnimationTick();

        g.drawImage(animations[0][aniIndex],(int)PlayerX,(int)PlayerY, null);

    }



}