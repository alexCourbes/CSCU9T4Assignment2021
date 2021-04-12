package com.stir.cscu9t4assignment2021.Model;

import java.text.DateFormat;
import java.util.Date;

public class BookCitation extends Citation {
    private String editor,bookName;


    public BookCitation(String title, String[] authors, String digitalObjectIdentifier , String publisher, int yearOfPublication, Date dateAdded, String editor, String bookTitle) {
        super(title, authors,digitalObjectIdentifier , publisher, yearOfPublication, dateAdded);
        this.editor = editor;
        this.bookName = bookTitle;
    }
    public BookCitation(String title, String[] authors, String digitalObjectIdentifier , String publisher, int yearOfPublication, String editor, String bookName) {
        super(title, authors,digitalObjectIdentifier , publisher, yearOfPublication );
        this.editor = editor;
        this.bookName = bookName;
    }

    public String getEditor() {
        return editor;
    }

    public String getBookName() {
        return bookName;
    }






}
