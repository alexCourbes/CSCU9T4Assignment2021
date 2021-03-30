package com.stir.cscu9t4assignment2021;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class RefSystemGUI {


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
    public RefSystemGUI() {


        //Holder (panel) for the Buttons: ADD,SEARCH,IMPORT,EXPORT
        topMenu = new JPanel(new FlowLayout(FlowLayout.CENTER));

        //we add the 4 buttons:

        topMenu.add(addCitationMenu);
        addCitationMenu.addActionListener( e->{
            initialMainApp.removeAll();
            int Height = initialMainApp.getHeight();
            int Width = initialMainApp.getWidth();
            addPanel = new AddCitation(Height,Width);

            initialMainApp.add(addPanel);
            initialMainApp.revalidate();

            });


        topMenu.add(searchCitationMenu);
        searchCitationMenu.addActionListener( e->{
            initialMainApp.removeAll();
            searchPanel = new SearchCitation(initialMainApp);
            initialMainApp.add(searchPanel);
            initialMainApp.revalidate();
        });

        topMenu.add(importMenuButton);
        importMenuButton.addActionListener( e->{
            initialMainApp.removeAll();
            importPanel = new ImportCitation(initialMainApp);
            initialMainApp.add(importPanel);
            initialMainApp.revalidate();
        });

        topMenu.add(exportMenuButton);
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

      //Setting Button

        JButton settingButton = new JButton(new ImageIcon("src/main/java/com/stir/cscu9t4assignment2021/static/gearPic.png"));
        settingButton.setPreferredSize(new Dimension(10,45));
        Vboxlayout.add(settingButton);
        JPopupMenu settingPopPup = new JPopupMenu("Settings");



        sideBarMenu.add(Vboxlayout);
        sideBarMenu.setBorder(BorderFactory.createTitledBorder("sidebar"));


    //FRAME
        JFrame frame = new JFrame("Citation App");
        frame.setLayout(new BorderLayout());      // This is the Parent layout

        //add the three sections(panels) to the frame
        frame.add(topMenu, BorderLayout.PAGE_START);
        frame.add(initialMainApp, BorderLayout.CENTER);
        frame.add(sideBarMenu, BorderLayout.LINE_START);



        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//animation when opening app



        }
    }