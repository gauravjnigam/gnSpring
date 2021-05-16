package com.gn.springbasics.mrs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation2 {

    //use filter interface to select filter
//    @Autowired
//    @Qualifier("CBF")
    private Filter filter;

    //setter injection
    @Autowired
    @Qualifier("contentBasedFilter")
    public void setFilter(Filter filter) {
        this.filter = filter;
        System.out.println("Setter method invoked..");
    }

    //use a filter to find recommendations
    public String [] recommendMovies (String movie) {
        //print the name of interface implementation being used
        System.out.println("\nName of the filter in use: " + filter + "\n");

        //use content based filter to find similar movies

        String[] results = filter.getRecommendations("Finding Dory");

        //return the results
        //return new String[] {"M1", "M2", "M3"};
        return results;
    }
}
