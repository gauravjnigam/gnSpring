package com.gn.springbasics.mrs.exp14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollaborativeFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(CollaborativeFilter.class);

    public CollaborativeFilter() {
        super();
        logger.info("Collaborative filter constructor called");
    }

    public String[] getRecommendations(String movie) {
        //logic of content based filter
        return new String[]{"CF-M1", "CF-M1", "CF-M1"};
    }
}
