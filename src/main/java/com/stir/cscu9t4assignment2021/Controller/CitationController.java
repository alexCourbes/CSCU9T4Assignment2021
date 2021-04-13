/**
 *
 * @author 2822236
 */
package com.stir.cscu9t4assignment2021.Controller;
import com.stir.cscu9t4assignment2021.Model.BookCitation;
import com.stir.cscu9t4assignment2021.Model.Citation;
import com.stir.cscu9t4assignment2021.Model.ConferenceCitation;
import com.stir.cscu9t4assignment2021.Model.JournalCitation;

import java.util.*;

public class CitationController {

    private static List<Citation> citationList = new ArrayList<Citation>();
    ;
    private static int iCit = 0;

//LIST were we store all citation
/**CITATION CONTROLLER takes care of all of the functionality of the citations **/

    public CitationController() {

    }

    public void addCitation(Citation citation) {
        citationList.add(citation);
        iCit++;
    }


    //Get all Journal citation as an ojbect
    public Object[] getCitationsJournal() {

        String title, doi, publisher, journalName;
        String location = null;
        String editor = null;
        String authors;

        Object[] allrows = new Object[iCit];

        int lenght = 0;
        for (Citation i : citationList) {

            if (i instanceof JournalCitation) {
                Object[] row = new Object[11];
                title = (((JournalCitation) i).getTitle());
                authors = String.join(",", i.getAuthors());
                doi = (((JournalCitation) i).getDigitalObjectIdentifier());
                publisher = (((JournalCitation) i).getNameOfpublisher());
                journalName = (((JournalCitation) i).getJournalName());
                int year = (((JournalCitation) i).getYearOfPublication());
                String date = (((JournalCitation) i).getDateToString());
                int issue = (((JournalCitation) i).getIssue());
                int volume = (((JournalCitation) i).getVolume());

                row[0] = title;
                row[1] = authors;
                row[2] = doi;
                row[3] = publisher;
                row[4] = journalName;

                row[5] = year;
                row[6] = date;

                row[7] = issue;
                row[8] = volume;

                row[9] = editor;
                row[10] = location;

                allrows[lenght] = row;

            }
            lenght++;
        }
        return allrows;


    }



    //Filter functionality : filter by journal (search panel)
    public Object[] getCitationsJournalFromSearch(String journalNameUser) {
        String title, doi, publisher, journalName;
        String location = null;
        String editor = null;
        String authors;

        Object[] allrows = new Object[iCit];

        int lenght = 0;
        for (Citation i : citationList) {

            if (i instanceof JournalCitation) {
                Object[] row = new Object[11];
                title = (((JournalCitation) i).getTitle());
                authors = String.join(",", i.getAuthors());
                doi = (((JournalCitation) i).getDigitalObjectIdentifier());
                publisher = (((JournalCitation) i).getNameOfpublisher());
                journalName = (((JournalCitation) i).getJournalName());
                int year = (((JournalCitation) i).getYearOfPublication());
                String date = (((JournalCitation) i).getDateToString());
                int issue = (((JournalCitation) i).getIssue());
                int volume = (((JournalCitation) i).getVolume());

                row[0] = title;
                row[1] = authors;
                row[2] = doi;
                row[3] = publisher;
                row[4] = journalName;

                row[5] = year;
                row[6] = date;

                row[7] = issue;
                row[8] = volume;

                row[9] = editor;
                row[10] = location;
                if (journalNameUser.equals(row[4])) {
                    allrows[lenght] = row;
                }

            }
            lenght++;
        }
        return allrows;
    }


    // Get all Conference Citation as an Object
    public Object[] getCitationsConference() {

        String title, doi, publisher, conferenceName, location;
        String editor = null;
        String authors;

        Object[] allrows = new Object[iCit];

        int lenght = 0;

        for (Citation i : citationList) {
            if (i instanceof ConferenceCitation) {
                Object[] row = new Object[11];
                title = (((ConferenceCitation) i).getTitle());
                authors = String.join(",", i.getAuthors());
                doi = (((ConferenceCitation) i).getDigitalObjectIdentifier());
                publisher = (((ConferenceCitation) i).getNameOfpublisher());
                conferenceName = (((ConferenceCitation) i).getLocation());
                location = (((ConferenceCitation) i).getLocation());
                int year = (((ConferenceCitation) i).getYearOfPublication());

                String date = (((ConferenceCitation) i).getDateToString());

                int issue = 0;
                int volume = 0;

                row[0] = title;
                row[1] = authors;
                row[2] = doi;
                row[3] = publisher;
                row[4] = conferenceName;

                row[5] = year;
                row[6] = date;

                row[7] = issue;
                row[8] = volume;

                row[9] = editor;
                row[10] = location;
                allrows[lenght] = row;


            }
            lenght++;

        }

        return allrows;
    }


