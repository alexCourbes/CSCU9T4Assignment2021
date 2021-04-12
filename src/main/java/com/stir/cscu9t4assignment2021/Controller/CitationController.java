package com.stir.cscu9t4assignment2021.Controller;

import com.stir.cscu9t4assignment2021.Model.BookCitation;
import com.stir.cscu9t4assignment2021.Model.Citation;
import com.stir.cscu9t4assignment2021.Model.ConferenceCitation;
import com.stir.cscu9t4assignment2021.Model.JournalCitation;

import java.text.DateFormat;
import java.util.*;

public class CitationController {

    private static List<Citation> citationList = new ArrayList<Citation>();
    ;
    private static int iCit = 0;
//LIST were we store all citation


    public CitationController() {

    }

    public void addCitation(Citation citation) {
        citationList.add(citation);
        iCit++;
    }

    public Object[] getCitationsJournal() {

        String title, doi, publisher, journalName;
        String location = null;
        String editor = null;
        String[] authors;

        Object[] allrows = new Object[iCit];

        int lenght = 0;
        for (Citation i : citationList) {

            if (i instanceof JournalCitation) {
                Object[] row = new Object[11];
                title = (((JournalCitation) i).getTitle());
                authors = (((JournalCitation) i).getAuthors());
                doi = (((JournalCitation) i).getDigitalObjectIdentifier());
                publisher = (((JournalCitation) i).getNameOfpublisher());
                journalName = (((JournalCitation) i).getJournalName());
                int year = (((JournalCitation) i).getYearOfPublication());
                DateFormat date = (((JournalCitation) i).getDateAdded());
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

    public Object[] getCitationsConference() {

        String title, doi, publisher, conferenceName, location;
        String editor = null;
        String[] authors;

        Object[] allrows = new Object[iCit];

        int lenght = 0;

        for (Citation i : citationList) {
            if (i instanceof ConferenceCitation) {
                Object[] row = new Object[11];
                title = (((ConferenceCitation) i).getTitle());
                authors = (((ConferenceCitation) i).getAuthors());
                doi = (((ConferenceCitation) i).getDigitalObjectIdentifier());
                publisher = (((ConferenceCitation) i).getNameOfpublisher());
                conferenceName = (((ConferenceCitation) i).getVenue());
                location = (((ConferenceCitation) i).getLocation());
                int year = (((ConferenceCitation) i).getYearOfPublication());

                DateFormat date = (((ConferenceCitation) i).getDateAdded());

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


    public Object[] getCitationsBook() {

        String title, doi, publisher, bookName, editor,authorsTring;
        String location=null;
        String[] authors;

        Object[] allrows = new Object[iCit];

        int lenght = 0;

        for (Citation i : citationList) {
            if (i instanceof BookCitation) {
                Object[] row = new Object[11];
                title = (((BookCitation) i).getTitle());
                authors = (((BookCitation) i).getAuthors());
                doi = (((BookCitation) i).getDigitalObjectIdentifier());
                publisher = (((BookCitation) i).getNameOfpublisher());
                bookName=(((BookCitation) i).getBookName());
                editor = (((BookCitation) i).getEditor());
                int year = (((BookCitation) i).getYearOfPublication());

                DateFormat date = (((BookCitation) i).getDateAdded());

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
}





//            if (i instanceof BookCitation) {
//                System.out.println(((BookCitation) i).getBookName());
//            }
//            if (i instanceof ConferenceCitation) {
//                //System.out.println(((ConferenceCitation) i).());
//            }
