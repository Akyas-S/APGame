package Mainmenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings implements ActionListener {
    JFrame SettWind = new JFrame("Settings");
    JLabel Setticon = new JLabel();
    JButton Closebtn = new JButton();
    JButton Audiobtn = new JButton();
    JButton Videobtn = new JButton();
    JButton Controlbtn = new JButton();

    Settings(){
        Setticon.setBounds(20, 5, 860, 510);
        Setticon.setIcon(new javax.swing.ImageIcon("/Users/hello/IdeaProjects/Game/src/Mainmenu/GUI/Menu/settings.png"));

        Closebtn.setBounds(50, 35, 80, 80);
        Closebtn.setOpaque(false);
        Closebtn.setBorderPainted(false);
        Closebtn.addActionListener(this);


        Audiobtn.setBounds(250, 170, 400, 70);
        Audiobtn.setOpaque(false);
        Audiobtn.setBorderPainted(false);
        Audiobtn.addActionListener(this);

        Videobtn.setBounds(250, 250, 400, 70);
        Videobtn.setOpaque(false);
        Videobtn.setBorderPainted(false);

        Controlbtn.setBounds(250, 330, 400, 70);
        Controlbtn.setOpaque(false);
        Controlbtn.setBorderPainted(false);

        SettWind.setBounds(0, 0, 900, 550);
        SettWind.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SettWind.setSize(900, 550);
        SettWind.setLocationRelativeTo(null);
        SettWind.setLayout(null);
        SettWind.setVisible(true);

        SettWind.add(Setticon);
        SettWind.add(Closebtn);
        SettWind.add(Audiobtn);
        SettWind.add(Videobtn);
        SettWind.add(Controlbtn);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Closebtn) {
            SettWind.setVisible(false);
            MainMenu MainMenu = new MainMenu();}
        else if (e.getSource() == Audiobtn) {
            SettWind.setVisible(false);
            AudioSettings Audiowind = new AudioSettings();}

    }
}
