package com.stir.cscu9t4assignment2021.View;

import com.stir.cscu9t4assignment2021.Controller.CitationController;
import com.stir.cscu9t4assignment2021.Model.BookCitation;
import com.stir.cscu9t4assignment2021.Model.Citation;
import com.stir.cscu9t4assignment2021.Model.ConferenceCitation;
import com.stir.cscu9t4assignment2021.Model.JournalCitation;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCitation extends JPanel {
    //Labels

    //private JLabel typeOfPublicationLabel = new JLabel("Type of publication:");

    private JLabel titleLable = new JLabel("Title:");
    private JLabel authorsLabel = new JLabel("Authors:");
    private JLabel digitalObjectIdentifierLabel = new JLabel("DOI:");
    private JLabel nameOfPublisherLabel = new JLabel("name of publication:");
    private JLabel yearOfPublicationLabel = new JLabel("Year of publication:");
    private JLabel dateAddedLabel = new JLabel("Date Added:");

    //textFields

    //private JTextField typeOfPublicationTextField = new JTextField(15);
    private JTextField titleTextField = new JTextField(15);
    private JTextField authorsTextField = new JTextField();
    private JTextField digitalObjectIdentifierTextField = new JTextField();
    private JTextField nameOfPublisherTextField = new JTextField();
    private JTextField yearsOfPublicationTextField = new JTextField();

    DateFormat dateformat = new SimpleDateFormat("dd-mm-yyyy");
    private JFormattedTextField dateAddedTextField = new JFormattedTextField("dd-mm-yyyy");


    //Buttons
    private JButton submitCitation = new JButton(new ImageIcon("src/main/java/com/stir/cscu9t4assignment2021/static/AddButtonImage.png"));

    //Combo box
    String[] publicationChoice = {"Journal Paper", "Conference Paper", "Book Chapter"};
    private JComboBox publicationType = new JComboBox(publicationChoice);


    //elements for  Journal paper
    private JLabel nameOfJournalLabel = new JLabel("Name of the journal:");
    private JTextField nameofJournalTextFiel = new JTextField();
    private JLabel issueLabel = new JLabel(" Issue:");
    private JTextField issueTextField = new JTextField();
    private JLabel volumeLabel = new JLabel(" Volume:");
    private JTextField volumeTextField = new JTextField();
    private  int issue,volume;
    private String nameOfJournal;

    //elements for Conference paper
    private JLabel conferenceNameLabel = new JLabel("Name of the conference:");
    private JTextField conferenceNameTextField = new JTextField();
    private JLabel locationLabel = new JLabel("venue:");
    private JTextField locationTextField = new JTextField();
    private String conferenceName,location;

    //elements for Book Chapter
    private JLabel bookTitleLabel = new JLabel("Title of the book:");
    private JTextField bookTitleTextField = new JTextField();
    private JLabel editorLabel = new JLabel("editor:");
    private JTextField editorTextField = new JTextField();
    private  String bookTitle, editor;


    private JPanel initialAddApp;


    //our form will be stored in these variables:

    //private String typeOfPublication;

    private String title;
    private String[] authors;
    private String digitalObjectIdentifier;
    private String nameOfpublisher;
    private int yearOfPublication;
    private Date dateAdded;





    //where we will later group cthe elements above:
    private Citation collectionOfCitation;


    public AddCitation() {
        initialAddApp = new JPanel();

        //styling of submit button
        submitCitation.setBorderPainted(false);
        submitCitation.setContentAreaFilled(false);


        Box box = Box.createVerticalBox();


        /*** functionality of the dropdown menu with [Journal Paper, Conference Paper , Book chapter] ***/

        box.add(publicationType);

        publicationType.addActionListener(e -> {

            int selection = publicationType.getSelectedIndex(); //get the index of the element selected
            switch (selection) {
                case 0:
                    box.add(nameOfJournalLabel);
                    box.add(nameofJournalTextFiel);

                    box.add(issueLabel);
                    box.add(issueTextField);

                    box.add(volumeLabel);
                    box.add(volumeTextField);

                    box.remove(conferenceNameLabel);
                    box.remove(conferenceNameTextField);
                    box.remove(bookTitleLabel);
                    box.remove(bookTitleTextField);
                    box.remove(locationLabel);
                    box.remove(locationTextField);
                    box.remove(editorLabel);
                    box.remove(editorTextField);

                    box.add(submitCitation);

                    revalidate();
                    break;
                case 1:
                    box.add(conferenceNameLabel);
                    box.add(conferenceNameTextField);
                    box.add(locationLabel);
                    box.add(locationTextField);

                    box.remove(nameOfJournalLabel);
                    box.remove(nameofJournalTextFiel);
                    box.remove(issueLabel);
                    box.remove(issueLabel);
                    box.remove(volumeLabel);
                    box.remove(volumeTextField);
                    box.remove(bookTitleLabel);
                    box.remove(bookTitleTextField);
                    box.remove(editorLabel);
                    box.remove(editorTextField);

                    box.add(submitCitation);
                    revalidate();
                    break;
                case 2:
                    box.add(bookTitleLabel);
                    box.add(bookTitleTextField);
                    box.add(editorLabel);
                    box.add(editorTextField);

                    box.remove(conferenceNameLabel);
                    box.remove(conferenceNameTextField);

                    box.remove(nameOfJournalLabel);
                    box.remove(nameofJournalTextFiel);
                    box.remove(issueLabel);
                    box.remove(issueTextField);
                    box.remove(volumeLabel);
                    box.remove(volumeTextField);
                    box.remove(locationLabel);
                    box.remove(locationTextField);

                    box.add(submitCitation);
                    revalidate();
                    break;
            }
        });


        publicationType.setAlignmentX(LEFT_ALIGNMENT);

        box.add(Box.createVerticalStrut(50));
        box.add(titleLable);
        box.add(titleTextField);

        //box.add(typeOfPublicationLabel);
        //box.add(typeOfPublicationTextField);
        box.add(authorsLabel);
        box.add(authorsTextField);
        box.add(yearOfPublicationLabel);
        box.add(yearsOfPublicationTextField);
        box.add(nameOfPublisherLabel);
        box.add(nameOfPublisherTextField);
        box.add(digitalObjectIdentifierLabel);
        box.add(digitalObjectIdentifierTextField);
        box.add(dateAddedLabel);
        box.add(dateAddedTextField);
        box.add(Box.createVerticalStrut(50));


        box.add(submitCitation);


        /*** Functionality for add button ***/

        submitCitation.addActionListener(e -> {

            try {
                title = titleTextField.getText();
                authors = authorsTextField.toString().split("");
                digitalObjectIdentifier = digitalObjectIdentifierTextField.getText();
                nameOfpublisher = nameOfPublisherTextField.getText();
                yearOfPublication = Integer.parseInt(yearsOfPublicationTextField.getText());

                //journal
                nameOfJournal = nameofJournalTextFiel.getText();
                issue = Integer.parseInt(issueTextField.getText());
                volume = Integer.parseInt(volumeTextField.getText());


                //conference
                conferenceName = conferenceNameTextField.getText();
                location = locationTextField.getText();

                //book
                editor = editorTextField.getText();
                bookTitle = bookTitleTextField.getText();
            }catch (Exception exception){
                System.out.println("missing info!");
            }



            int selection = publicationType.getSelectedIndex(); //get the index of the element selected

            switch (selection) {
                case 0: //journal paper
                    CitationController newJournalCit = new CitationController();
                    collectionOfCitation = new JournalCitation(title,authors, digitalObjectIdentifier,nameOfpublisher,yearOfPublication,nameofJournalTextFiel.getText(),issue,volume);
                    newJournalCit.addCitation(collectionOfCitation);
                    break;
                case 1: //conference
                    CitationController newConferenceCit = new CitationController();
                    collectionOfCitation = new ConferenceCitation(titleTextField.getText(),authors, digitalObjectIdentifierTextField.getText(),nameOfPublisherTextField.getText(),yearOfPublication,conferenceName,location);
                    newConferenceCit.addCitation(collectionOfCitation);
                    break;
                case 2: //book
                    CitationController newBookCit = new CitationController();
                    collectionOfCitation = new BookCitation(titleTextField.getText(),authors, digitalObjectIdentifierTextField.getText(),nameOfPublisherTextField.getText(),yearOfPublication,editor,bookTitle);
                    newBookCit.addCitation(collectionOfCitation);
                    break;
            }


            //newCitation.insertCitation();
        });


        //vertical box layout for element veritaclly assigned
        add(box);

        setLayout(new FlowLayout(FlowLayout.LEFT));


    }


}
