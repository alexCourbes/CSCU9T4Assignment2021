package com.stir.cscu9t4assignment2021.Controller;

import com.stir.cscu9t4assignment2021.Model.Citation;

import java.util.ArrayList;
import java.util.List;

public class CitationController {

    private List<Citation> citationList;

//LIST were we store all citation



    public CitationController(){
        citationList = new ArrayList<Citation>();
    }

    public void addCitation(Citation citation){
        citationList.add(citation);
        System.out.println(citation.getTitle());
    }

}
