package com.gn.springbasics.mrs.exp09;

import com.gn.springbasics.mrs.Filter;
import com.gn.springbasics.mrs.exp10.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("CF")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CollaborativeFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(CollaborativeFilter.class);

    public CollaborativeFilter() {
        super();
        logger.info("Collaborative filter constructor called");
    }

    public String[] getRecommendations(String movie) {
        //logic of content based filter
        return new String[] {"CF-M1", "CF-M1", "CF-M1"};
    }
}
