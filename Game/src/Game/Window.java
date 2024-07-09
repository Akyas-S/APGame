package Game;

import javax.swing.*;

public class Window {

    JFrame jframe;

    public Window(JPanel jpanel){
        jframe = new JFrame();

        jframe.add(jpanel);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
}