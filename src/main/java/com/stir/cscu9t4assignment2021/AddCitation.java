package com.stir.cscu9t4assignment2021;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class AddCitation extends JPanel{

    private String title;
    private String typeOfPublication;
    private String [] authors;
    private int yearOfPublication;
    private String nameOfpublisher;
    private String digitalObjectIdentifier;
    private Date dateAdded;

    private JLabel titleLable;
    private JLabel typeOfPublicationLabel;
    private JLabel authorsLabel;
    private JLabel yearOfPublicationLabel;
    private JLabel nameOfPublicationLabel;
    private JLabel digitalObjectIdentifierLabel;
    private JLabel dateAddedLabel;

    private JTextField titleTextField;
    private JTextField typeOfPublicationTextField;
    private JTextField authorsTextField;
    private JTextField yearsOfPublicationTextField;
    private JTextField nameOfPublicationTextField;
    private JTextField digitalObjectIdentifierTextField;
    private JTextField dateAddedTextField;

    private JPanel initialAddApp;




    public  AddCitation(int Height, int Width){
        initialAddApp = new JPanel();

        //Element declaration
        titleLable = new JLabel ("Title:");
        typeOfPublicationLabel = new JLabel("Type of publication:");
        authorsLabel = new JLabel("Authors:");
        yearOfPublicationLabel = new JLabel("Year of publication:");
        nameOfPublicationLabel = new JLabel("name of publication:");
        digitalObjectIdentifierLabel = new JLabel("DOI:");
        dateAddedLabel = new JLabel("Date Added:");

        titleTextField = new JTextField(15);
        typeOfPublicationTextField = new JTextField(15);
        authorsTextField = new JTextField();
        yearsOfPublicationTextField = new JTextField();
        nameOfPublicationTextField = new JTextField();
        digitalObjectIdentifierTextField = new JTextField();
        dateAddedTextField= new JTextField();


        //Adding element to the panel

        Box box = Box.createVerticalBox();

        box.add(titleLable);
        box.add(titleTextField);

        box.add(typeOfPublicationLabel);
        box.add(typeOfPublicationTextField);
        box.add(authorsLabel);
        box.add(authorsTextField);
        box.add(yearOfPublicationLabel);
        box.add(yearsOfPublicationTextField);
        box.add(nameOfPublicationLabel);
        box.add(nameOfPublicationTextField);
        box.add(digitalObjectIdentifierLabel);
        box.add(digitalObjectIdentifierTextField);
        box.add(dateAddedLabel);
        box.add(dateAddedTextField);

         //vertical box layout for element veritaclly assigned
        add(box);
        setLayout(new FlowLayout(FlowLayout.LEFT));


    }





}
