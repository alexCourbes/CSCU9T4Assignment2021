package com.stir.cscu9t4assignment2021.View;

import com.stir.cscu9t4assignment2021.Controller.CitationController;
import com.stir.cscu9t4assignment2021.Model.BookCitation;
import com.stir.cscu9t4assignment2021.Model.Citation;
import com.stir.cscu9t4assignment2021.Model.ConferenceCitation;
import com.stir.cscu9t4assignment2021.Model.JournalCitation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class AddCitation extends JPanel {

    //Labels

    //private JLabel typeOfPublicationLabel = new JLabel("Type of publication:");

    private JLabel titleLable = new JLabel("Title:");
    private JLabel authorsLabel = new JLabel("Authors:");
    private JLabel digitalObjectIdentifierLabel = new JLabel("DOI:");
    private JLabel nameOfPublisherLabel = new JLabel("name of publisher:");
    private JLabel yearOfPublicationLabel = new JLabel("Year of publication:");

    private JLabel dateAddedLabel = new JLabel("Date Added: DD-MM-YYYY");

    //textFields

    //private JTextField typeOfPublicationTextField = new JTextField(15);
    private JTextField titleTextField = new JTextField(15);
    private JTextField authorsTextField = new JTextField();
    private JTextField digitalObjectIdentifierTextField = new JTextField();
    private JTextField nameOfPublisherTextField = new JTextField();
    private JTextField yearsOfPublicationTextField = new JTextField();


    private JFormattedTextField dateAddedTextField = new JFormattedTextField();

    //Date
    JCheckBox automaticDateAdded = new JCheckBox("Today's date", false);


    //Buttons
    private JButton submitCitation = new JButton(new ImageIcon("src/main/java/com/stir/cscu9t4assignment2021/static/AddButtonImage.png"));

    //Combo box
    String[] publicationChoice = {"Journal Paper", "Conference Paper", "Book Chapter"};
    private JComboBox publicationType = new JComboBox(publicationChoice);


    //elements for  Journal paper
    private JLabel nameOfJournalLabel = new JLabel("Name of the journal:");
    private JTextField nameofJournalTextField = new JTextField();
    private JLabel issueLabel = new JLabel(" Issue:");
    private JTextField issueTextField = new JTextField();
    private JLabel volumeLabel = new JLabel(" Volume:");
    private JTextField volumeTextField = new JTextField();
    private int issue, volume;
    private String nameOfJournal;

    //elements for Conference paper
    private JLabel conferenceNameLabel = new JLabel("Name of the conference:");
    private JTextField conferenceNameTextField = new JTextField();
    private JLabel locationLabel = new JLabel("venue:");
    private JTextField locationTextField = new JTextField();
    private String conferenceName, location;

    //elements for Book Chapter
    private JLabel bookTitleLabel = new JLabel("Title of the book:");
    private JTextField bookTitleTextField = new JTextField();
    private JLabel editorLabel = new JLabel("editor:");
    private JTextField editorTextField = new JTextField();
    private String bookTitle, editor;


    private JPanel initialAddApp;


    //our form will be stored in these variables:

    //private String typeOfPublication;

    private String title = "";
    private String[] authors;
    private String digitalObjectIdentifier = "";
    private String nameOfPublisher = "";
    private int yearOfPublication = 0;
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
                    box.add(nameofJournalTextField);

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
                    box.remove(nameofJournalTextField);
                    box.remove(issueLabel);
                    box.remove(issueTextField);
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
                    box.remove(nameofJournalTextField);
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

        Box dateBox = Box.createHorizontalBox();
        box.add(dateAddedLabel);
        box.add(dateBox);
        dateBox.add(dateAddedTextField);
        box.add(automaticDateAdded);
        //journal paper entry is set to the default
        box.add(Box.createVerticalStrut(50));
        box.add(nameOfJournalLabel);
        box.add(nameofJournalTextField);

        box.add(issueLabel);
        box.add(issueTextField);

        box.add(volumeLabel);
        box.add(volumeTextField);
        box.add(Box.createVerticalStrut(50));


        box.add(submitCitation);

        /** ADD button UI **/

        //Mouse listener for cursor pointer in add button
        submitCitation.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                submitCitation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                submitCitation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        /*** Functionality for Date Cehckbox ***/

        automaticDateAdded.addActionListener(e -> {


            if (automaticDateAdded.isSelected()) {
                dateAddedTextField.setEnabled(false);

                dateAdded = new Date();


            } else {
                dateAddedTextField.setEnabled(true);
            }

        });


        /*** Functionality for add button ***/

        submitCitation.addActionListener(e -> {


            title = titleTextField.getText();

            authors = authorsTextField.getText().split(";"); /** to be modified **/

            digitalObjectIdentifier = digitalObjectIdentifierTextField.getText();
            nameOfPublisher = nameOfPublisherTextField.getText();
            try {
                yearOfPublication = Integer.parseInt(yearsOfPublicationTextField.getText());
            } catch (NumberFormatException exception) {
                yearOfPublication = 0;
                JOptionPane.showMessageDialog(null, "Year field is missing! year has been set to 0");
            }



            int selection = publicationType.getSelectedIndex(); //get the index of the element selected

            switch (selection) {
                case 0: //journal paper
                    nameOfJournal = nameofJournalTextField.getText();
                    try {
                        issue = Integer.parseInt(issueTextField.getText());

                    } catch (NumberFormatException exception) {
                        issue = 0;
                        JOptionPane.showMessageDialog(null, "Issue field missing, issue set to 0");
                    }
                    try {
                        volume = Integer.parseInt(volumeTextField.getText());
                    } catch (NumberFormatException exception) {
                        volume = 0;
                        JOptionPane.showMessageDialog(null, "Volume field missing, Volume set to 0");
                    }
                    CitationController newJournalCit = new CitationController();
                    collectionOfCitation = new JournalCitation(title, authors, digitalObjectIdentifier, nameOfPublisher, nameOfJournal,yearOfPublication, dateAdded, issue, volume);
                    newJournalCit.addCitation(collectionOfCitation);
                    break;
                case 1: //conference
                    conferenceName = conferenceNameTextField.getText();
                    location = locationTextField.getText();
                    CitationController newConferenceCit = new CitationController();
                    collectionOfCitation = new ConferenceCitation(titleTextField.getText(), authors, digitalObjectIdentifier, nameOfPublisher,conferenceName, yearOfPublication, dateAdded , location);
                    newConferenceCit.addCitation(collectionOfCitation);
                    break;
                case 2: //book
                    editor = editorTextField.getText();
                    bookTitle = bookTitleTextField.getText();
                    CitationController newBookCit = new CitationController();
                    collectionOfCitation = new BookCitation(titleTextField.getText(), authors, digitalObjectIdentifier, nameOfPublisher,bookTitle, yearOfPublication, dateAdded, editor);
                    newBookCit.addCitation(collectionOfCitation);
                    break;
            }
            JOptionPane.showMessageDialog(null, "The entry has been successfully added to the record !");

            /*** Clearing all the JTextfields ***/
            titleTextField.setText(null);
            authorsTextField.setText(null);
            yearsOfPublicationTextField.setText(null);
            nameOfPublisherTextField.setText(null);
            digitalObjectIdentifierTextField.setText(null);
            dateAddedTextField.setText(null);
            nameofJournalTextField.setText(null);
            issueTextField.setText(null);
            volumeTextField.setText(null);
            conferenceNameTextField.setText(null);
            locationTextField.setText(null);
            bookTitleTextField.setText(null);
            editorTextField.setText(null);

        });


        //vertical box layout for element veritaclly assigned
        add(box);

        setLayout(new FlowLayout(FlowLayout.LEFT));


    }


}
