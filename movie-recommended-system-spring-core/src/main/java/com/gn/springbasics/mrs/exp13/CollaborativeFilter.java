package com.gn.springbasics.mrs.exp13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("CF")
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
