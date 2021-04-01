package com.stir.cscu9t4assignment2021.Controller;

import javax.swing.*;
import java.awt.*;

public class mainController {

    public void settingTab(){
        JFrame settingFrame = new JFrame("settings");
        settingFrame.setLayout(new BorderLayout());
        JButton Exit = new JButton("Exit");
        settingFrame.add(Exit);
        settingFrame.setVisible(true);
        settingFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        settingFrame.setSize(200,200);
    }



}
