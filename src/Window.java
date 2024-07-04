import javax.swing.*;

public class Window {

    JFrame jframe;

    public Window(JPanel jpanel){
        jframe = new JFrame();
        jframe.setSize(1280,720);
        jframe.add(jpanel);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
}
