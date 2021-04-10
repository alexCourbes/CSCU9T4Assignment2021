package com.stir.cscu9t4assignment2021.View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Date;

public class SearchCitation extends JPanel{

    private String Title;
    private String TypeOfPublication;
    private String [] Authors;
    private int YearOfPublication;
    private String NameOfpublisher;
    private String DigitalObjectIdentifier;
    private Date DateAdded;

    private JPanel initialAddApp;

    private JTextField searchBar = new JTextField();

    private JTextArea resultArea = new JTextArea();

    private JButton searchButton = new JButton(new ImageIcon( "src/main/java/com/stir/cscu9t4assignment2021/static/searchButtonImage-96.png"));


    public SearchCitation(int width){

        initialAddApp = new JPanel() ;

        Box box = Box.createVerticalBox();


        box.add(Box.createVerticalStrut(25));
        Border roundedBorder = new LineBorder(Color.lightGray, 2, true);
        searchBar.setBorder(roundedBorder);

        box.add(searchBar);

        searchBar.setPreferredSize(new Dimension(width-275,23));
        box.add(Box.createVerticalStrut(20));

        box.add(resultArea);
        resultArea.setPreferredSize(new Dimension(width-275,400));

        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);

        add(box);
        add(searchButton);


        setLayout(new FlowLayout(FlowLayout.LEFT));






    }





}
