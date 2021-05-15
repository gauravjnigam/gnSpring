package com.gn.springbasics.mrs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    //use filter interface to select filter
    @Autowired
    @Qualifier("CF")
    private Filter filter;

    //use a filter to find recommendations
    public String [] recommendMovies (String movie) {

        //use content based filter to find similar movies

        String[] results = filter.getRecommendations("Finding Dory");

        //return the results
        //return new String[] {"M1", "M2", "M3"};
        return results;
    }
}
