package com.stir.cscu9t4assignment2021.Model;

import java.text.DateFormat;
import java.util.Date;

public class ConferenceCitation extends Citation {

    private String conferenceName,location;


    //with date
    public ConferenceCitation(String title, String[] authors, String digitalObjectIdentifier, String publisher, int yearOfPublication, Date dateAdded, String conferenceName, String location) {
        super(title, authors, digitalObjectIdentifier, publisher, yearOfPublication,dateAdded);
        this.conferenceName = conferenceName;
        this.location = location;
    }

    //without date (from user)
    public ConferenceCitation(String title, String[] authors, String digitalObjectIdentifier, String nameOfpublisher, int yearOfPublication, String venue, String location) {
        super(title,authors,digitalObjectIdentifier,nameOfpublisher,yearOfPublication);
        this.conferenceName = venue;
        this.location = location;
    }



    public String getVenue() {
        return conferenceName;
    }

    public String getLocation() {
        return location;
    }
}
