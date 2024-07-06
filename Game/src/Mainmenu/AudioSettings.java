package Mainmenu;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AudioSettings {
    JFrame AudioWind = new JFrame("Settings");
    JLabel Audicon = new JLabel();
    JSlider VolumeController = new JSlider(0,100,50);

    AudioSettings(){
        Audicon.setBounds(20, 5, 860, 510);
        Audicon.setIcon(new javax.swing.ImageIcon("/Users/hello/IdeaProjects/Game/src/Mainmenu/GUI/Menu/audio.png"));

        VolumeController.setBounds(100, 200, 700, 80);
        VolumeController.setMajorTickSpacing(10);
        VolumeController.setPaintLabels(true);
        VolumeController.setSnapToTicks(true);
        VolumeController.setValue(0);
        VolumeController.setOpaque(true);


        AudioWind.setBounds(0, 0, 900, 550);
        AudioWind.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AudioWind.setSize(900, 550);
        AudioWind.setLocationRelativeTo(null);
        AudioWind.setLayout(null);
        AudioWind.setVisible(true);

        AudioWind.add(Audicon);
        AudioWind.add(VolumeController);

        VolumeController.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                int value = source.getValue();

                float volume = (float) (Math.log(value / 100.0) / Math.log(10.0) * 30.0);
                Main.setVolume(volume);
            }
        });
    }
}
