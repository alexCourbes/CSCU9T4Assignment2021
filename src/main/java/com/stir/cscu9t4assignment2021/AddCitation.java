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




    public  AddCitation(JPanel panel){
        initialAddApp = panel;

        //Element declaration
        titleLable = new JLabel ("Title:");
        typeOfPublicationLabel = new JLabel("Type of publication:");
        authorsLabel = new JLabel("Authors:");
        yearOfPublicationLabel = new JLabel("Year of publication:");
        nameOfPublicationLabel = new JLabel("name of publication:");
        digitalObjectIdentifierLabel = new JLabel("DOI:");
        dateAddedLabel = new JLabel("Date Added:");

        titleTextField = new JTextField();
        typeOfPublicationTextField = new JTextField();
        authorsTextField = new JTextField();
        yearsOfPublicationTextField = new JTextField();
        nameOfPublicationTextField = new JTextField();
        digitalObjectIdentifierTextField = new JTextField();
        dateAddedTextField= new JTextField();

        Box Vboxlayout = Box.createVerticalBox();
        //Adding element to the panel
        Vboxlayout.add(titleLable);
        Vboxlayout.add(titleTextField);
        Vboxlayout.add(typeOfPublicationLabel);
        Vboxlayout.add(typeOfPublicationTextField);
        Vboxlayout.add(authorsLabel);
        Vboxlayout.add(authorsTextField);
        Vboxlayout.add(yearOfPublicationLabel);
        Vboxlayout.add(yearsOfPublicationTextField);
        Vboxlayout.add(nameOfPublicationLabel);
        Vboxlayout.add(nameOfPublicationTextField);
        Vboxlayout.add(digitalObjectIdentifierLabel);
        Vboxlayout.add(digitalObjectIdentifierTextField);
        Vboxlayout.add(dateAddedLabel);
        Vboxlayout.add(dateAddedTextField);
         //vertical box layout for element veritaclly assigned

        initialAddApp.add(Vboxlayout);

    }





}
