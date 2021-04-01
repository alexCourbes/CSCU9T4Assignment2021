package com.stir.cscu9t4assignment2021.Model;

import java.util.Date;

public class Citation {

    private String title;
    private String typeOfPublication;
    private String[] authors;
    private int yearOfPublication;
    private String nameOfpublisher;
    private String digitalObjectIdentifier;
    private Date dateAdded;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getTypeOfPublication() {
        return typeOfPublication;
    }

    public void setTypeOfPublication(String typeOfPublication) {
        this.typeOfPublication = typeOfPublication;
    }

    public String getNameOfpublisher() {
        return nameOfpublisher;
    }

    public void setNameOfpublisher(String nameOfpublisher) {
        this.nameOfpublisher = nameOfpublisher;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDigitalObjectIdentifier() {
        return digitalObjectIdentifier;
    }

    public void setDigitalObjectIdentifier(String digitalObjectIdentifier) {
        this.digitalObjectIdentifier = digitalObjectIdentifier;
    }
}
