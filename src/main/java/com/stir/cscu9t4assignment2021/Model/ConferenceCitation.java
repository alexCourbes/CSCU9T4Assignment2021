package com.stir.cscu9t4assignment2021.Model;

import java.util.Date;

public class ConferenceCitation extends Citation {

    private String location,venue;


    //with date
    public ConferenceCitation(String title, String[] authors, String digitalObjectIdentifier, String publisher,String location, int yearOfPublication, Date dateAdded , String venue) {
        super(title, authors, digitalObjectIdentifier, publisher, yearOfPublication,dateAdded);
        this.location = location;
        this.venue = venue;
    }

    //without date (from user)
    public ConferenceCitation(String title, String[] authors, String digitalObjectIdentifier, String publisher,String location, int yearOfPublication,  String venue) {
        super(title,authors,digitalObjectIdentifier,publisher,yearOfPublication);
        this.location = location;
        this.venue = venue;
    }



    public String getLocation() {
        return location;
    }
    public String getVenue() {
        return venue;
    }



}
