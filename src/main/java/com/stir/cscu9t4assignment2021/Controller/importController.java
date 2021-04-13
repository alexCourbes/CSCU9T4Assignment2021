package com.stir.cscu9t4assignment2021.Controller;

import com.stir.cscu9t4assignment2021.Model.BookCitation;
import com.stir.cscu9t4assignment2021.Model.Citation;
import com.stir.cscu9t4assignment2021.Model.ConferenceCitation;
import com.stir.cscu9t4assignment2021.Model.JournalCitation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.awt.*;
import java.awt.print.Book;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class importController {


    private File file;

    public void ImportFileXML() {

        try {
            //Setting the FileChoose
            JFileChooser chooserTab = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "XML doc", "xml");
            chooserTab.setFileFilter(filter);


            Component parent = null;
            int returnVal = chooserTab.showOpenDialog(parent);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = chooserTab.getSelectedFile();
            }
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(file);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();
            XPathExpression citationTypeQuery = xPath.compile("/*/ref/@citationType");
            NodeList nList = (NodeList) citationTypeQuery.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nList.getLength(); i++) {
                Node no = nList.item(i);
                System.out.println(no);

            }
            NodeList nodeList = doc.getElementsByTagName("citation");


            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                System.out.println("\nNode Name :" + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) node;
                    System.out.println((e.getAttribute("ref")));
                    System.out.println("Student id: " + e.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("First Name: " + e.getElementsByTagName("authors").item(0).getTextContent());
                    System.out.println("Last Name: " + e.getElementsByTagName("doi").item(0).getTextContent());
                    System.out.println("Subject: " + e.getElementsByTagName("publisher").item(0).getTextContent());
                    System.out.println("Marks: " + e.getElementsByTagName("publicationYear").item(0).getTextContent());
                    String title = e.getElementsByTagName("title").item(0).getTextContent();
                    String authors = e.getElementsByTagName("authors").item(0).getTextContent();

                    String doi = e.getElementsByTagName("doi").item(0).getTextContent();
                    String publisher = e.getElementsByTagName("publisher").item(0).getTextContent();
                    String publicationyear = e.getElementsByTagName("publicationYear").item(0).getTextContent();
                    String dateAdded = e.getElementsByTagName("dateAdded").item(0).getTextContent();

                    String JournalName = e.getElementsByTagName("journal").item(0).getTextContent();
                    String bookName = e.getElementsByTagName("book").item(0).getTextContent();
                    String location = e.getElementsByTagName("location").item(0).getTextContent();
                    String venue = e.getElementsByTagName("venue").item(0).getTextContent();


                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ImportFileCSV() {


        String title = null, authors = null, year = null, publisher = null, doi = null, date = null, journal = null, venue = null, location = null, bookTitle = null, editor = null, volume = null, issue = null;

        try {
            JFileChooser chooserTab = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "csv doc", "csv");
            chooserTab.setFileFilter(filter);


            Component parent = null;
            int returnVal = chooserTab.showOpenDialog(parent);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = chooserTab.getSelectedFile();
            }


            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            //Object[] row = new Object[12];
            int length = 0;
            Object[] allrows = new Object[12];

            int lenght = 0;
            String[] finalLine = new String[12];


            while ((line = reader.readLine()) != null) {
                lenght++;
                finalLine = line.split(",", -1);


                /***all TYPES ***/

                title = finalLine[0];
                authors = finalLine[1];
                year = finalLine[2];
                publisher = finalLine[3];
                doi = finalLine[4];
                date = finalLine[5];

                journal = finalLine[6];
                volume = finalLine[7];
                issue = finalLine[8];


                venue = finalLine[9];
                location = finalLine[10];

                if (finalLine.length == 13) {
                    bookTitle = finalLine[11];
                    editor = finalLine[12];
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

                if (!finalLine[6].equals("")  && !finalLine[7].equals("") & !finalLine[8].equals("")) { //journal
                    //for journal check 6,7,8
                    String[] authorsArray = authors.split(";");

                    DateFormat sourceFormat = new SimpleDateFormat("d/M/yyyy");
                    Date finalDate = sourceFormat.parse(date);

                    CitationController newJournalCit = new CitationController();
                    JournalCitation collectionOfCitation = new JournalCitation(title, authorsArray,doi,publisher,journal,Integer.parseInt(year), finalDate, Integer.parseInt(volume), Integer.parseInt(issue));
                    newJournalCit.addCitation(collectionOfCitation);


                } else if (!finalLine[9].equals("") && !finalLine[10].equals("")) { //Conference
                    //for conference check array element 9,10
                    String[] authorsArray = authors.split(";");

                    DateFormat sourceFormat = new SimpleDateFormat("d/M/yyyy");
                    Date finalDate = sourceFormat.parse(date);

                    CitationController newConferenceCitation = new CitationController();
                    ConferenceCitation collectionOfCitation = new ConferenceCitation(title, authorsArray,doi, publisher,location, Integer.parseInt(year), finalDate,venue );
                    newConferenceCitation.addCitation(collectionOfCitation);

                } else if (!finalLine[11].equals("") && !finalLine[12].equals("")) {//book
                    //for book check array element 11,12
                    String[] authorsArray = authors.split(";");

                    DateFormat sourceFormat = new SimpleDateFormat("d/M/yyyy");
                    Date finalDate = sourceFormat.parse(date);

                    CitationController newBookCit = new CitationController();
                    BookCitation collectionOfCitation = new BookCitation(title, authorsArray, doi, publisher,bookTitle, Integer.parseInt(year), finalDate, editor);
                    newBookCit.addCitation(collectionOfCitation);
                }


            }




        } catch (ParseException exception) {
            exception.printStackTrace();
        } catch (FileNotFoundException notFoundException) {
            notFoundException.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }


//                if(finalLine){
//                    //for Conference check 9,10
//                    JournalCitation collectionOfCitation = new JournalCitation(title, authors, digitalObjectIdentifier, nameOfPublisher, yearOfPublication, dateAdded, nameOfJournal, issue, volume)
//                }
//                if(finalLine){
//                    //for Conference check 11,12
//                    JournalCitation collectionOfCitation = new JournalCitation(title, authors, digitalObjectIdentifier, nameOfPublisher, yearOfPublication, dateAdded, nameOfJournal, issue, volume)
//                }


        /**for book only , Journal Only and Conference Only **/
//                if (finalLine.length==){
//
//                } if (finalLine.length==){

//              }


        catch (Exception e) {
            e.getStackTrace();
        }

    }


}








