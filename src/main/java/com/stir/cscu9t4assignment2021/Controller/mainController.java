package com.stir.cscu9t4assignment2021.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*** MAIN CONTROLLER CLASS:
 *  this class cointains the methods for much of the main functionality of the application
 */

public class mainController {

    public void settingTab() {
        JFrame settingFrame = new JFrame("settings");
        settingFrame.setLayout(new BorderLayout());
        JButton Exit = new JButton("Exit");
        settingFrame.add(Exit);
        settingFrame.setVisible(true);
        settingFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        settingFrame.setSize(200, 200);
    }







    public void aboutTab(){
        JFrame aboutFrame = new JFrame("About");
        JPanel aboutPanel = new JPanel( );



        JLabel appName = new JLabel("name:");
        JLabel appVersion = new JLabel("version:");
        JLabel appDevelopper = new JLabel("developper:");
        JLabel appDate = new JLabel("latest update: ");
        JLabel studentCode = new JLabel("student Code: ");


        //container.setLayout(new BoxLayout(aboutFrame,BoxLayout.Y_AXIS));
        aboutFrame.add(aboutPanel);
        aboutPanel.add(appName);
        aboutPanel.add(appVersion);
        aboutPanel.add(appDevelopper);
        aboutPanel.add(appDate);
        aboutPanel.add(studentCode);

        appName.setAlignmentX(Component.RIGHT_ALIGNMENT);
        appVersion.setAlignmentX(Component.RIGHT_ALIGNMENT);
        appDevelopper.setAlignmentX(Component.RIGHT_ALIGNMENT);

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