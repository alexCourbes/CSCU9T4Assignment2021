package com.stir.cscu9t4assignment2021.Model;
import java.util.Date;
/**
 *
 * @author 2822236
 */
public class ConferenceCitation extends Citation {

    private String nameOfConference, location;


    //with date
    public ConferenceCitation(String title, String[] authors, String digitalObjectIdentifier, String publisher,String nameOfConference, int yearOfPublication, Date dateAdded , String location) {

        super(title, authors, digitalObjectIdentifier, publisher, yearOfPublication,dateAdded);
        this.nameOfConference = nameOfConference;
        this.location = location;
    }

    //without date (from user)
    public ConferenceCitation(String title, String[] authors, String digitalObjectIdentifier, String publisher,String nameOfConference, int yearOfPublication,  String location) {
        super(title,authors,digitalObjectIdentifier,publisher,yearOfPublication);
        this.nameOfConference = location;
        this.location = location;
    }



    public String getNameOfConference() {
        return nameOfConference;
    }
    public String getLocation() {
        return location;
    }



}
