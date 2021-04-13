package com.stir.cscu9t4assignment2021.Model;

import java.text.DateFormat;
import java.util.Date;

public class BookCitation extends Citation {

    private String editor,bookTitle;


    public BookCitation(String title, String[] authors, String digitalObjectIdentifier , String publisher, String bookTitle, int yearOfPublication, Date dateAdded, String editor) {
        super(title, authors,digitalObjectIdentifier , publisher, yearOfPublication, dateAdded);
        this.editor = editor;
        this.bookTitle = bookTitle;
    }
    public BookCitation(String title, String[] authors, String digitalObjectIdentifier , String publisher, int yearOfPublication, String editor, String bookTitle) {
        super(title, authors,digitalObjectIdentifier , publisher, yearOfPublication );
        this.editor = editor;
        this.bookTitle = bookTitle;

    }

    public String getEditor() {
        return editor;
    }

    public String getBookName() {
        return bookTitle;
    }

    @Override
    public String getCitation() {
        return super.getCitation();
    }
}
