package com.stir.cscu9t4assignment2021.View;

import com.stir.cscu9t4assignment2021.Controller.CitationController;
import com.stir.cscu9t4assignment2021.Model.BookCitation;
import com.stir.cscu9t4assignment2021.Model.ConferenceCitation;
import com.stir.cscu9t4assignment2021.Model.JournalCitation;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

public class SearchCitation extends JPanel {


    private JPanel initialAddApp;

    private JTextField searchBar = new JTextField();

    private JTable citTable;

    /**
     * JButtons:  & filter
     **/

    private JButton searchButton = new JButton(new ImageIcon("src/main/java/com/stir/cscu9t4assignment2021/static/searchButtonImage-96.png"));
    private JButton filterButton = new JButton(new ImageIcon("src/main/java/com/stir/cscu9t4assignment2021/static/Filter-96.png"));
    private JButton copySelected = new JButton(new ImageIcon("src/main/java/com/stir/cscu9t4assignment2021/static/CopyButton-48.png"));
    /**
     * JCheckbox:Order Alphabetically of Author
     ***/
    private JCheckBox orderAlphabetically = new JCheckBox("Order Alphabetically", false);

    /***FIND ALL BY**/
    String[] filterByTypeOptions = {"name of Citation(Journal)", "Conference Location", "Publisher"};
    private JComboBox findBy = new JComboBox(filterByTypeOptions);


    /*** Search Fields ***/

    //filter by type
    private JLabel filterByTypeLabel = new JLabel("Filter by Type");

    String[] filterByTypeOp = {"Journal", "Conference", "Book"};
    private JComboBox filterByType = new JComboBox(filterByTypeOp);

    //filter by