    // Filter functionality of search: filter by Venue
    public Object[] getCitationsVenueFromSearch(String venueUser) {
        String title, doi, publisher, conferenceName, location;
        int issue = 0;
        int volume = 0;
        String editor = null;
        String authors;

        Object[] allrows = new Object[iCit];

        int lenght = 0;
        for (Citation i : citationList) {

            if (i instanceof ConferenceCitation) {
                Object[] row = new Object[11];
                title = (((ConferenceCitation) i).getTitle());
                authors = String.join(",", i.getAuthors());
                doi = (((ConferenceCitation) i).getDigitalObjectIdentifier());
                publisher = (((ConferenceCitation) i).getNameOfpublisher());
                conferenceName = (((ConferenceCitation) i).getNameOfConference());
                int year = (((ConferenceCitation) i).getYearOfPublication());
                String date = (((ConferenceCitation) i).getDateToString());
                location = (((ConferenceCitation) i).getLocation());

                row[0] = title;
                row[1] = authors;
                row[2] = doi;
                row[3] = publisher;
                row[4] = conferenceName;

                row[5] = year;
                row[6] = date;

                row[7] = issue;
                row[8] = volume;

                row[9] = editor;
                row[10] = location;
                if (venueUser.equals(row[10])) {
                    allrows[lenght] = row;
                }

            }
            lenght++;
        }
        return allrows;
    }



    //Get All book citations as object
    public Object[] getCitationsBook() {

        String title, doi, publisher, bookName, editor;
        String location = null;
        String authors;

        Object[] allrows = new Object[iCit];

        int lenght = 0;

        for (Citation i : citationList) {
            if (i instanceof BookCitation) {
                Object[] row = new Object[11];
                title = (((BookCitation) i).getTitle());
                authors = String.join(",", i.getAuthors());
                doi = (((BookCitation) i).getDigitalObjectIdentifier());
                publisher = (((BookCitation) i).getNameOfpublisher());
                bookName = (((BookCitation) i).getBookName());
                editor = (((BookCitation) i).getEditor());
                int year = (((BookCitation) i).getYearOfPublication());

                String date = (((BookCitation) i).getDateToString());

                int issue = 0;
                int volume = 0;

                row[0] = title;
                row[1] = authors;
                row[2] = doi;
                row[3] = publisher;
                row[4] = bookName;

                row[5] = year;

                row[6] = date;

                row[7] = issue;
                row[8] = volume;

                row[9] = editor;
                row[10] = location;
                allrows[lenght] = row;


            }
            lenght++;

        }

        return allrows;
    }


    //For Filter button from publisher in search Page
    public Object[] getCitationsPublisherFromSearch(String publisherUser) {
        String title, doi, journalName;
        String location = null;
        String editor = null;
        String authors;

        Object[] allrows = new Object[iCit];

        int lenght = 0;
        for (Citation i : citationList) {

            if (i instanceof JournalCitation) {
                Object[] row = new Object[11];
                title = (((JournalCitation) i).getTitle());
                authors = String.join(",", i.getAuthors());
                doi = (((JournalCitation) i).getDigitalObjectIdentifier());
                String publisher = (((JournalCitation) i).getNameOfpublisher());
                journalName = (((JournalCitation) i).getJournalName());
                int year = (((JournalCitation) i).getYearOfPublication());
                String date = (((JournalCitation) i).getDateToString());
                int issue = (((JournalCitation) i).getIssue());
                int volume = (((JournalCitation) i).getVolume());


                row[0] = title;
                row[1] = authors;
                row[2] = doi;
                row[3] = publisher;
                row[4] = journalName;

                row[5] = year;
                row[6] = date;

                row[7] = issue;
                row[8] = volume;

                row[9] = editor;
                row[10] = location;
                if (publisherUser.equals(row[3])) {
                    allrows[lenght] = row;
                    lenght++;
                }

            }

            if (i instanceof ConferenceCitation) {
                Object[] row = new Object[11];
                title = (((ConferenceCitation) i).getTitle());
                authors = String.join(",", i.getAuthors());
                doi = (((ConferenceCitation) i).getDigitalObjectIdentifier());
                String publisher = (((ConferenceCitation) i).getNameOfpublisher());
                journalName = (((ConferenceCitation) i).getNameOfConference());
                int year = (((ConferenceCitation) i).getYearOfPublication());
                String date = (((ConferenceCitation) i).getDateToString());
                int issue = 0;
                int volume = 0;

                row[0] = title;
                row[1] = authors;
                row[2] = doi;
                row[3] = publisher;
                row[4] = journalName;

                row[5] = year;
                row[6] = date;

                row[7] = issue;
                row[8] = volume;

                row[9] = editor;
                row[10] = location;
                if (publisherUser.equals(row[3])) {
                    allrows[lenght] = row;
                    lenght++;
                }

            }

            if (i instanceof BookCitation) {
                Object[] row = new Object[11];
                title = (((BookCitation) i).getTitle());
                authors = String.join(",", i.getAuthors());
                doi = (((BookCitation) i).getDigitalObjectIdentifier());
                String publisher = (((BookCitation) i).getNameOfpublisher());
                journalName = (((BookCitation) i).getBookName());
                int year = (((BookCitation) i).getYearOfPublication());
                String date = (((BookCitation) i).getDateToString());
                int issue = 0;
                int volume = 0;

                row[0] = title;
                row[1] = authors;
                row[2] = doi;
                row[3] = publisher;
                row[4] = journalName;

                row[5] = year;
                row[6] = date;

                row[7] = issue;
                row[8] = volume;

                row[9] = editor;
                row[10] = location;
                if (publisherUser.equals(row[3])) {
                    allrows[lenght] = row;
                    lenght++;
                }

            }


        }
        return allrows;
    }

