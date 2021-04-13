package com.stir.cscu9t4assignment2021.Controller;
/**
 *
 * @author 2822236
 */
import com.stir.cscu9t4assignment2021.Model.BookCitation;

import com.stir.cscu9t4assignment2021.Model.ConferenceCitation;
import com.stir.cscu9t4assignment2021.Model.JournalCitation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.awt.*;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;



/*** IMPORT CLASS **/
public class importController {


    private File file;

    /** Import From XML (not Finished)**/
//    public void ImportFileXML() {
//
//        try {
//            //Setting the FileChoose
//            JFileChooser chooserTab = new JFileChooser();
//            FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                    "XML doc", "xml");
//            chooserTab.setFileFilter(filter);
//
//
//            int returnVal = chooserTab.showOpenDialog(null);
//            if (returnVal == JFileChooser.APPROVE_OPTION) {
//                file = chooserTab.getSelectedFile();
//            }
//            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//            Document doc = documentBuilder.parse(file);
//            doc.getDocumentElement().normalize();
//
//            XPath xPath = XPathFactory.newInstance().newXPath();
//            XPathExpression citationTypeQuery = xPath.compile("/*/ref/@citationType");
//            NodeList nList = (NodeList) citationTypeQuery.evaluate(doc, XPathConstants.NODESET);
//            for (int i = 0; i < nList.getLength(); i++) {
//                Node no = nList.item(i);
//                System.out.println(no);
//
//            }
//            NodeList nodeList = doc.getElementsByTagName("citation");
//
//
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                Node node = nodeList.item(i);
//
//                System.out.println("\nNode Name :" + node.getNodeName());
//
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//                    Element e = (Element) node;
//                    System.out.println((e.getAttribute("ref")));
//                    System.out.println("Student id: " + e.getElementsByTagName("title").item(0).getTextContent());
//                    System.out.println("First Name: " + e.getElementsByTagName("authors").item(0).getTextContent());
//                    System.out.println("Last Name: " + e.getElementsByTagName("doi").item(0).getTextContent());
//                    System.out.println("Subject: " + e.getElementsByTagName("publisher").item(0).getTextContent());
//                    System.out.println("Marks: " + e.getElementsByTagName("publicationYear").item(0).getTextContent());
//                    String title = e.getElementsByTagName("title").item(0).getTextContent();
//                    String authors = e.getElementsByTagName("authors").item(0).getTextContent();
//
//                    String doi = e.getElementsByTagName("doi").item(0).getTextContent();
//                    String publisher = e.getElementsByTagName("publisher").item(0).getTextContent();
//                    String publicationyear = e.getElementsByTagName("publicationYear").item(0).getTextContent();
//                    String dateAdded = e.getElementsByTagName("dateAdded").item(0).getTextContent();
//
//                    String JournalName = e.getElementsByTagName("journal").item(0).getTextContent();
//                    String bookName = e.getElementsByTagName("book").item(0).getTextContent();
//                    String location = e.getElementsByTagName("location").item(0).getTextContent();
//                    String venue = e.getElementsByTagName("venue").item(0).getTextContent();
//
//
//                }
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    /*** Import form CSV **/
    public void ImportFileCSV() {



        String title = null, authors = null, year = null, publisher = null, doi = null, date = null, nameOfConference=null,journal = null, venue = null, location = null, bookTitle = null, editor = null, volume = null, issue = null;
        //Setting the header for comparison purpose
        String [] onlyBJournalHeader = {"title","authors","year","publisher","doi","date","journal","volume","issue"};
        String [] onlyBookHeader ={"title","authors","year","publisher","doi","date","bookTitle","editor"};
        String [] onlyConferenceHeader ={"title","authors","year","publisher","doi","date","venue","location"};

        String [] allHeaders ={"title","authors","year","publisher","doi","date","journal","volume","issue","venue","location","bookTitle","editor"};

        try {
            JFileChooser chooserTab = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "csv doc", "csv");
            chooserTab.setFileFilter(filter);


            Component parent = null;
            int returnVal = chooserTab.showOpenDialog(parent);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = chooserTab.getSelectedFile(); //grabbing the file
            }


            BufferedReader reader = new BufferedReader(new FileReader(file)); // reading the file
            String line = null;
            //Object[] row = new Object[12];
            int length = 0;
            Object[] allrows = new Object[12];
            final String[] header;
            int lenght = 0;
            String[] finalLineAllHeaders = new String[12];

            String[] finalLineJournal = new String[8];
            String[] finalLineConfernece = new String[7];
            String[] finalLineBook = new String[7];