    //filter by
    public SearchCitation(int width) {

        initialAddApp = new JPanel();

        Box box = Box.createVerticalBox();


        box.add(Box.createVerticalStrut(25));
        Border roundedBorder = new LineBorder(Color.lightGray, 2, true);

        searchBar.setBorder(roundedBorder);
        box.add(findBy);
        box.add(Box.createVerticalStrut(25));

        box.add(searchBar);


        Box searchFilterBox = Box.createHorizontalBox();
        box.add(filterButton);
        Box.createRigidArea(new Dimension(200, 200));
        filterButton.setContentAreaFilled(false);
        filterButton.setBorderPainted(false);


//
//        findBy.setRenderer(new DefaultListCellRenderer() {
//
//            String[] filterByTypeOptions = {"Journal", "Conference", "Book"};
//
//            @Override
//            public Component getListCellRendererComponent(JList list, Object value,
//                                                          int index, boolean isSelected, boolean hasFocus) {
//                index=-1;
//                value=null;
//                value=filterByTypeOptions;
//                if (index == -1 && value == null)
//                    setText("Find All");
//                else
//                    setText(value.toString());
//                return this;
//            }
//
//        });


        searchBar.setPreferredSize(new Dimension(width - 275, 23));
        box.add(Box.createVerticalStrut(20));

        CitationController allCitation = new CitationController();


        /***TABLE***/

        Object[] columns = new Object[]{"Title", "Authors", "DOI", "Publisher", "Name of Citation", "Year", "Date", "Issue", "Volume", "editor", "location"};

        citTable = new JTable();
        //model for the table

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.setColumnIdentifiers(columns); //setting the collumn headers
        citTable.setModel(model);
        //citTable.getSelectedRow();

        citTable.getTableHeader().setReorderingAllowed(false);


        Object[] journalRows = new Object[10];
        journalRows = allCitation.getCitationsJournal();

        Object[] conferenceRows = new Object[10];
        conferenceRows = allCitation.getCitationsConference();

        Object[] bookRow = new Object[10];
        bookRow = allCitation.getCitationsBook();

        int numberOfJournalRows = journalRows.length;
        int numberOfConferenceRows = conferenceRows.length;
        int numberOfBookRows = conferenceRows.length;


        if (journalRows.length >= 1) {
            for (int i = 0; i < numberOfJournalRows; i++) {
                if (!(journalRows[i] == null)) {
                    model.addRow((Object[]) journalRows[i]); // Adding all the rows
                }
            }
        }

        if (conferenceRows.length >= 1) {
            for (int i = 0; i < numberOfConferenceRows; i++) {
                if (!(conferenceRows[i] == null)) {
                    model.addRow((Object[]) conferenceRows[i]);
                }
            }
        }
        if (bookRow.length >= 1) {
            for (int i = 0; i < numberOfBookRows; i++) {
                if (!(bookRow[i] == null)) {
                    model.addRow((Object[]) bookRow[i]);
                }
            }
        }



        box.add(new JScrollPane(citTable));
        add(box);

        add(Box.createHorizontalStrut(220));

        add(filterByTypeLabel);
        add(filterByType);
        add(searchButton);
        add(copySelected);

        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        copySelected.setBorderPainted(false);
        copySelected.setContentAreaFilled(false);
        /**Filter by Functionality**/
        searchButton.addActionListener(e -> {
            model.setRowCount(0);
            int selection = filterByType.getSelectedIndex(); //get the index of the element selected
            switch (selection) {

                case 0: // By Journal
                    model.setRowCount(0);
                    Object[] JournalOnlyRows = new Object[10];
                    JournalOnlyRows = allCitation.getCitationsJournal();
                    if (JournalOnlyRows.length >= 1) {
                        for (int i = 0; i < numberOfJournalRows; i++) {
                            if (!(JournalOnlyRows[i] == null)) {
                                model.addRow((Object[]) JournalOnlyRows[i]); // Adding all the rows
                            }
                        }
                    }
                    break;
                case 1: //by conference
                    model.setRowCount(0);
                    Object[] conferenceOnlyRows = new Object[10];
                    conferenceOnlyRows = allCitation.getCitationsConference();
                    if (conferenceOnlyRows.length >= 1) {
                        for (int i = 0; i < numberOfConferenceRows; i++) {
                            if (!(conferenceOnlyRows[i] == null)) {
                                model.addRow((Object[]) conferenceOnlyRows[i]);
                            }
                        }
                    }
                    break;
                case 2: // by Book
                    model.setRowCount(0);
                    Object[] bookOnlyRow = new Object[10];
                    bookOnlyRow = allCitation.getCitationsBook();
                    if (bookOnlyRow.length >= 1) {
                        for (int i = 0; i < numberOfBookRows; i++) {
                            if (!(bookOnlyRow[i] == null)) {
                                model.addRow((Object[]) bookOnlyRow[i]);
                            }
                        }
                    }
                    break;

            }
        });

        /*** JCOMBO BOX ***/


        Object[] finalJournalRows = journalRows;
        filterButton.addActionListener(e -> {
            int index = findBy.getSelectedIndex();
            String userInput = searchBar.getText();
            switch (index) {


                case 0: //Name of journal Citaion

                    model.setRowCount(0);
                    Object[] journalRowsFromSearch = new Object[10];
                    journalRowsFromSearch = allCitation.getCitationsJournalFromSearch(userInput);
                    int numberOfJournalRowsFromSearch = journalRowsFromSearch.length;

                    for (int i = 0; i < numberOfJournalRowsFromSearch; i++) {
                        if (!(journalRowsFromSearch[i] == null)) {
                            model.addRow((Object[]) journalRowsFromSearch[i]); // Adding all the rows
                        }
                    }
                    break;

                case 1: //Conference Venue
                    model.setRowCount(0);
                    Object[] venueRowsFromSearch = new Object[10];
                    venueRowsFromSearch = allCitation.getCitationsVenueFromSearch(userInput);

                    int numberOfVenueRowsFromSearch = venueRowsFromSearch.length;

                    for (int i = 0; i < numberOfVenueRowsFromSearch; i++) {
                        if (!(venueRowsFromSearch[i] == null)) {
                            model.addRow((Object[]) venueRowsFromSearch[i]); // Adding all the rows
                        }
                    }
                    break;

                case 2: //Publisher
                    model.setRowCount(0);
                    Object[] publisherRowsFromSearch = new Object[10];

                    publisherRowsFromSearch = allCitation.getCitationsPublisherFromSearch(userInput);
                    int numberOfPublisherRowsFromSearch = publisherRowsFromSearch.length;

                    for (int i = 0; i < numberOfPublisherRowsFromSearch; i++) {
                        if (!(publisherRowsFromSearch[i] == null)) {
                            model.addRow((Object[]) publisherRowsFromSearch[i]); // Adding all the rows
                        }
                    }
                    break;

            }
        });
        /** COPY CITATION FUNCTIONALITY **/

        copySelected.addActionListener(e->{
            int selectedRow = citTable.getSelectedRow();
            JOptionPane copyBox = new JOptionPane();
            CitationController  bookCopy = new CitationController();
           // String resutl = bookCopy.getCitation(selectedRow);
            // JLabel citation =  new JLabel(resutl);

            JOptionPane.showMessageDialog(initialAddApp,"implementation not working!!");
        });


    }


}

