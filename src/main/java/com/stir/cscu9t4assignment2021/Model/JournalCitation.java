package com.stir.cscu9t4assignment2021.Model;

import java.text.DateFormat;
import java.util.Date;

public class JournalCitation extends Citation {

    private String journalName;
    private int issue,volume;
    private Date dateAdded;

    //program defines date
    public JournalCitation( String title, String[] authors, String digitalObjectIdentifier, String nameOfPublisher, int yearOfPublication, DateFormat dateAdded, String journalName, int issue, int volume) {
        super(title, authors, digitalObjectIdentifier, nameOfPublisher, yearOfPublication,dateAdded);
        this.journalName = journalName;
        this.issue = issue;
        this.volume = volume;
    }

    //program defines date
    public JournalCitation(

            String title, String[] authors, String digitalObjectIdentifier, String publisher, int yearOfPublication, String journalName, int issue, int volume) {
        super(title, authors, digitalObjectIdentifier, publisher, yearOfPublication);
        this.journalName = journalName;
        this.issue = issue;
        this.volume = volume;


    }

    public String getJournalName() {
        return journalName;
    }

    public int getIssue() {
        return issue;
    }

    public int getVolume() {
        return volume;
    }
}
