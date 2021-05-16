package com.gn.springbasics.mrs.exp12;

import com.gn.springbasics.mrs.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RecommenderImplementation {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    @Qualifier("CF")
    private Filter filter;

    public Filter getFilter() {
        return filter;
    }

    //use a filter to find recommendations
    public String [] recommendMovies (String movie) {

        String[] results = filter.getRecommendations("Finding Dory");
        return results;
    }

    @PostConstruct
    public void postConstruct() {
        //initialization code
        logger.info("In RecommenderImplementation postConstruct method");
    }

    @PreDestroy
    public void preDestroy() {
        //cleanup code
        logger.info("In RecommenderImplementation preDestroy method");
    }
}
