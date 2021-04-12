package com.stir.cscu9t4assignment2021.View;

import com.stir.cscu9t4assignment2021.Controller.CitationController;
import com.stir.cscu9t4assignment2021.Model.JournalCitation;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;
import java.util.Vector;

public class SearchCitation extends JPanel {

    private String Title;
    private String TypeOfPublication;
    private String[] Authors;
    private int YearOfPublication;
    private String NameOfpublisher;
    private String DigitalObjectIdentifier;
    private Date DateAdded;

    private JPanel initialAddApp;

    private JTextField searchBar = new JTextField();

    private JTable citTable;

    private JButton searchButton = new JButton(new ImageIcon("src/main/java/com/stir/cscu9t4assignment2021/static/searchButtonImage-96.png"));


    /*** Search Fields ***/

    //filter by type
    private JLabel filterByTypeLabel = new JLabel("Filter by Type");
    String[] filterByTypeOptions = {"Journal", "Conference", "Book"};
    private JComboBox filterByType = new JComboBox(filterByTypeOptions);

    //filter by


    //filter by
    public SearchCitation(int width) {

        initialAddApp = new JPanel();

        Box box = Box.createVerticalBox();


        box.add(Box.createVerticalStrut(25));
        Border roundedBorder = new LineBorder(Color.lightGray, 2, true);
        searchBar.setBorder(roundedBorder);

        box.add(searchBar);

        searchBar.setPreferredSize(new Dimension(width - 275, 23));
        box.add(Box.createVerticalStrut(20));

        CitationController allCitation = new CitationController();


        /***TABLE***/

        Object[] columns = new Object[]{"Title", "Authors", "DOI", "Publisher", "Name", "Year", "Date", "Issue", "Volume", "editor", "location"};

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





        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        box.add(new JScrollPane(citTable));
        add(box);

        add(Box.createHorizontalStrut(220));

        add(filterByTypeLabel);
        add(filterByType);
        add(searchButton);

        /**Filter by Functionality**/
    searchButton.addActionListener(e->{
        model.setRowCount(0);
        int selection = filterByType.getSelectedIndex(); //get the index of the element selected
        switch (selection) {

            case 0:
                Object[] onlyJournalRows = new Object[10];
                onlyJournalRows = allCitation.getCitationsJournal();
                if (onlyJournalRows.length >= 1) {
                    for (int i = 0; i < numberOfJournalRows; i++) {
                        if (!(onlyJournalRows[i] == null)) {
                            model.addRow((Object[]) onlyJournalRows[i]); // Adding all the rows
                        }
                    }
                }
                break;
            case 1:
                Object[] conferenceOnlyRows = new Object[10];
                conferenceOnlyRows = allCitation.getCitationsConference();
                if (conferenceOnlyRows.length >= 1) {
                    for (int i = 0; i < numberOfConferenceRows; i++) {
                        if (!(conferenceOnlyRows[i] == null)) {
                            model.addRow((Object[]) conferenceOnlyRows[i]);
                        }
                    }
                }
            case 2:
                Object[] bookOnlyRow = new Object[10];
                bookOnlyRow = allCitation.getCitationsBook();
                if (bookOnlyRow.length >= 1) {
                    for (int i = 0; i < numberOfBookRows; i++) {
                        if (!(bookOnlyRow[i] == null)) {
                            model.addRow((Object[]) bookOnlyRow[i]);
                        }
                    }
                }



        }
    });

        setLayout(new FlowLayout(FlowLayout.LEFT));


    }


}