            if((line = reader.readLine()) != null) {
                header = line.split(",", -1);

                while ((line = reader.readLine()) != null) {
                    lenght++;
                    finalLineAllHeaders = line.split(",", -1);


                    /***all TYPES ***/
                    if(Arrays.equals(header,allHeaders)) {
                        title = finalLineAllHeaders[0];
                        authors = finalLineAllHeaders[1];
                        year = finalLineAllHeaders[2];
                        publisher = finalLineAllHeaders[3];
                        doi = finalLineAllHeaders[4];
                        date = finalLineAllHeaders[5];

                        journal = finalLineAllHeaders[6];

                        volume = finalLineAllHeaders[7];
                        issue = finalLineAllHeaders[8];


                        venue = finalLineAllHeaders[9];
                        location = finalLineAllHeaders[10];

                        if (finalLineAllHeaders.length == 13) {
                            bookTitle = finalLineAllHeaders[11];
                            editor = finalLineAllHeaders[12];
                        }

                        if (journal == "") {
                            journal = " ";
                        }
                        if (volume == "") {
                            volume = "0";
                        }
                        if (issue == "") {
                            issue = "0";
                        }
                        if (venue == "") {
                            venue = " ";
                        }
                        if (location == "") {
                            location = " ";
                        }
                        if (bookTitle == "") {
                            bookTitle = " ";
                        }


                        if (editor == " ") {
                            editor = " ";
                        }
                       //for journal check 6,7,8
                        if (!finalLineAllHeaders[6].equals("") && !finalLineAllHeaders[7].equals("") & !finalLineAllHeaders[8].equals("")) { //journal

                            String[] authorsArray = authors.split(";");

                            DateFormat sourceFormat = new SimpleDateFormat("d/M/yyyy");
                            Date finalDate = sourceFormat.parse(date);

                            CitationController newJournalCit = new CitationController();
                            JournalCitation collectionOfCitation = new JournalCitation(title, authorsArray, doi, publisher, journal, Integer.parseInt(year), finalDate, Integer.parseInt(volume), Integer.parseInt(issue));
                            newJournalCit.addCitation(collectionOfCitation);

                            //for conference check array element 9,10
                        } else if (!finalLineAllHeaders[9].equals("") && !finalLineAllHeaders[10].equals("")) { //Conference

                            String[] authorsArray = authors.split(";");

                            DateFormat sourceFormat = new SimpleDateFormat("d/M/yyyy");
                            Date finalDate = sourceFormat.parse(date);

                            CitationController newConferenceCitation = new CitationController();
                            ConferenceCitation collectionOfCitation = new ConferenceCitation(title, authorsArray, doi, publisher, venue, Integer.parseInt(year), finalDate, location);
                            newConferenceCitation.addCitation(collectionOfCitation);
                            //for book check array element 11,12
                        } else if (!finalLineAllHeaders[11].equals("") && !finalLineAllHeaders[12].equals("")) {//book

                            String[] authorsArray = authors.split(";");

                            DateFormat sourceFormat = new SimpleDateFormat("d/M/yyyy");
                            Date finalDate = sourceFormat.parse(date);

                            CitationController newBookCit = new CitationController();
                            BookCitation collectionOfCitation = new BookCitation(title, authorsArray, doi, publisher, bookTitle, Integer.parseInt(year), finalDate, editor);
                            newBookCit.addCitation(collectionOfCitation);
                        }


                    }


                //for JOURNAL ONLY check
                else if(Arrays.equals(header,onlyBJournalHeader)){ //if the document is Only Journal
                        title = finalLineAllHeaders[0];
                        authors = finalLineAllHeaders[1];
                        year = finalLineAllHeaders[2];
                        publisher = finalLineAllHeaders[3];
                        doi = finalLineAllHeaders[4];
                        date = finalLineAllHeaders[5];

                        journal = finalLineAllHeaders[6];

                        volume = finalLineAllHeaders[7];
                        issue = finalLineAllHeaders[8];

                        String[] authorsArray = authors.split(";");

                        DateFormat sourceFormat = new SimpleDateFormat("d/M/yyyy");
                        Date finalDate = sourceFormat.parse(date);

                        CitationController newJournalCit = new CitationController();
                        JournalCitation collectionOfCitation = new JournalCitation(title, authorsArray, doi, publisher, journal, Integer.parseInt(year), finalDate, Integer.parseInt(volume), Integer.parseInt(issue));
                        newJournalCit.addCitation(collectionOfCitation);


                }
                //fOr conference only Check
                else if(Arrays.equals(header,onlyConferenceHeader)){ //if the document is Ony Conference
                        title = finalLineAllHeaders[0];
                        authors = finalLineAllHeaders[1];
                        year = finalLineAllHeaders[2];
                        publisher = finalLineAllHeaders[3];
                        doi = finalLineAllHeaders[4];
                        date = finalLineAllHeaders[5];

                        venue = finalLineAllHeaders[6];
                        location = finalLineAllHeaders[7];


                        String[] authorsArray = authors.split(";");

                        DateFormat sourceFormat = new SimpleDateFormat("d/M/yyyy");
                        Date finalDate = sourceFormat.parse(date);
                        CitationController newConferenceCitation = new CitationController();
                        ConferenceCitation collectionOfCitation = new ConferenceCitation(title, authorsArray, doi, publisher, venue, Integer.parseInt(year), finalDate, location);
                        newConferenceCitation.addCitation(collectionOfCitation);
                }
                //FOR BOOK ONLY IMPORT
                else if(Arrays.equals(header,onlyBookHeader)){ //if the document is Only Book
                        title = finalLineAllHeaders[0];
                        authors = finalLineAllHeaders[1];
                        year = finalLineAllHeaders[2];
                        publisher = finalLineAllHeaders[3];
                        doi = finalLineAllHeaders[4];
                        date = finalLineAllHeaders[5];

                        bookTitle = finalLineAllHeaders[6];
                        editor = finalLineAllHeaders[7];


                        String[] authorsArray = authors.split(";");

                        DateFormat sourceFormat = new SimpleDateFormat("d/M/yyyy");
                        Date finalDate = sourceFormat.parse(date);
                        CitationController newBookCit = new CitationController();
                        BookCitation collectionOfCitation = new BookCitation(title, authorsArray, doi, publisher, bookTitle, Integer.parseInt(year), finalDate, editor);
                        newBookCit.addCitation(collectionOfCitation);

                }


                }
            }



        } catch (ParseException exception) {
            exception.printStackTrace();
        } catch (FileNotFoundException notFoundException) {
            notFoundException.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (Exception e) {
            e.getStackTrace();
        }

    }


}








