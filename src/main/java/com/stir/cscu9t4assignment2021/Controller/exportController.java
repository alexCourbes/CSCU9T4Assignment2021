package com.stir.cscu9t4assignment2021.Controller;
/**
 *
 * @author 2822236
 */
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/** export controller class **/
public class exportController {



    public void exportToTXT() throws IOException {


        File txtFile = null;

        /**USER PATH TO SAVE TXT DOC**/
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save to TXT");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "TXT doc", "txt"); //we will save it as txt
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
             txtFile = fileChooser.getSelectedFile();

        }


        //new file writtes
        FileWriter myWriter = new FileWriter(txtFile);

        CitationController getAllcits = new CitationController();

        String[] cit = getAllcits.getCitationsToString();// Get all the citations as a String array (from Citation Controller)


        for (int i =0 ; i<cit.length;i++){
            myWriter.write(cit[i]);
            myWriter.write('\n');
        }
        myWriter.close();

    }
}
