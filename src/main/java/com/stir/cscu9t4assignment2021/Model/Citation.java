package com.stir.cscu9t4assignment2021.Model;

import java.text.DateFormat;

public class Citation {


    private String title;
    private String typeOfPublication;
    private String[] authors;
    private int yearOfPublication;
    private String nameOfpublisher;
    private String digitalObjectIdentifier;
    private DateFormat dateAdded;


    //with date (from user)
    public Citation(String title, String[] authors, String digitalObjectIdentifier, String nameOfpublisher, int yearOfPublication, DateFormat dateAdded) {
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



    public String getTypeOfPublication() {
        return typeOfPublication;
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



    public DateFormat getDateAdded() {
        return dateAdded;
    }



    public String getDigitalObjectIdentifier() {
        return digitalObjectIdentifier;
    }




}

