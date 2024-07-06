package Mainmenu;

import javax.swing.*;

public class Levels extends JFrame {


    Levels(){
        this.add(new GamePanel());
        this.setTitle("Level");
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