    //Get All ciitations and parse them to a string (used to export to TXT)
    public String[] getCitationsToString() {


        String Citation = null;
        String[] citArray = new String[citationList.toArray().length];
        int counter = -1;
        for (Citation i : citationList) {
            counter++;

            if (i instanceof JournalCitation) {
                Citation = ((JournalCitation) i).getTitle() + "," + String.join(",", i.getAuthors()) + "," +
                        ((JournalCitation) i).getYearOfPublication() + "," + ((JournalCitation) i).getNameOfpublisher() + "," + "doi: "+
                        ((JournalCitation) i).getDigitalObjectIdentifier() + "," + ((JournalCitation) i).getDateAdded() + "," +
                        ((JournalCitation) i).getJournalName() + "," + ((JournalCitation) i).getVolume() + "," + ((JournalCitation) i).getIssue();

            }
            citArray[counter] = Citation;

            if (i instanceof ConferenceCitation) {
                Citation = ((ConferenceCitation) i).getTitle() + "," + String.join(",", i.getAuthors()) + "," +
                        ((ConferenceCitation) i).getYearOfPublication() + "," + ((ConferenceCitation) i).getNameOfpublisher() + "," +
                        ((ConferenceCitation) i).getDigitalObjectIdentifier() + "," + ((ConferenceCitation) i).getDateAdded() + "," +
                        ((ConferenceCitation) i).getNameOfConference() + "," + ((ConferenceCitation) i).getLocation();

            }
            citArray[counter] = Citation;
            if (i instanceof BookCitation) {
                Citation = ((BookCitation) i).getTitle() + "," + String.join(",", i.getAuthors()) + "," +
                        ((BookCitation) i).getYearOfPublication() + "," + ((BookCitation) i).getNameOfpublisher() + "," +
                        ((BookCitation) i).getDigitalObjectIdentifier() + "," + ((BookCitation) i).getDateAdded() + "," +
                        ((BookCitation) i).getBookName() + "," + ((BookCitation) i).getEditor();
                citArray[counter] = Citation;

            }


        }
        return citArray;
    }


}

            //functionality for copying a single selected row --> not finished


//            public String getCitation ( int selectedRow){
//
//                Citation copy = null;
//                String citation = null;
//                copy = citationList.get(selectedRow + 1);
//
//                //or (Citation i : citationList) {
//
//                if (copy instanceof BookCitation) {
//                    citation = ("[1] " + String.join(",", copy.getAuthors()) + ". " + (((BookCitation) copy).getBookName()) + ". "
//                            + (((BookCitation) copy).getEditor() + ". " + (((BookCitation) copy).getYearOfPublication())
//                            + ". " + (((BookCitation) copy).getYearOfPublication())
//                            + ". " + "Added on: " + (((BookCitation) copy).getDateAdded().toString()
//                            + ". DOI: " + (((BookCitation) copy).getDigitalObjectIdentifier()))));
//
//                    return citation;
//                } else if (copy instanceof ConferenceCitation) {
//                    citation = ("[1] " + String.join(",", copy.getAuthors()) + ". " + (((ConferenceCitation) copy).getNameOfpublisher()) + ". location: "
//                            + (((ConferenceCitation) copy).getNameOfConference() + ". " + (((ConferenceCitation) copy).getYearOfPublication())
//                            + ". " + (((ConferenceCitation) copy).getYearOfPublication())
//                            + ". " + "Added on: " + (((ConferenceCitation) copy).getDateAdded().toString()
//                            + ". DOI: " + (((ConferenceCitation) copy).getDigitalObjectIdentifier()))));
//
//                    return citation;
//                } else if (copy instanceof JournalCitation) {
//                    citation = ("[1] " + String.join(",", copy.getAuthors()) + ". issue:  " + (((JournalCitation) copy).getIssue()) + ". volume: "
//                            + (((JournalCitation) copy).getVolume() + ". " + (((JournalCitation) copy).getYearOfPublication())
//                            + ". " + (((JournalCitation) copy).getYearOfPublication())
//                            + ". " + "Added on: " + (((JournalCitation) copy).getDateAdded().toString()
//                            + ". DOI: " + (((JournalCitation) copy).getDigitalObjectIdentifier()))));
//
//                    return citation;
//                }
//                return citation;
//            }






