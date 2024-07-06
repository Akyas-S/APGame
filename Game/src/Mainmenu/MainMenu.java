package Mainmenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MainMenu implements ActionListener {
    JFrame MMWind = new JFrame("Main Menu");
    JLabel MMicon = new JLabel();
    JButton StartButton = new JButton();
    JButton StoreButton = new JButton();
    JButton SettingsButton = new JButton();
    JButton ExitButton = new JButton();


    MainMenu() {

        MMicon.setBounds(12, 13, 450, 751);
        MMicon.setIcon(new javax.swing.ImageIcon("/Users/hello/IdeaProjects/Game/src/Mainmenu/GUI/Menu/mmenu.png"));


        StartButton.setBounds(80, 190, 317, 88);
        StartButton.setOpaque(false);
        StartButton.setBorderPainted(false);
        StartButton.addActionListener(this);

        StoreButton.setBounds(80, 330, 317, 88);
        StoreButton.setOpaque(false);
        StoreButton.setBorderPainted(false);
        StoreButton.addActionListener(this);

        SettingsButton.setBounds(80, 436, 317, 88);
        SettingsButton.setOpaque(false);
        SettingsButton.setBorderPainted(false);
        SettingsButton.addActionListener(this);

        ExitButton.setBounds(80, 566, 317, 88);
        ExitButton.setOpaque(false);
        ExitButton.setBorderPainted(false);
        ExitButton.addActionListener(this);

        MMWind.setBounds(0, 0, 480, 800);
        MMWind.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MMWind.setSize(480, 800);
        MMWind.setLocationRelativeTo(null);
        MMWind.setLayout(null);
        MMWind.setVisible(true);

        MMWind.add(MMicon);
        MMWind.add(StartButton);
        MMWind.add(StoreButton);
        MMWind.add(SettingsButton);
        MMWind.add(ExitButton);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == StartButton) {
            MMWind.setVisible(false);
            Levels levelWind = new Levels();
        } else if (e.getSource() == StoreButton) {
            MMWind.setVisible(false);
            Store StoreWind = new Store();
        } else if (e.getSource() == SettingsButton) {
            MMWind.setVisible(false);
            Settings settingsWind = new Settings(); // Pass the AudioManager instance
        } else if (e.getSource() == ExitButton) {
            System.exit(0);
        }
    }
}