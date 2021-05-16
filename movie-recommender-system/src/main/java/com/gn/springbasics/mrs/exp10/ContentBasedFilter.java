package com.gn.springbasics.mrs.exp10;

import com.gn.springbasics.mrs.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Primary
@Qualifier("CBF")
public class ContentBasedFilter implements Filter {
    private static int instances = 0;
    private static Logger logger = LoggerFactory.getLogger(ContentBasedFilter.class);
    @Autowired
    private Movie movie;

    public ContentBasedFilter(Movie movie) {
        super();
        this.movie = movie;
        instances++;
        logger.info("content-based filter constructor called");
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("In ContentBasedFilter postConstruct method...");
    }

    public static int getInstancesCreated() {
        return ContentBasedFilter.instances;
    }

    public Movie getMovie() {
        return movie;
    }

    public String[] getRecommendations(String movie) {

        //implement logic of content based filter

        //return movie recommendations
        return new String[]{"CBF-M1", "CBF-M2", "CBF-M3"};
    }

}
