package com.gn.springbasics.mrs.exp14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecommenderImplementation {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CollaborativeFilter collaborativeFilter;

    public RecommenderImplementation(CollaborativeFilter filter) {
        this.collaborativeFilter = filter;
    }

    public Filter getFilter() {
        return collaborativeFilter;
    }

    //use a filter to find recommendations
    public String[] recommendMovies(String movie) {

        String[] results = collaborativeFilter.getRecommendations("Finding Dory");
        return results;
    }

}
