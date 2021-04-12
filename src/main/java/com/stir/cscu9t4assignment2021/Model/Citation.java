package com.stir.cscu9t4assignment2021.Model;

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



    public Date getDateAdded() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return  dateAdded;
    }

    public String getDateToString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return  sdf.format(dateAdded);
    }


    public String getDigitalObjectIdentifier() {
        return digitalObjectIdentifier;
    }


    public String getCitation() {
        String result = getTitle();
        return result;
    }

}

