package com.stir.cscu9t4assignment2021.Controller;
/**
 *
 * @author 2822236
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*** MAIN CONTROLLER CLASS:
 *  this class cointains the controller of the MainApp
 */

public class mainController {

    public void settingTab() {
        JFrame settingFrame = new JFrame("settings");
        JLabel settings = new JLabel("these are the setting, there not really usefull");
        settingFrame.add(settings);
        settingFrame.setVisible(true);
        settingFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        settingFrame.setSize(200, 200);
    }




    public void aboutTab(){
        JFrame aboutFrame = new JFrame("About");
        JPanel aboutPanel = new JPanel( );


        JLabel appVersion = new JLabel("version: 6.0");
        JLabel appDevelopper = new JLabel("developper: 2822236");
        JLabel appDate = new JLabel("latest update:13/03/2021 ");
        JLabel studentCode = new JLabel("student Code: 2822236");


        //container.setLayout(new BoxLayout(aboutFrame,BoxLayout.Y_AXIS));
        aboutFrame.add(aboutPanel);

        aboutPanel.add(appVersion);
        aboutPanel.add(appDevelopper);
        aboutPanel.add(appDate);
        aboutPanel.add(studentCode);




        //container.add(SlothImage,BoxLayout.PAGE_AXIS);
        JLabel slothImage =new JLabel(new ImageIcon("src/main/java/com/stir/cscu9t4assignment2021/static/sloth-48.png"));
        slothImage.setAlignmentX(Component.BOTTOM_ALIGNMENT);
        aboutPanel.add(slothImage);


        aboutPanel.setLayout(new BoxLayout(aboutPanel,BoxLayout.Y_AXIS));

        aboutFrame.setPreferredSize(new Dimension(250,250));
        aboutFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        aboutFrame.setResizable(false);
        aboutFrame.setLocationRelativeTo(null);
        aboutFrame.pack();
        aboutFrame.setVisible(true);

    }


}