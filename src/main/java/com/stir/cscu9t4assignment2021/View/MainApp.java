package com.stir.cscu9t4assignment2021.View;

import com.stir.cscu9t4assignment2021.Controller.mainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainApp {


    private JPanel topMenu;
    private JPanel sideBarMenu;

    private JPanel initialMainApp,addPanel,searchPanel,importPanel,exportPanel;



    //declaration of buttons for the menu at the top: topMenu
    private final JButton addCitationMenu = new JButton("ADD");
    private final JButton searchCitationMenu = new JButton("SEARCH");
    private final JButton importMenuButton = new JButton("IMPORT");
    private final JButton exportMenuButton = new JButton("EXPORT");


    //declaration of buttons for side menu: SideBarMenu
    private final JButton menuButton1 = new JButton("wiwi");
    private final JButton menuButton2 = new JButton("wawa");
    private final JButton menuButton3 = new JButton("I am billof");
    private final JButton menuButton4 = new JButton("Hello");


    
    
    //GUI  
    public MainApp() {


        //Holder (panel) for the Buttons: ADD,SEARCH,IMPORT,EXPORT
        topMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,40,0));

        //we add the 4 buttons:

        topMenu.add(addCitationMenu);
        addCitationMenu.setBorder(null);
        addCitationMenu.setContentAreaFilled(false);
        addCitationMenu.addActionListener( e->{
            initialMainApp.removeAll();
            int Height = initialMainApp.getHeight();
            int Width = initialMainApp.getWidth();
            addPanel = new AddCitation(Height,Width);

            initialMainApp.add(addPanel);
            initialMainApp.revalidate();

            });


        topMenu.add(searchCitationMenu);
        searchCitationMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                searchCitationMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                searchCitationMenu.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        searchCitationMenu.setBorder(null);
        searchCitationMenu.setContentAreaFilled(false);
        searchCitationMenu.addActionListener( e->{
            initialMainApp.removeAll();
            searchPanel = new SearchCitation(initialMainApp);
            initialMainApp.add(searchPanel);
            initialMainApp.revalidate();
        });

        topMenu.add(importMenuButton);
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
        importMenuButton.setBorder(null);
        importMenuButton.setContentAreaFilled(false);

        importMenuButton.addActionListener( e->{

            initialMainApp.removeAll();
            importPanel = new ImportCitation(initialMainApp);
            initialMainApp.add(importPanel);
            initialMainApp.revalidate();

        });

        topMenu.add(exportMenuButton);
        exportMenuButton.setBorder(null);
        exportMenuButton.setContentAreaFilled(false);
        exportMenuButton.addActionListener( e->{
            initialMainApp.removeAll();
            exportPanel = new ExportCitation(initialMainApp);
            initialMainApp.add(exportPanel);
            initialMainApp.revalidate();
        });

        topMenu.setBorder(BorderFactory.createTitledBorder("menu")); //black lines around

        //Holder (panel) for main app
        initialMainApp = new JPanel(new CardLayout());
        initialMainApp.setBorder(BorderFactory.createTitledBorder("initial main menu"));



        //Holder (panel) vertical sidebar
        sideBarMenu = new JPanel();
        
        Box Vboxlayout = Box.createVerticalBox(); //vertical box layout for element veritaclly assigned
        Vboxlayout.add(menuButton1);
        Vboxlayout.add(menuButton2);
        Vboxlayout.add(menuButton3);
        Vboxlayout.add(menuButton4);

       //SideBar

      //Setting Button
        JButton settingButton = new JButton("Settings",new ImageIcon("src/main/java/com/stir/cscu9t4assignment2021/static/settingIcon.png"));
        settingButton.setBorder(null);
        settingButton.setContentAreaFilled(false);

        Vboxlayout.add(settingButton);

        //event for hand cursor when hovering over the setting button
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

        settingButton.addActionListener(e-> {

        mainController settingController = new mainController();
        settingController.settingTab();

        });

        sideBarMenu.add(Vboxlayout);
        sideBarMenu.setBorder(BorderFactory.createTitledBorder("sidebar"));


    //FRAME
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