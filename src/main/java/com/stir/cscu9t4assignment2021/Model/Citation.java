package com.stir.cscu9t4assignment2021.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Citation {


    private String title;
    private String[] authors;
    private int yearOfPublication;
    private String nameOfpublisher;
    private String digitalObjectIdentifier;
    private Date dateAdded;


    //with date (from user)
    public Citation(String title, String[] authors, String digitalObjectIdentifier, String nameOfpublisher, int yearOfPublication, Date dateAdded) {
        this.title = title;
        this.authors = authors;
        this.digitalObjectIdentifier = digitalObjectIdentifier;
        this.nameOfpublisher = nameOfpublisher;
        this.yearOfPublication = yearOfPublication;
        this.dateAdded = dateAdded;
    }


    //Without date (date added)
    public Citation(String title, String[] authors, String digitalObjectIdentifier, String nameOfpublisher, int yearOfPublication) {
        this.title = title;
        this.authors = authors;
        this.digitalObjectIdentifier = digitalObjectIdentifier;
        this.nameOfpublisher = nameOfpublisher;
        this.yearOfPublication = yearOfPublication;
    }




    public String getTitle() {
        return title;
    }



    public String getNameOfpublisher() {
        return nameOfpublisher;
    }



    public String[] getAuthors() {
        return authors;
    }


    public int getYearOfPublication() {
        return yearOfPublication;
    }



    public String getDateAdded() {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

        return date.parse(dateAdded);
    }



    public String getDigitalObjectIdentifier() {
        return digitalObjectIdentifier;
    }


    public String getCitation() {
        String result = getTitle();
        return result;
    }

}

