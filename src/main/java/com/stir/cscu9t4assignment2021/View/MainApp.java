package com.stir.cscu9t4assignment2021.View;

import com.stir.cscu9t4assignment2021.Controller.exportController;
import com.stir.cscu9t4assignment2021.Controller.importController;
import com.stir.cscu9t4assignment2021.Controller.mainController;
import com.stir.cscu9t4assignment2021.Model.Citation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class MainApp {


    private JPanel topMenu;
    private JPanel sideBarMenu;

    private JPanel initialMainApp, addPanel, searchPanel, exportPanel;


    //declaration of buttons for the menu at the top: topMenu
    private final JButton addCitationButton = new JButton("ADD");
    private final JButton searchCitationButton = new JButton("SEARCH");
    private final JButton importMenuButton = new JButton("IMPORT");
    private final JButton exportMenuButton = new JButton("EXPORT");


    //declaration of buttons for side menu: SideBarMenu
    private final JButton settingButton;
    final JButton aboutButton;

    //Export dialog
    JOptionPane exportDialog = new JOptionPane();


    //GUI
    public MainApp() {



        /*** Top holder (panel) for the Buttons: ADD,SEARCH,IMPORT,EXPORT ***/
        topMenu = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));

        //Add citation:
        topMenu.add(addCitationButton);
        //styling
        addCitationButton.setBorder(null);
        addCitationButton.setContentAreaFilled(false);


        addCitationButton.addActionListener(e -> { //action listener that call the AddCitation class

            initialMainApp.removeAll();   //removing/closing any existing/previous panel on initialMainApp Panel


            try {
                addPanel = new AddCitation(); //declaring Addcitation class
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }


            initialMainApp.add(addPanel); //adding it to the  main pannel
            initialMainApp.revalidate(); //refreshing the panel

        });

        addCitationButton.addMouseListener(new MouseAdapter() { // mouse listener for cursor pointer (visual purpose)
            @Override
            public void mouseEntered(MouseEvent e) {
                addCitationButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addCitationButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        //Search Citation:
        topMenu.add(searchCitationButton);


        searchCitationButton.setBorder(null);
        searchCitationButton.setContentAreaFilled(false);

        searchCitationButton.addActionListener(e -> {
            initialMainApp.removeAll();
            int width = initialMainApp.getWidth(); // we will pass the width of the pannel for use in the SearchCitation Class
            searchPanel = new SearchCitation(width);
            initialMainApp.add(searchPanel);//calling SearchCitation Class to the main panel
            initialMainApp.revalidate();
        });
        searchCitationButton.addMouseListener(new MouseAdapter() { // mouse listener for cursor pointer (visual purpose)
            @Override
            public void mouseEntered(MouseEvent e) {
                searchCitationButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                searchCitationButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        // Import Menu:
        topMenu.add(importMenuButton);

        importMenuButton.setBorder(null);
        importMenuButton.setContentAreaFilled(false);

        importMenuButton.addActionListener(e -> {
           importController newimport = new importController();
           newimport.ImportFileCSV();
           initialMainApp.revalidate();


        });

        importMenuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                importMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                importMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        // Export menu:
        topMenu.add(exportMenuButton);

        exportMenuButton.setBorder(null);
        exportMenuButton.setContentAreaFilled(false);

        exportMenuButton.addActionListener(e -> {
            initialMainApp.removeAll();

            Object[] options1 = { "Text"};
            int result = JOptionPane.showOptionDialog(null, "Export to", "Export",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options1, null);
            if (result == JOptionPane.YES_OPTION){
            exportController newExport = new exportController();
                try {
                    newExport.exportToTXT();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }else{
                System.out.println("Incorect location!!");
            }

            initialMainApp.revalidate();
        });

        exportMenuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exportMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exportMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        topMenu.setBorder(BorderFactory.createTitledBorder("menu")); //black lines around



        /*** Central holder (panel) for execution of the main app ***/

        initialMainApp = new JPanel(new CardLayout()); // card layout allows us to easily switch between panels
        initialMainApp.setBorder(BorderFactory.createTitledBorder("initial main menu"));


        /*** Sidebar Holder (panel) ***/

        sideBarMenu = new JPanel();
        Box sideboxlayout = Box.createVerticalBox(); //vertical box layout for element veritaclly assigned


        //Setting & info Buttons

        //Setting button
        settingButton = new JButton("Settings", new ImageIcon("src/main/java/com/stir/cscu9t4assignment2021/static/settingIcon.png"));

        settingButton.setBorder(null);
        settingButton.setContentAreaFilled(false);

        sideboxlayout.add(settingButton);

        settingButton.addActionListener(e -> {
            mainController settingController = new mainController(); // initialising the main Controller Class
            settingController.settingTab();  // Calling the SettingTab Controller
        });

        settingButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                settingButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                settingButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        //About button
        sideboxlayout.add(Box.createVerticalStrut(10)); // verical white space for separation
        aboutButton = new JButton("About", new ImageIcon("src/main/java/com/stir/cscu9t4assignment2021/static/About32.png"));

        aboutButton.setBorder(null);
        aboutButton.setContentAreaFilled(false);

        aboutButton.addActionListener(e -> {
            mainController aboutTab = new mainController(); // initialising the main controller Class
            aboutTab.aboutTab(); // Calling the aboutTab controller
        });

        aboutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                aboutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                aboutButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
        sideboxlayout.add(aboutButton);



        //adding the vbox holding the buttons and sidebar lines
        sideBarMenu.add(sideboxlayout);
        sideBarMenu.setBorder(BorderFactory.createTitledBorder("Sidebar"));



        /*** FRAME ***/

        JFrame frame = new JFrame("Citation App");
        frame.setLayout(new BorderLayout());      // This is the Parent layout

        //Add the three sections(panels) to the frame
        frame.add(topMenu, BorderLayout.PAGE_START);
        frame.add(initialMainApp, BorderLayout.CENTER);
        frame.add(sideBarMenu, BorderLayout.LINE_START);


        //default
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //animation when opening app


    }
}