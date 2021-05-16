package com.gn.springbasics.mrs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class RecommenderImplementation {
    private  static Logger logger = LoggerFactory.getLogger(RecommenderImplementation.class);
    //use filter interface to select filter
   // @Autowired
   // @Qualifier("CF")
    private Filter filter;

    @Autowired
    public RecommenderImplementation(@Qualifier("collaborativeFilter")Filter filter){
        this.filter = filter;
        logger.info("constructor is invoked...");

    }

//    @Autowired
//    @Qualifier("collaborativeFilter")
//    public void setFilter(Filter filter) {
//        this.filter = filter;
//        logger.info("Setter is invoked...");
//    }
    @PostConstruct
    public void postConstruct() {
        logger.info("In RecommenderImplementation postConstruct method...");
    }

    @PreDestroy
    public void preDestroy() {
        //cleanup code
        logger.info("In RecommenderImplementation preDestroy method");
    }

    //use a filter to find recommendations
    public String [] recommendMovies (String movie) {
        //print the name of interface implementation being used
        logger.info("Name of the filter in use: {}" ,filter );
        //use content based filter to find similar movies

        String[] results = filter.getRecommendations("Finding Dory");

        //return the results
        //return new String[] {"M1", "M2", "M3"};
        return results;
    }
}
